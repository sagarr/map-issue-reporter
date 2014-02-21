package spring.config;

import javax.sql.DataSource;

import liquibase.integration.spring.SpringLiquibase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Sagar Rohankar
 */
@Configuration
@Import(WebConfig.class)
public class TestConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SpringLiquibase getLiquibase() {
        final SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:setup-db.xml");
        return liquibase;
    }
}
