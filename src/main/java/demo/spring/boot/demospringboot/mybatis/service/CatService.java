package demo.spring.boot.demospringboot.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.spring.boot.demospringboot.mybatis.dao.CatDAO;
import demo.spring.boot.demospringboot.mybatis.vo.Cat;

@Service
public class CatService {

    @Autowired
    private CatDAO dao;

    public Cat queryById(Integer id) {
        return dao.queryById(id);
    }

    public Integer insert(Cat cat) {
        return dao.insert(cat);
    }

    public Integer update(Cat cat) {
        return dao.updateById(cat);
    }

    public Integer delete(Integer id) {
        return dao.deleteById(id);
    }

}
