package demo.spring.boot.demospringboot.service.jpa;

import org.springframework.data.repository.CrudRepository;

import demo.spring.boot.demospringboot.vo.JpaVo;

public interface CRUDJpa extends CrudRepository<JpaVo,Integer> {
}
