package cn.yishijie.mybatis.mapper.animal;

import cn.yishijie.mybatis.domain.animal.AnimalsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AnimalsMapper {
    List<AnimalsEntity> getAllAnimals();
}
