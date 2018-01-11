package demo.spring.boot.demospringboot.mybatis.vo;

import java.util.Date;

import lombok.Data;


@Data
public class FoodVo {
    private Integer id;
    private String title;// "菜名",
    private String thumbUrl;// "菜图",
    private String summary;// "简述",
    private Integer priority;// "优先级",
    private String price;// "价格",
    private Date createTime;// "创建时间",
    private Date updateTime;// "更新时间"
}
