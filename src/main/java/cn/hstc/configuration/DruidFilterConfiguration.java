package cn.hstc.configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chen
 * @crete 2021-04-17-15:49
 */
@Configuration
public class DruidFilterConfiguration {


    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        // Servlet 注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        /*
        Map<String,String> initParams = new HashMap<>();

        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        initParams.put("allow","");//默认就是允许所有访问
        //initParams.put("allow", "localhost")：表示只有本机可以访问
        initParams.put("deny","");
		//设置初始化参数
        servletRegistrationBean.setInitParameters(initParams);
		*/

        // IP 白名单
        servletRegistrationBean.addInitParameter("allow", "");
        // IP 黑名单，allow 与 deny 共同存在时，deny 优先于 allow
        servletRegistrationBean.addInitParameter("deny", "");
        // 设置控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "root");
        servletRegistrationBean.addInitParameter("loginPassword", "hstc2017");
        // 是否支持重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");


        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        // 创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        // 设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        // 忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}