package demo.spring.boot.demospringboot.mybatis.vo;


import lombok.Data;


@Data
public class OrderVo {
    private Integer id;
    private int user_id;//  用户id",
    private String title;//   "摘要",
    private String quantity;//  "购买数量",
    private String address;//   "收货地址",
    private String expressFee;//   "配送费",
    private String amount;//   "餐费",
    private String total;//    "总计",
    private int status;//    "0，待付款；1，已付款；2，派送中；-1，已取消",
    private String detail;//    "清单"

}
