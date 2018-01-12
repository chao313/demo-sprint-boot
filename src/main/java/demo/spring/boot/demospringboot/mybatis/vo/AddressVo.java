package demo.spring.boot.demospringboot.mybatis.vo;

import java.util.Date;

import lombok.Data;


@Data
public class AddressVo {
    private String id;//
    private String userId;//
    private String name;//'名字',
    private Integer gender;//'1:先生，0:女生',
    private String mobile;//'手机号码',
    private String detail;//'详细地址',
    private String area;// '区域',
    private Date createTime;// '创建时间',
    private Date updateTime;// '更新时间',

}
