package spring.config;

import javax.sql.DataSource;

import liquibase.integration.spring.SpringLiquibase;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sagar Rohankar
 */
public class TestConfig {

    @Autowired
    private DataSource dataSource;

    public SpringLiquibase getLiquibase() {
        final SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("IT SHOULD COME FROM LIQUIBASE PROJECT");
        return liquibase;
    }
}
