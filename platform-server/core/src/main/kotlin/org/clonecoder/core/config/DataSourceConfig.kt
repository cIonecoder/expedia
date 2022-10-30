//package org.clonecoder.core.config
//
//import com.zaxxer.hikari.HikariConfig
//import com.zaxxer.hikari.HikariDataSource
//import org.slf4j.LoggerFactory
//import org.springframework.beans.factory.annotation.Qualifier
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
//import org.springframework.boot.context.properties.ConfigurationProperties
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.context.annotation.Primary
//import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
//import org.springframework.orm.jpa.JpaTransactionManager
//import org.springframework.transaction.annotation.EnableTransactionManagement
//import javax.sql.DataSource
//
//@EnableAutoConfiguration(exclude = [DataSourceAutoConfiguration::class])
//@EnableTransactionManagement
//@Configuration
//class DataSourceConfig {
//
//    private val log = LoggerFactory.getLogger(this.javaClass)
//
//    @Bean
//    @ConfigurationProperties(prefix = "datasource.hikari")
//    fun dataSourceHikariConfig(): HikariConfig = HikariConfig()
//
//    @Primary
//    @Bean
//    fun primaryDataSource(@Qualifier("dataSourceHikariConfig") config: HikariConfig): DataSource {
//        val hikariDataSource = HikariDataSource(config)
//        return LazyConnectionDataSourceProxy(hikariDataSource)
//    }
//
//    @Bean
//    fun transactionManager(@Qualifier("primaryDataSource") datasource: DataSource): JpaTransactionManager {
//        return JpaTransactionManager().apply { dataSource = datasource }
//    }
//}