package demo.spring.boot.demospringboot.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

import demo.spring.boot.demospringboot.mybatis.vo.FoodVo;
import demo.spring.boot.demospringboot.mybatis.vo.SellerVo;

@Component
public interface FoodDAO {

    List<FoodVo> queryAll();

    FoodVo queryById(@Param(value = "foodId") Integer id);

    List<FoodVo> queryByCategoryId(@Param(value = "categoryId") Integer categoryId);

    Integer insert(FoodVo vo);

    Integer updateById(FoodVo vo);

    Integer deleteById(@Param(value = "foodId") Integer id);

}
