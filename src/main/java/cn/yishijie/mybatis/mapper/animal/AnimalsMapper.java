package cn.yishijie.mybatis.mapper.animal;

import cn.yishijie.mybatis.domain.animal.AnimalsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AnimalsMapper {

    List<AnimalsEntity> getAllAnimals();

    AnimalsEntity getAnimalById(long id);

    int saveAnimal(AnimalsEntity animalsEntity);

    int updateAnimal(AnimalsEntity animalsEntity);

    int deleteAnimal(@Param("id") long id);

    int deleteAll();
}
