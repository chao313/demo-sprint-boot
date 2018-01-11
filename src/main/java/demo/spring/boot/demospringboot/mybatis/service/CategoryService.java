package demo.spring.boot.demospringboot.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import demo.spring.boot.demospringboot.mybatis.dao.CategoryDAO;
import demo.spring.boot.demospringboot.mybatis.dao.SellerDAO;
import demo.spring.boot.demospringboot.mybatis.vo.CategoryVo;
import demo.spring.boot.demospringboot.mybatis.vo.SellerVo;

@Service
public class CategoryService {

    @Autowired
    private CategoryDAO dao;

    public List<CategoryVo> queryAll() {
        return dao.queryAll();
    }

    public Integer insert(CategoryVo vo) {
        return dao.insert(vo);
    }

    public Integer update(CategoryVo vo) {
        return dao.updateById(vo);
    }

    public Integer delete(Integer id) {
        return dao.deleteById(id);
    }

}
