package demo.spring.boot.demospringboot.mybatis.vo;

import lombok.Data;


@Data
public class SellerVo {
    private Integer id;
    private String name;//店名
    private String logoUrl;//头像
    private String telephone;//联系电话
    private String address;//地址
    private String notice;//公告
    private String bussinessStart;//开始营业时间
    private String bussinessEnd;//结束营业时间
    private Integer expressFee;//配送费
    private Integer minAmount;//起送金额
}
