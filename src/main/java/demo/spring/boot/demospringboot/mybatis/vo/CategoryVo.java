package demo.spring.boot.demospringboot.mybatis.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CategoryVo {
    private Integer id;
    private String title;
    private String priority;
    private Date createTime;
    private Date updateTime;
}
