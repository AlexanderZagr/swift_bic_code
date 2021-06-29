package com.jwt.auth.config;
import com.jwt.auth.dao.oracle.ibank.SwiftBicIbankDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
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
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.jwt.auth.dao.oracle.ibank",
        basePackageClasses = SwiftBicIbankDao.class,
        entityManagerFactoryRef = "ibankEntityManagerFactory",
        transactionManagerRef = "ibankTransactionManager"
)
public class IbankDataSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix="datasource.ibank")
    public DataSourceProperties ibankDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("datasource.ibank.configuration")
    public DataSource ibankDataSource() {
        DataSourceProperties ibankDataSourceProperties = ibankDataSourceProperties();

        //System.out.println("!!!"+ibankDataSourceProperties.getDriverClassName());
        //System.out.println("!!!"+ibankDataSourceProperties.getUrl());
        //System.out.println("!!!"+ibankDataSourceProperties.getUsername());
       // System.out.println("!!!"+ibankDataSourceProperties.getPassword());
        //System.out.println("!!!"+ibankDataSourceProperties.getPassword());


        return DataSourceBuilder.create()
                .driverClassName(ibankDataSourceProperties.getDriverClassName())
                .url(ibankDataSourceProperties.getUrl())
                .username(ibankDataSourceProperties.getUsername())
                .password(ibankDataSourceProperties.getPassword())
                .build();
    }

    @Bean
    public PlatformTransactionManager ibankTransactionManager()
    {

       // EntityManagerFactory factory = ibankEntityManagerFactory().getObject();
        //return new JpaTransactionManager(factory);

        EntityManagerFactory factory = ibankEntityManagerFactory().getObject();
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(factory);
        return transactionManager;
    }


    @Bean(name = "ibankEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean ibankEntityManagerFactory()
    {

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(ibankDataSource());
        factory.setPackagesToScan(new String[]{"com.jwt.auth.model.oracle.ibank"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setJpaProperties(additionalProperties());

        return factory;

    }

    @Bean
    public DataSourceInitializer ibankDataSourceInitializer()
    {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(ibankDataSource());
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        // databasePopulator.addScript(new ClassPathResource("orders-data.sql"));
        dataSourceInitializer.setDatabasePopulator(databasePopulator);
        dataSourceInitializer.setEnabled(env.getProperty("datasource.ibank.initialize", Boolean.class, false));
        return dataSourceInitializer;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

        return properties;
    }

    @Bean
    public OpenEntityManagerInViewFilter ibankOpenEntityManagerInViewFilter(){

        OpenEntityManagerInViewFilter osivFilter = new OpenEntityManagerInViewFilter();
        osivFilter.setEntityManagerFactoryBeanName("ibankEntityManagerFactory");
        return osivFilter;
    }
}
