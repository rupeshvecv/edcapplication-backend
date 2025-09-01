/*
 * package com.edcapplication.user.db.config;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.boot.autoconfigure.jdbc.DataSourceProperties; import
 * org.springframework.boot.context.properties.ConfigurationProperties; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.data.jpa.repository.config.EnableJpaRepositories; import
 * org.springframework.orm.jpa.JpaTransactionManager; import
 * org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean; import
 * org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter; import
 * org.springframework.transaction.PlatformTransactionManager;
 * 
 * import jakarta.persistence.EntityManagerFactory;
 * 
 * @Configuration
 * 
 * @EnableJpaRepositories( basePackages = "com.empoweredge.repository",
 * entityManagerFactoryRef = "userEntityManagerFactory", transactionManagerRef =
 * "userTransactionManager" ) public class UserDBConfig {
 * 
 * @Bean
 * 
 * @ConfigurationProperties("spring.datasource.user") public
 * DataSourceProperties userDataSourceProperties() { return new
 * DataSourceProperties(); }
 * 
 * @Bean public DataSource userDataSource() { return
 * userDataSourceProperties().initializeDataSourceBuilder().build(); }
 * 
 * @Bean public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(
 * 
 * @Qualifier("userDataSource") DataSource dataSource) {
 * LocalContainerEntityManagerFactoryBean em = new
 * LocalContainerEntityManagerFactoryBean(); em.setDataSource(dataSource);
 * em.setPackagesToScan("com.empoweredge.model");
 * em.setPersistenceUnitName("User"); em.setJpaVendorAdapter(new
 * HibernateJpaVendorAdapter()); return em; }
 * 
 * @Bean public PlatformTransactionManager userTransactionManager(
 * 
 * @Qualifier("userEntityManagerFactory") EntityManagerFactory
 * userEntityManagerFactory) { return new
 * JpaTransactionManager(userEntityManagerFactory); } }
 */