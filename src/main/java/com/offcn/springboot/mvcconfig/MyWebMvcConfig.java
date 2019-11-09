package com.offcn.springboot.mvcconfig;

import com.offcn.springboot.InterCeptor.MyInterCeptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//使用我们自己定义的类来替代我们的配置文件
//@Configuration
public class MyWebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //注册.添加视图控制器
        registry.addViewController("/").setViewName("login.html");
        registry.addViewController("index.html").setViewName("login.html");
}

    //给我们的项目添加一个拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
//       registry.addInterceptor(new MyInterCeptor()).excludePathPatterns("login.html","register.html");
    }
}
