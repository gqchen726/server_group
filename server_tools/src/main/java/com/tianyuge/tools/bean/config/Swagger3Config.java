package com.tianyuge.tools.bean.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class Swagger3Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        StringBuffer description = new StringBuffer();
        /*description
                .append("博客后台接口测试")
                .append("<br />")
                .append("<a href='https://dashboard.heroku.com/apps/boke-server'>heroku明细页</a>")
                .append("<br />")
                .append("<a href='https://www.adminium.io/dashboard'>数据库管理界面</a>")
                .append("<br />")
                .append("<a href='https://app.snyk.io/org/snyk-aerodynamic-79349-heroku/project/41f68233-900d-4ad9-b6c2-48d96f840c43'>依赖漏洞扫描</a>")
                .append("<br />")
                .append("<a href='https://apps.elegantcms.io/content_types'>内容管理</a>")
                .append("<br />")
                .append("<a href='https://dev.filestack.com/apps/AuzXO5sCnQDe7ANDAh6P8z/dashboard/'>文件栈</a>")
                .append("<br />")
                .append("<a href='https://app.logdna.com/d6bb21b5dc/logs/view'>查看日志</a>")*/
        ;
        return new ApiInfoBuilder()
                .title("swagger服务")
                .description(description.toString())
                .version("1.0")
                .build();
    }
}