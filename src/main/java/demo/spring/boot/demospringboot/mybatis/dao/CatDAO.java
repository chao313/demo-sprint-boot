package demo.spring.boot.demospringboot.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import demo.spring.boot.demospringboot.mybatis.vo.Cat;

@Component
public interface CatDAO {

    Cat queryById(@Param(value = "catId") Integer id);

    Integer insert(Cat cat);

    Integer updateById(Cat cat);

    Integer deleteById(@Param(value = "catId") Integer id);

}
