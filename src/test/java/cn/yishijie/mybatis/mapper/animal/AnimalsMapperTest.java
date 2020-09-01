package cn.yishijie.mybatis.mapper.animal;

import cn.yishijie.mybatis.domain.animal.AnimalsEntity;
import cn.yishijie.mybatis.mapper.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalsMapperTest extends BaseTest {
 
    @Autowired
    private AnimalsMapper animalsMapper;

    @Test
    @Override
    public void baseTest(){
        // 添加数据
        AnimalsEntity animalsEntity = new AnimalsEntity();
        animalsEntity.setName("monkey");
        int addRows = animalsMapper.saveAnimal(animalsEntity);
        assert addRows > 0;

        List<AnimalsEntity> mon = animalsMapper.getAnimalByNameLikeAndIdAfter("mon", animalsEntity.getId());
        assert  mon.size() == 1 && mon.get(0).getName().equals("monkey");

        List<AnimalsEntity> animalsEntities = animalsMapper.getAnimalByNameLike("mo");
        assert animalsEntities.size() == 1;
        assert  animalsEntities.get(0).getName().equals("monkey");

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
        List<AnimalsEntity> saveAnimalsEntities = new ArrayList<>();
        for(int index = 0; index < randomCnt; index++){
            AnimalsEntity tempAnimal = new AnimalsEntity();
            tempAnimal.setName(index+"");
            saveAnimalsEntities.add(tempAnimal);
        }
        animalsMapper.saveAnimals(saveAnimalsEntities);
        List<AnimalsEntity> animals = animalsMapper.getAllAnimals();
        assert animals.size() == randomCnt;

        int delAllCnt = animalsMapper.deleteAll();
        assert delAllCnt > 0;

        List<AnimalsEntity> allAnimals = animalsMapper.getAllAnimals();
        assert  allAnimals.isEmpty();


    }
}