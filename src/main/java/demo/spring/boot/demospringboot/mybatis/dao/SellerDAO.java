package demo.spring.boot.demospringboot.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import demo.spring.boot.demospringboot.mybatis.vo.SellerVo;

@Component
public interface SellerDAO {

    SellerVo queryById(@Param(value = "sellerId") Integer id);

    Integer insert(SellerVo cat);

    Integer updateById(SellerVo cat);

    Integer deleteById(@Param(value = "sellerId") Integer id);

}
