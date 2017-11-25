package demo.spring.boot.demospringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@Configuration//相当于一个xml文件
public class RedisConfig {

    @Value("${redis.url.nodes}")
    private String redisUrl;


    /**
     * 创建一个redis集群
     */
    @Bean
    public JedisCluster createJedis() {

        Set<HostAndPort> nodes = new HashSet<>();
        String[] nodesString = redisUrl.split(",");
        for (String nodeString : nodesString) {
            String[] tmp = nodeString.split(":");
            String host = tmp[0];//主机
            Integer port = Integer.parseInt(tmp[1]);//端口号
            HostAndPort hostAndPort = new HostAndPort(host, port);
            nodes.add(hostAndPort);
        }

        return new JedisCluster(nodes);
    }
}
