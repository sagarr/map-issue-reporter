package spring.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Sagar Rohankar
 */
@Configuration
public class JdbcConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource getDataSource() throws NamingException {
        final Context ctx = new InitialContext();
        System.out.println(ctx.lookup("java:comp/env/report/db/driverClass"));
        final DataSource ds = new BasicDataSource();
        return ds;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() throws NamingException {
        return new JdbcTemplate(getDataSource());
    }

}
