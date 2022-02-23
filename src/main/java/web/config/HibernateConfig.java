package web.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import web.model.User;

import java.util.Properties;


@org.springframework.context.annotation.Configuration
public class HibernateConfig {

    private final static String CONNECTION_URL = "jdbc:mysql://localhost:3306/kata_db";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "123456";
    private final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private final static String HIBERNATE_DIALECT = "org.hibernate.dialect.MySQLDialect";

    //Connect by HIBERNATE
    public static SessionFactory getSessionFactory() {

        try {
            Class.forName(DRIVER_NAME);
            Properties prop = new Properties();
            prop.setProperty("hibernate.connection.url", CONNECTION_URL);
            prop.setProperty("hibernate.connection.username", USER_NAME);
            prop.setProperty("hibernate.connection.password", PASSWORD);
            prop.setProperty("hibernate.dialect", HIBERNATE_DIALECT);
            prop.setProperty("hibernate.current_session_context_class", "thread");
            prop.setProperty("hibernate.hbm2ddl.auto", "update");
            prop.setProperty("show_sql", "true");


            Configuration configuration = new Configuration()
                    .addProperties(prop)
                    .addAnnotatedClass(User.class);

            ServiceRegistry sr = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            return configuration.buildSessionFactory(sr);
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

}
