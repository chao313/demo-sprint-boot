package demo.spring.boot.demospringboot.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

import demo.spring.boot.demospringboot.mybatis.vo.AddressVo;
import demo.spring.boot.demospringboot.mybatis.vo.FoodVo;

@Component
public interface AddressDAO {

    AddressVo queryById(@Param(value = "addressId") Integer id);

    List<AddressVo> queryByUserId(@Param(value = "userId") Integer userId);

    Integer insert(AddressVo vo);

    Integer updateById(AddressVo vo);

    Integer deleteById(@Param(value = "addressId") Integer id);

}
