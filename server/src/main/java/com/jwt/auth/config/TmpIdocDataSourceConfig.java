package com.jwt.auth.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableMBeanExport(registration=RegistrationPolicy.IGNORE_EXISTING)
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.jwt.auth.dao.oracle.accord",
        entityManagerFactoryRef = "tmpIdocEntityManagerFactory",
        transactionManagerRef = "tmpIdocTransactionManager"
)
public class TmpIdocDataSourceConfig {
    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix="datasource.accord")
    public DataSourceProperties tmpIdocDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix="datasource.accord")
    public DataSource tmpIdocDataSource() {
        DataSourceProperties tmpIdocDataSourceProperties = tmpIdocDataSourceProperties();


        DataSource ds=DataSourceBuilder.create()
                .driverClassName(tmpIdocDataSourceProperties.getDriverClassName())
                .url(tmpIdocDataSourceProperties.getUrl())
                .username(tmpIdocDataSourceProperties.getUsername())
                .password(tmpIdocDataSourceProperties.getPassword())
                .build();
        ((com.zaxxer.hikari.HikariDataSource) ds).setMaximumPoolSize(1);
        return ds;
    }

    @Bean
    public PlatformTransactionManager tmpIdocTransactionManager()
    {
        EntityManagerFactory factory = tmpIdocEntityManagerFactory().getObject();
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(factory);
        return transactionManager;
    }


    @Bean(name = "tmpIdocEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean tmpIdocEntityManagerFactory()
    {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(tmpIdocDataSource());
        factory.setPackagesToScan(new String[]{"com.jwt.auth.model.oracle.accord"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setJpaProperties(additionalProperties());
        return factory;

    }

    @Bean
    public DataSourceInitializer tmpIdocDataSourceInitializer()
    {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(tmpIdocDataSource());
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        dataSourceInitializer.setDatabasePopulator(databasePopulator);
        dataSourceInitializer.setEnabled(env.getProperty("datasource.tmpIdoc.initialize", Boolean.class, false));
        return dataSourceInitializer;
    }


    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

        return properties;
    }

    @Bean
    public OpenEntityManagerInViewFilter tmpIdocOpenEntityManagerInViewFilter(){
        OpenEntityManagerInViewFilter osivFilter = new OpenEntityManagerInViewFilter();
        osivFilter.setEntityManagerFactoryBeanName("tmpIdocEntityManagerFactory");
        return osivFilter;
    }

}
