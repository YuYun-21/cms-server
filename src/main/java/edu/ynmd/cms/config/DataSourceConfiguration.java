package edu.ynmd.cms.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {
    //    这里设置了该Bean的destroyMethod
//    = ""是为了防止停止服务器时容器管理器两次销毁导致的异常
//    ，name = "EmbeddeddataSource"用于在自动装配Bean时与其他dataSource加以区分。
    @Bean(destroyMethod = "", name = "EmbeddeddataSource")
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
//有空的话试试存成路径的
        //数据库文件位置
        dataSourceBuilder.url("jdbc:sqlite:" + "cms.sqlite");
        dataSourceBuilder.type(SQLiteDataSource.class);
        return dataSourceBuilder.build();
    }
}
