package web.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
//@EnableTransactionManagement
@ComponentScan("web")
public class JPAConfig {

    private final static String CONNECTION_URL = "jdbc:mysql://localhost:3306/kata_db";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "123456";
    private final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private final static String HIBERNATE_DIALECT = "org.hibernate.dialect.MySQLDialect";
    private final static String SHOW_SQL = "true";
    private final static String HBM_2_DDL = "validate";


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory =
                new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("web");
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setJpaProperties(getHibernateProperties());
        return entityManagerFactory;
    }



    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(DRIVER_NAME);
            dataSource.setJdbcUrl(CONNECTION_URL);
            dataSource.setUser(USER_NAME);
            dataSource.setPassword(PASSWORD);

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", HIBERNATE_DIALECT);
        properties.setProperty("hibernate.show_sql", SHOW_SQL);
        properties.setProperty("hibernate.hbm2ddl.auto", HBM_2_DDL);
        return properties;
    }


//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager manager = new JpaTransactionManager();
//        manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
//        return manager;
//    }

}
