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

import java.util.Date;
import java.util.List;

import demo.spring.boot.demospringboot.mybatis.service.AddressService;
import demo.spring.boot.demospringboot.mybatis.service.FoodService;
import demo.spring.boot.demospringboot.mybatis.vo.AddressVo;
import demo.spring.boot.demospringboot.mybatis.vo.FoodVo;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping(value = "/queryById/{id}")
    public AddressVo queryById(@PathVariable(value = "id") Integer id) {
        return service.queryById(id);
    }

    @GetMapping(value = "/queryByUserId/{userId}")
    public List<AddressVo> queryByUserId(@PathVariable(value = "userId") Integer id) {
        return service.queryByUserId(id);
    }

    @PostMapping(value = "/insert")
    public boolean insert(@RequestBody AddressVo vo) {
        vo.setUpdateTime(new Date());
        vo.setCreateTime(new Date());
        return service.insert(vo);
    }

    @PutMapping(value = "/updateById")
    public Integer updateById(@RequestBody AddressVo vo) {
        vo.setUpdateTime(new Date());
        return service.update(vo);
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean deleteById(@PathVariable(value = "id") Integer id) {
        return service.delete(id);
    }
}
