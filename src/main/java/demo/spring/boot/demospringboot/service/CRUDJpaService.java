package demo.spring.boot.demospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.spring.boot.demospringboot.service.jpa.CRUDJpa;
import demo.spring.boot.demospringboot.vo.JpaVo;

@Service
public class CRUDJpaService {

    @Autowired
    private CRUDJpa crudJpa;

    /**
     * 根据id 查询
     */
    public JpaVo findOne(Integer id) {
        return crudJpa.findOne(id);
    }

    /**
     * 根据id 删除
     */
    public void delete(Integer id) {
        crudJpa.delete(id);
    }

    /**
     * 根据id 增加
     */
    public JpaVo add(JpaVo vo) {
       return crudJpa.save(vo);
    }

    /**
     * 根据id 改
     */
    public JpaVo update(JpaVo vo) {
        return crudJpa.save(vo);
    }

}
