package com.javadwarf.springcore.ioc1.config;

import com.javadwarf.springcore.ioc1.beans.Cubs;
import com.javadwarf.springcore.ioc1.beans.RedSoxs;
import com.javadwarf.springcore.ioc1.beans.Team;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource(){
        return new DriverManagerDataSource();
    }
}
