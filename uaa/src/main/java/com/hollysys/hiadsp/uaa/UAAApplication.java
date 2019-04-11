package com.hollysys.hiadsp.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.SessionAttributes;

@EnableTransactionManagement
@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@SessionAttributes("authorizationRequest")
@RefreshScope
@EnableDiscoveryClient
//@ComponentScan(basePackages ="com.hollysys.hiadsp.uaa")

public class UAAApplication {
    public static void main(String[] args) {
	SpringApplication.run(UAAApplication.class, args);
    }

//    @Bean
//    public EmbeddedServletContainerFactory servletContainer() {
//
//      TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
//
//          @Override
//          protected void postProcessContext(Context context) {
//
//            SecurityConstraint securityConstraint = new SecurityConstraint();
//            securityConstraint.setUserConstraint("CONFIDENTIAL");
//            SecurityCollection collection = new SecurityCollection();
//            collection.addPattern("/*");
//            securityConstraint.addCollection(collection);
//            context.addConstraint(securityConstraint);
//          }
//      };
//      tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
//      return tomcat;
//    }
//
//    private Connector initiateHttpConnector() {
//
//      Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//      connector.setScheme("http");
//      connector.setPort(8080);
//      connector.setSecure(false);
//      connector.setRedirectPort(8443);
//      return connector;
//    }
}
