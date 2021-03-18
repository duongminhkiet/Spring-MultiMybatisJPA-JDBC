package com.zmk.spring.test.rd.multidb.mybatisjpa1.p2.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "e2EntityManagerFactory",
        transactionManagerRef = "e2TransactionManager",
        basePackages = {"com.zmk.spring.test.rd.multidb.mybatisjpa1.p2.repository"}
)
public class DBConfig2 {
	private static final String DATASOURCE2 = "datasource2";
//    @Primary
    @Bean(name = DATASOURCE2)
    @ConfigurationProperties(prefix = "spring.datasource2")
    public DataSource customerDataSource() {
        return DataSourceBuilder.create().build();
    }
//    @Primary
    @Bean(name = "e2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier(DATASOURCE2) DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.zmk.spring.test.rd.multidb.mybatisjpa1.p2.model")
                .persistenceUnit("db2")
                .build();
    }
	@Bean(name = "e2TransactionManager")
	@Autowired
//	@Primary
	DataSourceTransactionManager e1TransactionManager(@Qualifier(DATASOURCE2) final DataSource datasource) {
		DataSourceTransactionManager e1TransactionManager = new DataSourceTransactionManager(datasource);
		return e1TransactionManager;
	}
	
	@Bean(name = "sqlServerJPAMybatisJdbcTemplate2")
	public JdbcTemplate sqlServer1JdbcTemplate(@Qualifier(DATASOURCE2) DataSource datasource1) {
		return new JdbcTemplate(datasource1);
	}
}
