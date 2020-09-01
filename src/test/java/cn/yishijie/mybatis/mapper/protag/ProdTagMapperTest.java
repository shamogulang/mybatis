package cn.yishijie.mybatis.mapper.protag;

import cn.yishijie.mybatis.domain.protag.ProdTagEntity;
import cn.yishijie.mybatis.mapper.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.sql.Timestamp;
import java.util.List;

public class ProdTagMapperTest extends BaseTest {

    @Autowired
    private ProdTagMapper prodTagMapper;

    /**
     *  因为存入数据库的时间和对象里的时间会有一点区别，所以一些将时间也参与
     *  的查询和删除会不成功
     * （对象）2020-09-01 10:50:37.672  && （数据库）2020-09-01 10:50:38
     */
    @Test
    @Override
    public void baseTest() {
        // 保存数据
        ProdTagEntity prodTagEntity = new ProdTagEntity();
        prodTagEntity.setName("tag0");
        // 如果为null,因为数据库中已经设置了不为null
        // 的限制，这里会报错
        prodTagEntity.setValue("tagValue0");
        prodTagEntity.setStatus((byte)0);
        prodTagEntity.setType((byte)0);
        prodTagEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        // 不管设置什么值，这里都会按照对象中的数据进行插入到数据库中
        int insertRows = prodTagMapper.insert(prodTagEntity);
        assert insertRows > 0;
        // insertSelective插入可以为null,为null的属性不参数插入操作
        prodTagEntity.setId(null);
        prodTagEntity.setValue(null);
        prodTagEntity.setName("tag1");
        int addRows = prodTagMapper.insertSelective(prodTagEntity);
        assert addRows > 0;

        // 查询数据
        ProdTagEntity queryEntity = new ProdTagEntity();
        queryEntity.setName("tag0");
        List<ProdTagEntity> prodTagEntities = prodTagMapper.select(queryEntity);
        assert prodTagEntities.size() == 1
                && prodTagEntities.get(0).getName().equals("tag0");

        Example example = new Example(ProdTagEntity.class);
        example.createCriteria()
                .andEqualTo("id",prodTagEntity.getId());
        List<ProdTagEntity> prodTagEntities1 = prodTagMapper.selectByExample(example);
        assert prodTagEntities1.get(0).getId() == prodTagEntity.getId();

        Example example1 = new Example(ProdTagEntity.class);
        example1.createCriteria()
                .andEqualTo("type",0);
        int rowCnts = prodTagMapper.selectCountByExample(example1);
        assert rowCnts == 2;

        // 修改数据
        prodTagEntity.setValue("修改了");
        // 为null的属性也会被修改
        int updateRows = prodTagMapper.updateByPrimaryKey(prodTagEntity);
        assert updateRows > 0;
        // 为null的属性不被修改
        prodTagEntity.setValue("修改了0");
        int updateRows1 = prodTagMapper.updateByPrimaryKeySelective(prodTagEntity);
        assert updateRows1 > 0;

        // 删除数据
        int deleteRows = prodTagMapper.delete(queryEntity);
        assert deleteRows > 0;
    }
}
