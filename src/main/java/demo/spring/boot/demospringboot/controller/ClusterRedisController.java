package demo.spring.boot.demospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.spring.boot.demospringboot.redis.ClusterRedisService;

@RestController
public class ClusterRedisController {

    @Autowired
    private ClusterRedisService clusterRedisService;

    @GetMapping(value = "/cluster-redis")
    public String clusterRedis() {
        return clusterRedisService.clusterRedis();
    }
}
