package sbitneva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

@Configuration
@ComponentScan(basePackages = "sbitneva")
@PropertySource(value = {"classpath:db.properties"})
public class TestConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));

        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connect!");
        } catch (Exception e) {
            System.out.println("NOT CONNECT!");
        }
        return dataSource;
    }

}



