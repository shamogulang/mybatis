package cn.yishijie.mybatis.mapper.animal;

import cn.yishijie.mybatis.domain.animal.AnimalsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AnimalsMapper {

    List<AnimalsEntity> getAllAnimals();

    List<AnimalsEntity> getAnimalByNameLike(String name);

    AnimalsEntity getAnimalById(long id);

    List<AnimalsEntity> getAnimalByNameLikeAndIdAfter(@Param("name") String name,@Param("id") long id);

    int saveAnimal(AnimalsEntity animalsEntity);

    int saveAnimals(@Param("animals") List<AnimalsEntity> animals);

    int updateAnimal(AnimalsEntity animalsEntity);

    int deleteAnimal(@Param("id") long id);

    int deleteAll();
}
