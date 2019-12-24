package com.example.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

@SpringBootApplication
public class DemoApplication extends ContextLoaderListener implements ApplicationListener<ContextRefreshedEvent> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext sct = event.getServletContext();
        //获取Spring应用上下文
        ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sct);
        BeanFactory beanFactory = ctx.getParentBeanFactory();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
//        RedisConnectionFactory redisConnectionFactory = (RedisConnectionFactory)applicationContext.getBean("redisConnectionFactory");
//        RedisClusterConnection redisClusterConnection = redisConnectionFactory.getClusterConnection();
//        AnnotationConfigWebApplicationContext beanFactory = (AnnotationConfigWebApplicationContext) applicationContext;
//
//        beanFactory.setBeanNameGenerator();
//        if (redisClusterConnection != null) {
//            Iterable<RedisClusterNode> nodes = redisClusterConnection.clusterGetNodes();
//            for (RedisClusterNode node : nodes) {
//                if (node.isMaster()) {
//                    String containerBeanName = "messageContainer" + node.hashCode();
//                    if (beanFactory.containsBean(containerBeanName)) {
//                        return;
//                    }
//
//                    //redis配置
//                    RedisConfiguration redisConfiguration = new
//                            RedisStandaloneConfiguration(node.getHost(),node.getPort());
//                    //根据配置和客户端配置创建连接
//                    LettuceConnectionFactory factory = new
//                            LettuceConnectionFactory(redisConfiguration);
//                    factory.afterPropertiesSet();
//
//                    BeanDefinitionBuilder containerBeanDefinitionBuilder = BeanDefinitionBuilder
//                            .genericBeanDefinition(RedisMessageListenerContainer.class);
//                    containerBeanDefinitionBuilder.addPropertyValue("connectionFactory", factory);
//                    containerBeanDefinitionBuilder.setScope(BeanDefinition.SCOPE_SINGLETON);
//                    containerBeanDefinitionBuilder.setLazyInit(false);
//                    beanFactory.registerBeanDefinition(containerBeanName,
//                            containerBeanDefinitionBuilder.getRawBeanDefinition());
//                    RedisMessageListenerContainer container = beanFactory
//                            .getBean(containerBeanName, RedisMessageListenerContainer.class);
//                    String listenerBeanName = "messageListener" + node.hashCode();
//                    if (beanFactory.containsBean(listenerBeanName)) {
//                        return;
//                    }
//                    MessageListener messageListener = (MessageListener)applicationContext.getBean("messageListener");
//
//                    container.addMessageListener(messageListener, new PatternTopic("__key*__:*"));
//                    container.start();
//                }
//            }
//
//            RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//            redisTemplate.setKeySerializer(new StringRedisSerializer());
//            redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//            redisTemplate.setHashValueSerializer(new StringRedisSerializer());
//            redisTemplate.setValueSerializer(new StringRedisSerializer());
//            redisTemplate.setConnectionFactory(redisConnectionFactory);
//            redisTemplate.afterPropertiesSet();
//
////            beanFactory.setAllowCircularReferences();
//
//            BeanDefinitionBuilder redisTemplateBuilder = BeanDefinitionBuilder
//                    .genericBeanDefinition(RedisTemplate.class);
//            redisTemplateBuilder.addPropertyValue("redisTemplate", redisTemplate);
//            redisTemplateBuilder.setScope(BeanDefinition.SCOPE_SINGLETON);
//            redisTemplateBuilder.setLazyInit(false);
//            beanFactory.registerBeanDefinition("localRedisTemplate",
//                    redisTemplateBuilder.getRawBeanDefinition());
//
//            RedisUtil redisUtil = new RedisUtil();
//            redisUtil.setRedisTemplate(redisTemplate);
//            BeanDefinitionBuilder redisUtilBuilder = BeanDefinitionBuilder
//                    .genericBeanDefinition(RedisUtil.class);
//            redisUtilBuilder.addPropertyValue("redisUtil", redisUtil);
//            redisUtilBuilder.setScope(BeanDefinition.SCOPE_SINGLETON);
//            redisUtilBuilder.setLazyInit(false);
//            beanFactory.registerBeanDefinition("redisUtil",
//                    redisUtilBuilder.getRawBeanDefinition());
//
//            beanFactory.refresh();
//
//        }
    }
}
