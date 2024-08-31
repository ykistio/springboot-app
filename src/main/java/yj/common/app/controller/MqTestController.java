package yj.common.app.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Model: 应用 -
 * @Description: TODO
 * @Author: hyk
 * @Date: 2024/8/31
 **/
@RestController
@RequestMapping("/mq/v1/")
public class MqTestController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("send")
    public void send() {
        try {
            rabbitTemplate.convertAndSend("addFavorite.direct","addFavorite.success", 1L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
