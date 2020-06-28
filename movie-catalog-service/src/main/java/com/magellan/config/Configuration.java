package com.magellan.config;

import com.magellan.service.CatalogService;
import org.springframework.context.annotation.Bean;

public class Configuration {
    @Bean
    public CatalogService getCatalogService(){
        return new CatalogService();
    }

}
