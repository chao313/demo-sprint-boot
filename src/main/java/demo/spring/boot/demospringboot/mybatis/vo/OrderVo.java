package demo.spring.boot.demospringboot.mybatis.vo;


import java.util.Date;

import lombok.Data;


@Data
public class OrderVo {
    private Integer id;
    private Integer userId;//  用户id",
    private Integer addressId;//
    private String title;//   "摘要",
    private Integer quantity;//  "购买数量",
    private String expressFee;//   "配送费",
    private String amount;//   "餐费",
    private String total;//    "总计",
    private Integer status;//    "0，待付款；1，已付款；2，派送中；-1，已取消",
    private String detail;//    "清单"
    private String cartsString;//购物车 - 字符串
    private Date createTime;// "创建时间",
    private Date updateTime;// "更新时间"
}
