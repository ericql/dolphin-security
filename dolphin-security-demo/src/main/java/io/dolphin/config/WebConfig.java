package io.dolphin.config;

import io.dolphin.web.filter.TimeFilter;
import io.dolphin.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-10-11 20:02
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    //@Bean
    //public FilterRegistrationBean timeFilter() {
    //    final FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
    //
    //    final TimeFilter timeFilter = new TimeFilter();
    //    registrationBean.setFilter(timeFilter);
    //
    //    final List<String> urls = new ArrayList<>();
    //    urls.add("/*");
    //    registrationBean.setUrlPatterns(urls);
    //
    //    return registrationBean;
    //}
}
