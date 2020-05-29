
package tmall.springboot.practice.config;

import com.tmall.anno.annoHandler.AuthFilter;
import tmall.springboot.practice.Interceptor.LoginInterceptor;
import tmall.springboot.practice.Interceptor.OtherInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//必须在这里进行配置
@Configuration
class WebMvcConfigurerTmp implements WebMvcConfigurer {

	@Bean
	public OtherInterceptor getOtherIntercepter() {
		return new OtherInterceptor();
	}
	@Bean
	public LoginInterceptor getLoginIntercepter() {
		return new LoginInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(getOtherIntercepter())
				.addPathPatterns("/**");
		registry.addInterceptor(getLoginIntercepter())
				.addPathPatterns("/**");
		registry.addInterceptor(getAuthFilter())
				.addPathPatterns("/**");
	}

	//这里只是将ajax的拿到了。
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//所有请求都允许跨域
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("*")
				.allowedHeaders("*");
	}

	@Bean
	public AuthFilter getAuthFilter() {
		return new AuthFilter();
	}

}


