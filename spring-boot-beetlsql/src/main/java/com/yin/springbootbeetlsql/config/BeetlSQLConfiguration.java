package com.yin.springbootbeetlsql.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class BeetlSQLConfiguration {
   @ConfigurationProperties(prefix = "spring.datasource.druid")
   @Bean
   public DataSource dataSource(){
      return new DruidDataSource();
   }

   @Bean
   public SqlKitHolder sqlKitHolder() {
      return new SqlKitHolder();
   }
//   @Bean(initMethod = "init", name = "beetlConfig")
//   public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
//      BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
//      ResourcePatternResolver patternResolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
//      // WebAppResourceLoader 配置root路径是关键
//      //WebAppResourceLoader webAppResourceLoader = new WebAppResourceLoader(patternResolver.getResource("classpath:/sql").getFile().getPath());
//      WebAppResourceLoader webAppResourceLoader = new WebAppResourceLoader();
//      beetlGroupUtilConfiguration.setResourceLoader(webAppResourceLoader);
//
//      //读取配置文件信息
//      return beetlGroupUtilConfiguration;
//   }

}