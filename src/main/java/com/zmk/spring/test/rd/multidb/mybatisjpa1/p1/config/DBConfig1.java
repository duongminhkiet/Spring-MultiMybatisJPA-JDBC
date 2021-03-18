package com.zmk.spring.test.rd.multidb.mybatisjpa1.p1.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
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

import com.zmk.spring.test.rd.multidb.mybatisjpa1.p1.batis.repository.Employee1MyBatisRepository;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "e1EntityManagerFactory",
        transactionManagerRef = "e1TransactionManager",
        basePackages = {"com.zmk.spring.test.rd.multidb.mybatisjpa1.p1.repository"}
)
public class DBConfig1 {
	public static final String DATASOURCE1 = "datasource1";
    @Primary
    @Bean(name = "datasource1")
    @ConfigurationProperties(prefix = "spring.datasource1")
    public DataSource customerDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Primary
    @Bean(name = "e1EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("datasource1") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.zmk.spring.test.rd.multidb.mybatisjpa1.p1.model")
                .persistenceUnit("db1")
                .build();
    }
	@Bean(name = "e1TransactionManager")
	@Autowired
	@Primary
	DataSourceTransactionManager e1TransactionManager(@Qualifier("datasource1") final DataSource datasource) {
		DataSourceTransactionManager e1TransactionManager = new DataSourceTransactionManager(datasource);
		return e1TransactionManager;
	}
	
	@Bean(name = "sqlServerJPAMybatisJdbcTemplate1")
	public JdbcTemplate sqlServer1JdbcTemplate(@Qualifier("datasource1") DataSource datasource1) {
		return new JdbcTemplate(datasource1);
	}
//  @Primary
//  @Bean(name = "e1TransactionManager")
//  public PlatformTransactionManager customerTransactionManager(
//          @Qualifier("datasource1") EntityManagerFactory
//                  customerEntityManagerFactory
//  ) {
//      return new JpaTransactionManager(customerEntityManagerFactory);
//  }
	//mybatis 
			private static final String EMPLOYEE1_SESSION_FACTORY = "employee1SessionFactory";
			@Bean(name = EMPLOYEE1_SESSION_FACTORY, destroyMethod = "")
//			@Primary
			public SqlSessionFactoryBean sqlSessionFactory(@Qualifier(DBConfig1.DATASOURCE1) final DataSource oneDataSource)
					throws Exception {
				final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
				sqlSessionFactoryBean.setDataSource(oneDataSource);
				SqlSessionFactory sqlSessionFactory;
				sqlSessionFactory = sqlSessionFactoryBean.getObject();
				sqlSessionFactory.getConfiguration().addMapper(Employee1MyBatisRepository.class);
				// Various other SqlSessionFactory settings
				return sqlSessionFactoryBean;
			}
			@Bean
			public MapperFactoryBean<Employee1MyBatisRepository> etrMapper(
					@Qualifier(EMPLOYEE1_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
				MapperFactoryBean<Employee1MyBatisRepository> factoryBean = new MapperFactoryBean<>(
						Employee1MyBatisRepository.class);
				factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
				return factoryBean;
			}
	
}
