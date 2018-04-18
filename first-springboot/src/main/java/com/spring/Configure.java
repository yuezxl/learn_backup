package com.spring;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.factory.PathSubscribeFactory;

@Configuration
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
@PropertySource({"classpath:version.properties"})
public class Configure extends WebMvcConfigurerAdapter{
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources("classpath:/mapper/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/").setCachePeriod(0);
		if (!registry.hasMappingForPattern("/webjars/**")) {
			registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		}
	}
	
	@Bean
	public FilterRegistrationBean addEtagFiltlter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		ShallowEtagHeaderFilter etagFilter = new ShallowEtagHeaderFilter();
		filterRegistrationBean.setFilter(etagFilter);
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/person/*");
		filterRegistrationBean.setUrlPatterns(urlPatterns);
		return filterRegistrationBean;
	}
	
	/*@Bean
	public PathSubscribeFactory addPathSubscribeFactory() {
		PathSubscribeFactory pathSubscribeFactory = new PathSubscribeFactory();
		return pathSubscribeFactory;
	}*/
}
