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

import demo.spring.boot.demospringboot.mybatis.service.FoodService;
import demo.spring.boot.demospringboot.mybatis.vo.FoodVo;
import demo.spring.boot.demospringboot.mybatis.vo.SellerVo;

@RestController
@RequestMapping(value = "/food")
public class FoodController {

    @Autowired
    private FoodService service;

    @GetMapping(value = "/queryAll")
    public List<FoodVo> queryAll() {
        return service.queryAll();
    }

    @GetMapping(value = "/queryById/{id}")
    public FoodVo queryById(@PathVariable(value = "id") Integer id) {
        return service.queryById(id);
    }

    @GetMapping(value = "/queryByCategoryId/{categoryId}")
    public List<FoodVo> queryByCategoryId(@PathVariable(value = "categoryId") Integer id) {
        return service.queryByCategoryId(id);
    }

    @PostMapping(value = "/insert")
    public Integer queryById(@RequestBody FoodVo vo) {
        return service.insert(vo);
    }

    @PutMapping(value = "/update")
    public Integer updateById(@RequestBody FoodVo vo) {
        return service.update(vo);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Integer deleteById(@PathVariable(value = "id") Integer id) {
        return service.delete(id);
    }
}
