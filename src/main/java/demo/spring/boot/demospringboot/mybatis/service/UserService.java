package demo.spring.boot.demospringboot.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import demo.spring.boot.demospringboot.mybatis.dao.FoodDAO;
import demo.spring.boot.demospringboot.mybatis.dao.UserDAO;
import demo.spring.boot.demospringboot.mybatis.vo.FoodVo;
import demo.spring.boot.demospringboot.mybatis.vo.UserVo;


@Service
public class UserService {

    @Autowired
    private UserDAO dao;

    public List<UserVo> queryAll() {
        return dao.queryAll();
    }

    public UserVo queryById(Integer id) {
        return dao.queryById(id);
    }

    public List<UserVo> queryByRole(Integer id) {
        return dao.queryByRole(id);
    }

    public Integer insert(UserVo vo) {
        return dao.insert(vo);
    }

    public Integer update(UserVo vo) {
        return dao.updateById(vo);
    }

    public Integer delete(Integer id) {
        return dao.deleteById(id);
    }

}
