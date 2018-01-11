package demo.spring.boot.demospringboot.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.spring.boot.demospringboot.mybatis.dao.SellerDAO;
import demo.spring.boot.demospringboot.mybatis.vo.SellerVo;

@Service
public class SellerService {

    @Autowired
    private SellerDAO dao;

    public SellerVo queryById(Integer id) {
        return dao.queryById(id);
    }

    public Integer insert(SellerVo cat) {
        return dao.insert(cat);
    }

    public Integer update(SellerVo cat) {
        return dao.updateById(cat);
    }

    public Integer delete(Integer id) {
        return dao.deleteById(id);
    }

}
