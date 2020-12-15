package com.saloon.Saloon.rabbitmq;


import com.saloon.Saloon.model.Saloon;
import com.saloon.Saloon.service.saloonService.SaloonService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    SaloonService saloonService;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consume(Saloon saloon) {
        saloonService.addSaloon(saloon);
    }
}
