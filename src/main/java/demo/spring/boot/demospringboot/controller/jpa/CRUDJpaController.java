package demo.spring.boot.demospringboot.controller.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.spring.boot.demospringboot.service.CRUDJpaService;
import demo.spring.boot.demospringboot.vo.JpaVo;
import io.swagger.annotations.Api;

@Api(value = "Jpa-API", produces = "application/json")
@RestController
public class CRUDJpaController {


    @Autowired
    private CRUDJpaService crudJpaService;

    @GetMapping(value = "/crud-find/{id}")
    public JpaVo find(@PathVariable(value = "id") Integer id) {
        return crudJpaService.findOne(id);
    }

    @PostMapping(value = "/crud-add/{name}/{password}")
    public JpaVo add(@PathVariable(value = "name") String name,
                     @PathVariable(value = "password") String password) {
        return crudJpaService.add(new JpaVo(name, password));
    }

    @PutMapping(value = "/crud-put/{name}/{password}")
    public JpaVo update(@PathVariable(value = "name") String name,
                        @PathVariable(value = "password") String password) {
        return crudJpaService.update(new JpaVo(name, password));
    }

    @DeleteMapping(value = "/crud-delete/{id}")
    public void delete(@PathVariable(value = "id") Integer id) {
        crudJpaService.delete(id);
    }

}
