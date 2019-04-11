package com.hollysys.hiadsp.uaa.config.db;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@Order(-20)
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix="datasource")
    public DataSource primaryDataSource() {
    	DataSource ds = DataSourceBuilder.create().type(DruidDataSource.class).build();
        return ds; 
    }
}