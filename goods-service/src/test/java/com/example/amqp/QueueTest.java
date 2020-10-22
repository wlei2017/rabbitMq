package com.example.amqp;

import com.demo.goods.GoodsApplication;
import com.demo.goods.controller.TestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author wl
 * @create 2020/10/20 16:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GoodsApplication.class)
public class QueueTest {
    @Autowired
    private TestController testController;

    @Test
    public void test3() throws InterruptedException {
        int flag = 0;
        while (true){
            flag++;
            Thread.sleep(2000);
            testController.send("hello--"+flag);
        }

    }

}
