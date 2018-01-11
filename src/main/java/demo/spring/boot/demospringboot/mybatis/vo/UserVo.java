package demo.spring.boot.demospringboot.mybatis.vo;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserVo {
    private Integer id;
    private String name;
    private String password;
    private String nickName;
    private String phone;
    private Integer gender;//'1：男，2：女',
    private String avatarUrl;//'头像',
    private Integer role;//'0：普通用户；1：管理员；2：超级管理员',
    private Date createTime;
    private Date UpdateTime;
}
