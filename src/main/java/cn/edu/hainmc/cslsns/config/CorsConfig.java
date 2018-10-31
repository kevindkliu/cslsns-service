package cn.edu.hainmc.cslsns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 为解决跨域问题 对系统后台进行跨域访问进行配置
 */
@Configuration
public class CorsConfig {

	/**
	 * 实例化WebMvcConfigurer接口
	 *
	 * @return
	 */
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*")// 1 设置访问源地址
						.allowCredentials(true)// 2 设置访问源请求头
						.allowedMethods("GET", "POST", "DELETE", "PUT") // 3 设置访问源请求方法
						.maxAge(3600);
			}
		};
	}

}
