package com.clemble.server.tag.spring;

import com.clemble.casino.server.spring.WebBootSpringConfiguration;
import com.clemble.casino.server.spring.common.ClembleBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by mavarazy on 3/31/15.
 */
@Configuration
@Import({ WebBootSpringConfiguration.class, TagSpringConfiguration.class })
public class TagApplication implements ClembleBootApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TagApplication.class, args);
    }

}
