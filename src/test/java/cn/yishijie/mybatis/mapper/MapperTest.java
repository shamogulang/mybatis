package cn.yishijie.mybatis.mapper;

import cn.yishijie.MybatisApplication;
import cn.yishijie.mybatis.domain.animal.AnimalsEntity;
import cn.yishijie.mybatis.mapper.animal.AnimalsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = MybatisApplication.class)
public class MapperTest {
 
    @Autowired
    private AnimalsMapper animalsMapper;
 
    @Test
    public void getAllAnimals() throws Exception {
        List<AnimalsEntity> animalsEntities = animalsMapper.getAllAnimals();

        System.out.println(animalsEntities);
    }
}