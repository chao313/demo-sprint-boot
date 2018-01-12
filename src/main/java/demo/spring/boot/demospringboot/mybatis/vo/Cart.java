package demo.spring.boot.demospringboot.mybatis.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Cart implements Serializable {
    private String title;//标题
    private String price;//价格
    private String quantity;//数量
}
