package demo.spring.boot.demospringboot.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

import demo.spring.boot.demospringboot.mybatis.vo.FoodVo;
import demo.spring.boot.demospringboot.mybatis.vo.OrderVo;

@Component
public interface OrderDAO {

    OrderVo queryById(@Param(value = "orderId") Integer id);

    List<OrderVo> queryByUserId(@Param(value = "userId") Integer userId);

    Integer insert(OrderVo vo);

    Integer updateById(OrderVo vo);

    Integer deleteById(@Param(value = "orderId") Integer id);

}
