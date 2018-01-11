package demo.spring.boot.demospringboot.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import demo.spring.boot.demospringboot.mybatis.dao.AddressDAO;
import demo.spring.boot.demospringboot.mybatis.dao.FoodDAO;
import demo.spring.boot.demospringboot.mybatis.vo.AddressVo;
import demo.spring.boot.demospringboot.mybatis.vo.FoodVo;


@Service
public class AddressService {

    @Autowired
    private AddressDAO dao;

    public AddressVo queryById(Integer id) {
        return dao.queryById(id);
    }

    public List<AddressVo> queryByUserId(Integer id) {
        return dao.queryByUserId(id);
    }

    public boolean insert(AddressVo vo) {
        return dao.insert(vo) > 0 ? true : false;
    }

    public Integer update(AddressVo vo) {
        return dao.updateById(vo);
    }

    public Integer delete(Integer id) {
        return dao.deleteById(id);
    }

}
