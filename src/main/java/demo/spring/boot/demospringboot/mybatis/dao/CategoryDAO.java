package demo.spring.boot.demospringboot.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

import demo.spring.boot.demospringboot.mybatis.vo.CategoryVo;

@Component
public interface CategoryDAO {
    /**
     * 查询所有的类别
     */
    List<CategoryVo> queryAll();

    /**
     * 添加一个类别
     */
    Integer insert(CategoryVo categoryVo);

    /**
     * 删除
     */
    Integer deleteById(@Param(value = "categoryId") Integer categoryId);

    /**
     * 根据id更新
     */
    Integer updateById(CategoryVo vo);

}
