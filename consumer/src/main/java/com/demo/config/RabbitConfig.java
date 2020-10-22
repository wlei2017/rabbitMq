package com.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wl
 * @create 2020/10/20 11:25
 */
@Configuration
public class RabbitConfig {
    public static final String EXCHANGE_NAME1 = "exchange_wanglei";
    public static final String QUEUE_NAME1 = "queue_wanglei";
    public static final String ROUTING_KEY = "first_routing";
    /***
     * @description:  交换机配置
     * @param
     * @return:
     * @author wl
     * @date: 2020/10/20 15:58
     */
    @Bean(EXCHANGE_NAME1)
    public Exchange EXCHANGE_NAME1(){
        ExchangeBuilder exchangeBuilder = ExchangeBuilder.directExchange(EXCHANGE_NAME1);
        Exchange build = exchangeBuilder.build();
        return build;
    }

    /***
     * @description: 声明队列
     * @param
     * @return:
     * @author wl
     * @date: 2020/10/20 16:00
     */
    @Bean(QUEUE_NAME1)
    public Queue queue1(){
        Queue queue1 = new Queue(QUEUE_NAME1,true);

//        Queue queue = new Queue(QUEUE_NAME1,true,false,false);
        return queue1;
    }

    @Bean
    public Binding BINDING1(@Qualifier(QUEUE_NAME1) Queue queue,@Qualifier(EXCHANGE_NAME1) Exchange exchange){
        Binding binding = BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY).noargs();
        return binding;
    }
}
