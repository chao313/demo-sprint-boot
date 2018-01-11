package demo.spring.boot.demospringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import demo.spring.boot.demospringboot.mybatis.service.FoodService;
import demo.spring.boot.demospringboot.mybatis.service.UserService;
import demo.spring.boot.demospringboot.mybatis.vo.FoodVo;
import demo.spring.boot.demospringboot.mybatis.vo.UserVo;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService service;

    @GetMapping(value = "/queryAll")
    public List<UserVo> queryAll() {
        return service.queryAll();
    }

    @GetMapping(value = "/queryById/{id}")
    public UserVo queryById(@PathVariable(value = "id") Integer id) {
        return service.queryById(id);
    }

    @GetMapping(value = "/queryByRole/{role}")
    public List<UserVo> queryByRole(@PathVariable(value = "role") Integer id) {
        return service.queryByRole(id);
    }

    @PostMapping(value = "/insert")
    public Integer insert(@RequestBody UserVo vo) {

        LOGGER.info("请求的vo{}",vo);
        vo.setCreateTime(new Date());
        vo.setUpdateTime(new Date());
        return service.insert(vo);
    }

    @PutMapping(value = "/update")
    public Integer updateById(@RequestBody UserVo vo) {
        return service.update(vo);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Integer deleteById(@PathVariable(value = "id") Integer id) {
        return service.delete(id);
    }
}
