package com.tianyuge.tools.bean.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author: guoqing.chen01@hand-china.com 2021-12-23 15:47
 **/

@Configuration
@Slf4j
public class DataSourceConfig {


    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    private static String MySqlTemplateUrl = "jdbc:mysql://hostAndDatabases&serverTimezone=UTC&characterEncoding=utf-8";
    @Value("${spring.datasource.url}")
    private String MySqlDbUrl;
    private static String username;
    private static String password;

    @Bean
    public DataSource getDataSource() {
        getConnectionInfo();
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.url(MySqlTemplateUrl);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

    private void getConnectionInfo() {
        String databaseUrl = System.getenv("CLEARDB_DATABASE_URL");
        if (StringUtils.isNoneBlank(databaseUrl)) {
            this.MySqlDbUrl = databaseUrl;
        }
        log.debug("MySqlUrl: {}", MySqlDbUrl);
        if (StringUtils.isNoneBlank(MySqlDbUrl) && MySqlDbUrl.contains("//")) {
            String mysqlUrl = MySqlDbUrl.split("//")[1];
            if (StringUtils.isNoneBlank(mysqlUrl) && mysqlUrl.contains("@")) {
                String[] infos = mysqlUrl.split("@");
                String usernameAndPassword = infos[0];
                if (infos.length > 0) {
                    String[] identityInformationArray = usernameAndPassword.split(":");
                    username = identityInformationArray[0];
                    password = identityInformationArray[1];
                }
                if (infos.length > 1) {
                    String hostAndDatabases = infos[1];
                    MySqlTemplateUrl = MySqlTemplateUrl.replace("hostAndDatabases",hostAndDatabases);
                }

            }

        }

    }
}