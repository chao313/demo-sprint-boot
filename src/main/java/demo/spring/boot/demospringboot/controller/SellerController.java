package demo.spring.boot.demospringboot.controller;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.spring.boot.demospringboot.mybatis.service.SellerService;
import demo.spring.boot.demospringboot.mybatis.vo.SellerVo;

@RestController
@RequestMapping(value = "/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping(value = "/queryById/{id}")
    public SellerVo queryById(@PathVariable(value = "id") Integer id) {
        return sellerService.queryById(id);
    }

    @PostMapping(value = "/insert")
    public Integer queryById(@RequestBody SellerVo cat) {
        return sellerService.insert(cat);
    }

    @PutMapping(value = "/update")
    public Integer updateById(@RequestBody SellerVo cat) {
        return sellerService.update(cat);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Integer deleteById(@PathVariable(value = "id") Integer id) {
        return sellerService.delete(id);
    }
}
