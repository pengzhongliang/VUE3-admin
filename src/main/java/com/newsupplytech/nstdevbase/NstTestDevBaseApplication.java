package com.newsupplytech.nstdevbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Bill Lee
 */
@SpringBootApplication
@EnableCaching
@EnableScheduling
public class NstTestDevBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(NstTestDevBaseApplication.class, args);
    }

}
