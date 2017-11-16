package demo.spring.boot.demospringboot.controller.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import demo.spring.boot.demospringboot.service.JpaService;
import demo.spring.boot.demospringboot.vo.JpaVo;
import io.swagger.annotations.Api;

@Api(value = "Jpa-API", produces = "application/json")
@RestController
public class JpaController {

    @Autowired
    private JpaService jpaService;


    @GetMapping(value = "/add")
    public JpaVo add(@RequestParam(value = "name") String name,
                     @RequestParam(value = "password") String password) {

        return jpaService.insert(new JpaVo(name, password));
    }

    @GetMapping(value = "/findAll")
    public List<JpaVo> findAll() {

        return jpaService.findAll();
    }


    /**
     * 拓展查询
     */
    @GetMapping(value = "/findByName/{name}")
    public List<JpaVo> extendJpaFindByName(@PathVariable(value = "name") String name) {

        return jpaService.findByName(name);
    }

    /**
     * 拓展多条件查询
     */
    @GetMapping(value = "/findByName/{id}/{name}")
    public List<JpaVo> extendJpaFindByNameAndId(@PathVariable(value = "id") Integer id,
                                                @PathVariable(value = "name") String name) {

        return jpaService.findByNameAndId(name, id);
    }


}
