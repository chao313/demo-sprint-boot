package demo.spring.boot.demospringboot.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import demo.spring.boot.demospringboot.mybatis.dao.FoodDAO;
import demo.spring.boot.demospringboot.mybatis.vo.FoodVo;


@Service
public class FoodService {

    @Autowired
    private FoodDAO dao;

    public List<FoodVo> queryAll() {
        return dao.queryAll();
    }

    public FoodVo queryById(Integer id) {
        return dao.queryById(id);
    }

    public List<FoodVo> queryByCategoryId(Integer id){
        return dao.queryByCategoryId(id);
    }

    public Integer insert(FoodVo vo) {
        return dao.insert(vo);
    }

    public Integer update(FoodVo vo) {
        return dao.updateById(vo);
    }

    public Integer delete(Integer id) {
        return dao.deleteById(id);
    }

}
