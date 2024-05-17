package com.saltyfish.config;

import com.saltyfish.framework.security.config.AuthorizeRequestsCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @Description: security配置
 * @Author: 番薯(Amos)
 * @date: 2024/1/31/16:58
 */
@Configuration(proxyBeanMethods = false, value = "generatorSecurityConfiguration")
public class SecurityConfiguration {

	@Value("${spring.boot.admin.context-path:''}")
	private String adminSeverContextPath;

	@Bean("generatorAuthorizeRequestsCustomizer")
	public AuthorizeRequestsCustomizer authorizeRequestsCustomizer() {
		return new AuthorizeRequestsCustomizer() {

			@Override
			public void customize(
					ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry) {
				// Swagger 接口文档
				registry.antMatchers("/v3/api-docs/**")
					.permitAll()
					.antMatchers("/swagger-ui.html")
					.permitAll()
					.antMatchers("/swagger-ui/**")
					.permitAll()
					.antMatchers("/swagger-resources/**")
					.anonymous()
					.antMatchers("/webjars/**")
					.anonymous()
					.antMatchers("/*/api-docs")
					.anonymous();
				// Spring Boot Actuator 的安全配置
				registry.antMatchers("/actuator").anonymous().antMatchers("/actuator/**").anonymous();
				// Druid 监控
				registry.antMatchers("/druid/**").anonymous();
				// Spring Boot Admin Server 的安全配置
				registry.antMatchers(adminSeverContextPath)
					.anonymous()
					.antMatchers(adminSeverContextPath + "/**")
					.anonymous();
				// 文件读取
				registry.antMatchers(buildAdminApi("/infra/file/*/get/**")).permitAll();
			}

		};
	}

}
