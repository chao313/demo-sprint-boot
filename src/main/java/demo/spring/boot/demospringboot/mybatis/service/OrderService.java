package demo.spring.boot.demospringboot.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import demo.spring.boot.demospringboot.mybatis.dao.FoodDAO;
import demo.spring.boot.demospringboot.mybatis.dao.OrderDAO;
import demo.spring.boot.demospringboot.mybatis.vo.FoodVo;
import demo.spring.boot.demospringboot.mybatis.vo.OrderVo;


@Service
public class OrderService {

    @Autowired
    private OrderDAO dao;

    public OrderVo queryById(Integer id) {
        return dao.queryById(id);
    }

    public List<OrderVo> queryByUserId(Integer id) {
        return dao.queryByUserId(id);
    }

    public boolean insert(OrderVo vo) {
        return dao.insert(vo) > 0 ? true : false;
    }

    public boolean update(OrderVo vo) {
        return dao.updateById(vo) > 0 ? true : false;
    }

    public boolean delete(Integer id) {
        return dao.deleteById(id) > 0 ? true : false;
    }

}
