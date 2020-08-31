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
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = MybatisApplication.class)
public class MapperTest {
 
    @Autowired
    private AnimalsMapper animalsMapper;

    @Test
    public void baseTest(){
        // 添加数据
        AnimalsEntity animalsEntity = new AnimalsEntity();
        animalsEntity.setName("monkey");
        int addRows = animalsMapper.saveAnimal(animalsEntity);
        assert addRows > 0;

        // 查询数据
        AnimalsEntity animal = animalsMapper.getAnimalById(animalsEntity.getId());
        assert animal != null && animalsEntity.getName().equals(animal.getName());

        // 更新数据
        String animalName = "bird";
        animal.setName(animalName);
        int effectRows = animalsMapper.updateAnimal(animal);
        assert effectRows > 0;

        AnimalsEntity updateAnimal = animalsMapper.getAnimalById(animalsEntity.getId());
        assert animalName.equals(updateAnimal.getName());

        // 删除数据
        int deleteRows = animalsMapper.deleteAnimal(animalsEntity.getId());
        assert deleteRows > 0;

        int randomCnt = new Random().nextInt(10) + 1;
        for(int index = 0; index < randomCnt; index++){
            AnimalsEntity tempAnimal = new AnimalsEntity();
            tempAnimal.setName(index+"");
            animalsMapper.saveAnimal(tempAnimal);
        }
        List<AnimalsEntity> animals = animalsMapper.getAllAnimals();
        assert animals.size() == randomCnt;

        int delAllCnt = animalsMapper.deleteAll();
        assert delAllCnt > 0;

        List<AnimalsEntity> allAnimals = animalsMapper.getAllAnimals();
        assert  allAnimals.isEmpty();
    }
}