package com.example.mybatis.domain;

import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

@Mapper
@CacheConfig(cacheNames = "users")
public interface UserMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT ID, NAME, AGE FROM USER")
    List<User> findAll();

    @Cacheable(key = "#p0")
    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name, jdbcType=VARCHAR}, #{age, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insertByUser(User user);

    @Delete("DELETE FROM USER WHERE id=#{id}")
    void delete(Long id);

    @Delete("DELETE FROM USER WHERE name=#{name}")
    void deleteByName(String name);

    @CachePut(key = "#p0.name")
    @Update("UPDATE USER SET age=#{age} WHERE name=#{name}")
    void update(User user);
}