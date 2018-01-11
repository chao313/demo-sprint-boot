package demo.spring.boot.demospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import demo.spring.boot.demospringboot.mybatis.service.CategoryService;
import demo.spring.boot.demospringboot.mybatis.service.SellerService;
import demo.spring.boot.demospringboot.mybatis.vo.CategoryVo;
import demo.spring.boot.demospringboot.mybatis.vo.SellerVo;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping(value = "/queryAll")
    public List<CategoryVo> queryAll() {
        return service.queryAll();
    }

    @PostMapping(value = "/insert")
    public Integer queryById(@RequestBody CategoryVo categoryVo) {
        return service.insert(categoryVo);
    }

    @PutMapping(value = "/update")
    public Integer updateById(@RequestBody CategoryVo categoryVo) {
        return service.update(categoryVo);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Integer deleteById(@PathVariable(value = "id") Integer id) {
        return service.delete(id);
    }
}
