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

    @Bean(destroyMethod = "close")
    public DataSource getDataSource() throws NamingException {
        final Context ctx = new InitialContext();
        final BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName((String)ctx.lookup("java:comp/env/report/db/driverClass"));
        ds.setUrl((String)ctx.lookup("java:comp/env/report/db/url"));
        ds.setUsername((String)ctx.lookup("java:comp/env/report/db/user"));
        ds.setPassword((String)ctx.lookup("java:comp/env/report/db/password"));
        return ds;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() throws NamingException {
        return new JdbcTemplate(getDataSource());
    }

}
