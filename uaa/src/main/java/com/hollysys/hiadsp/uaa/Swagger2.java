package com.hollysys.hiadsp.uaa;

import static com.google.common.base.Predicates.or;
import static com.google.common.base.Predicates.and;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.PathSelectors.ant;
import io.swagger.annotations.Api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

//	@Bean
//	public Docket createRestApi() {
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.hollysys.hiadsp.uaa"))
//				.paths(PathSelectors.any()).build();
//	}

//	@Bean
//	public Docket allDocket() {
//		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
//				.groupName("all")
//				.select()//<4>
//	            .apis(RequestHandlerSelectors.any())//<5>
//	            .paths(Predicates.not(PathSelectors.regex("/error.*")))//<6>
//				.build();
//		return docket;
//	}
    @Bean
	public Docket allDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
				.groupName("all").select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(or(regex("/sys/.*"),or(regex("/oauth/client/.*")),or(regex("/user/org/.*")),or(regex("/user/role/.*")),or(regex("/role/permission/.*")),or(regex("/user/.*")),or(regex("/tenant/.*"))))
				.build();
		return docket;
	}
	@Bean
	public Docket sysDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
				.groupName("sys").select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(or(regex("/sys/.*")))
				.build();
		return docket;
	}
	@Bean
	public Docket oauthDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
				.groupName("oauth").select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(or(regex("/oauth/client/.*")))
				.build();
		return docket;
	}
	
	@Bean
	public Docket permissionDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
				.groupName("user/org").select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(or(regex("/user/org/.*")))
				.build();
		return docket;
	}
	@Bean
	public Docket userRoleDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
				.groupName("user/role").select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(or(regex("/user/role/.*")))
				.build();
		return docket;
	}
	@Bean
	public Docket rolePermissionDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
				.groupName("role/permission").select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(or(regex("/role/permission/.*")))
				.build();
		return docket;
	}
	@Bean
	public Docket tenantUserDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
				.groupName("user").select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(or(regex("/user/.*")))
				.build();
		return docket;
	}
//	@Bean
//	public Docket allDocket() {
//		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
//				.groupName("all").select()
//				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//				.paths(or(regex("/*/.*")))
//				.build();
//		return docket;
//	}

	private ApiInfo getApiInfo() {
		ApiInfoBuilder builder = new ApiInfoBuilder();
		return builder.title("工业云服务平台 用户中心").description("工业云服务平台 用户中心项目API接口文档")
				.version("v1.0.0").license("").licenseUrl("").build();
	}
}
