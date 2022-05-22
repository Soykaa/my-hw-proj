package ru.java.hse.sd.model.hibernate;

import org.flywaydb.core.Flyway;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Information about database sessions.
 **/
public class Storage {
    private static SessionFactory sessionFactory;

    private static SessionFactory create() throws HibernateException {
        Flyway flyway = Flyway.configure()
                .baselineOnMigrate(true)
                .dataSource("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres")
                .locations("classpath:db/migration")
                .load();
        flyway.migrate();
        Configuration cfg = new Configuration();
        cfg.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        cfg.setProperty("hibernate.connection.username", "postgres");
        cfg.setProperty("hibernate.connection.password", "postgres");
        cfg.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        cfg.addAnnotatedClass(Attempt.class);
        cfg.addAnnotatedClass(Checker.class);
        cfg.addAnnotatedClass(Homework.class);
        return cfg.buildSessionFactory();
    }

    /**
     * Returns session factory.
     *
     * @return session factory
     * @throws HibernateException in case of creation error
     **/
    public static synchronized SessionFactory getSessionFactory() throws HibernateException {
        if (sessionFactory == null) {
            sessionFactory = create();
        }
        return sessionFactory;
    }
}