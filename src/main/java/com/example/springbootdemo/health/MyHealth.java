package com.example.springbootdemo.health;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author: Leon
 * @CreateDate: 2017/7/28
 * @Description:
 * @Version: 1.0.0
 */
@Component
public class MyHealth implements HealthIndicator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyHealth.class);

    private static Random random = new Random();

    @Override
    public Health health() {
        LOGGER.info("MongoDbHealth -> health");
        int r = random.nextInt();
        Health health = null;
        if (r % 2 == 0) {
            health = Health.up().withDetail("result", "It is ok.").build();
        } else {
            health = Health.down().withDetail("result", "It is bad.").build();
        }
        return health;
    }
}
