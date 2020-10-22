package com.demo.goods;

import com.demo.Order;
import com.demo.config.RabbitConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 备份交换器测试
 *
 * @author yanlin
 * @version v1.3
 * @date 2019-06-16 2:51 PM
 * @since v8.0
 **/
@Service
public class TestConsumer {

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME1)
    @RabbitHandler
    public void good(String msg, Message message, Channel channel) throws IOException {
        try {
            System.out.println("接收到消息：" + msg);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
            System.out.println(message.getMessageProperties().getDeliveryTag());
            System.out.println("消费者确认：" + message.getMessageProperties().getConsumerQueue()+",接收到了回调方法");
        } catch (Exception e) {
            System.out.println("aaaaaaaaaa");
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
        }
    }

    @RabbitListener(queues = "AE-queue")
    @RabbitHandler
    public void AE(Order order) {
        System.out.println("错误路由到，这是：" + order.getName());
    }

}
