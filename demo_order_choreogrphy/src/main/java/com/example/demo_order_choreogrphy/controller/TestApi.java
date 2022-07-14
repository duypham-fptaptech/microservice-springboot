package com.example.demo_order_choreogrphy.controller;

import com.example.demo_order_choreogrphy.queue.SendMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@Log4j2
public class TestApi {
    @Autowired
    SendMessage sendMessage;

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public void send(

    ) {
        sendMessage.sendMessage("bach gui thu");
        log.info("da gui thu");
    }
}
