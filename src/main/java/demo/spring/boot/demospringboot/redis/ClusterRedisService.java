package demo.spring.boot.demospringboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisCluster;

@Service
public class ClusterRedisService {

    @Autowired
    private JedisCluster jedisCluster;

    public String clusterRedis(){

        return "这个是redis集群";
    }
}
