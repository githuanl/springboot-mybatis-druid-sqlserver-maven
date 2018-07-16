package com.centersoft.entity;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by liudong on 2018/7/12.
 */

@Mapper
public interface CityMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") // 设置id自动增长
    int save(City city);

    City selectById(Integer id);

    int updateById(City user);

    int deleteById(Integer id);

    List<City> queryAll();

    @Select("select * from city")
    public List<City> findAll();
}

