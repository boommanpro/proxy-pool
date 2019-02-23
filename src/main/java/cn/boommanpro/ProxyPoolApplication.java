package cn.boommanpro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.InetAddress;
import java.net.UnknownHostException;
@Slf4j
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ProxyPoolApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProxyPoolApplication.class, args);
        //打印出web端口 方便使用浏览器打开
        try {
            String host = InetAddress.getLocalHost().getHostAddress();
            TomcatServletWebServerFactory tomcatFactory = (TomcatServletWebServerFactory) context.getBean("tomcatServletWebServerFactory");
            int port = tomcatFactory.getPort();
            String contextPath = tomcatFactory.getContextPath();
            String path = "http://" + host + ":" + port + contextPath + "/" ;
            log.info("http web 服务启动完毕.... 地址为:------------   {}",  path);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
