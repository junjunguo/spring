package com.junjunguo.spring.config;

import com.junjunguo.spring.knights.BraveKnight;
import com.junjunguo.spring.knights.Knight;
import com.junjunguo.spring.knights.Quest;
import com.junjunguo.spring.knights.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}
