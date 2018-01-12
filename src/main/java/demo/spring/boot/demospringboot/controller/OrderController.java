package demo.spring.boot.demospringboot.controller;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import demo.spring.boot.demospringboot.framework.request.OrderBo;

import demo.spring.boot.demospringboot.mybatis.service.OrderService;
import demo.spring.boot.demospringboot.mybatis.vo.Cart;
import demo.spring.boot.demospringboot.mybatis.vo.OrderVo;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService service;

    @GetMapping(value = "/queryById/{id}")
    public OrderBo queryById(@PathVariable(value = "id") Integer id) {
        OrderVo vo = service.queryById(id);
        OrderBo reqponseBo = new OrderBo();
        BeanUtils.copyProperties(vo, reqponseBo);
        JSONArray json = JSONArray.fromObject(vo.getCartsString());//userStr是json字符串
        Cart[] carts = (Cart[]) JSONArray.toArray(json, Cart.class);
        reqponseBo.setCarts(carts);
        return reqponseBo;
    }

    @GetMapping(value = "/queryByUserId/{userId}")
    public List<OrderBo> queryByUserId(@PathVariable(value = "userId") Integer id) {
        List<OrderVo> orderVos = service.queryByUserId(id);
        List<OrderBo> orderBos = new ArrayList<>();
        for (OrderVo vo : orderVos) {
            JSONArray json = JSONArray.fromObject(vo.getCartsString());//userStr是json字符串
            Cart[] carts = (Cart[]) JSONArray.toArray(json, Cart.class);
            OrderBo bo = new OrderBo();
            BeanUtils.copyProperties(vo, bo);
            bo.setCarts(carts);
            orderBos.add(bo);
        }
        return orderBos;
    }

    @PostMapping(value = "/insert")
    public boolean insert(@RequestBody OrderBo vo) {
        JSONArray cartsJson = JSONArray.fromObject(vo.getCarts());
        String cartsString = cartsJson.toString();
        OrderVo orderVo = new OrderVo();
        BeanUtils.copyProperties(vo, orderVo);
        orderVo.setCartsString(cartsString);
        orderVo.setCreateTime(new Date());
        orderVo.setUpdateTime(new Date());
        LOGGER.info("ordervo{}", orderVo);
        return service.insert(orderVo);
    }

    @PutMapping(value = "/updateById")
    public boolean updateById(@RequestBody OrderVo vo) {
        return service.update(vo);
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean deleteById(@PathVariable(value = "id") Integer id) {
        return service.delete(id);
    }
}
