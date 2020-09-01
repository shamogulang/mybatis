package cn.yishijie.mybatis.mapper.common;

import cn.yishijie.mybatis.domain.animal.AnimalsEntity;
import cn.yishijie.mybatis.mapper.BaseTest;
import cn.yishijie.mybatis.mapper.animal.AnimalsMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PageHelperTest extends BaseTest {

    @Autowired
    private AnimalsMapper animalsMapper;
    @Test
    @Override
    public void baseTest() {
        List<AnimalsEntity> animalsEntities = new ArrayList<>();
        for(int start = 0; start < 30; start++){
            AnimalsEntity animalsEntity = AnimalsEntity.builder().name("jeff" + start).build();
            animalsEntities.add(animalsEntity);
        }
        animalsMapper.saveAnimals(animalsEntities);

        // 测试分页插件
        PageHelper.startPage(1, 10);
        List<AnimalsEntity> allAnimals = animalsMapper.getAllAnimals();
        PageInfo<AnimalsEntity> animalsEntityPages = new PageInfo<>(allAnimals);
        long total = animalsEntityPages.getTotal();
        assert total == 30 && animalsEntityPages.getList().size() == 10;

        int deleteRows = animalsMapper.deleteAll();
        assert deleteRows == 30;
    }
}
