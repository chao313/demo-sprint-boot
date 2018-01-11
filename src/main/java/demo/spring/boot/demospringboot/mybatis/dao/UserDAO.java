package demo.spring.boot.demospringboot.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

import demo.spring.boot.demospringboot.mybatis.vo.UserVo;

@Component
public interface UserDAO {
    List<UserVo> queryAll();

    UserVo queryById(@Param(value = "userId") Integer id);

    List<UserVo> queryByRole(@Param(value = "role") Integer role);

    Integer insert(UserVo vo);

    Integer updateById(UserVo vo);

    Integer deleteById(@Param(value = "userId") Integer id);
}
