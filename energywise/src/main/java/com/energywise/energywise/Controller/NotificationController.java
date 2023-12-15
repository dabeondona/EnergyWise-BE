package com.energywise.energywise.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.energywise.energywise.Entity.NotificationEntity;
import com.energywise.energywise.Service.NotificationService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rate")
public class NotificationController {

    @Autowired
    NotificationService nService;

    @GetMapping("/print")
    public String printHello() {
        return "Hello, Mic Test!";
    }

    @PostMapping("/insertNotificati")
    public NotificationEntity insertNotification(@RequestBody NotificationEntity notify) {
        return nService.insertNotification(notify);
    }

    @GetMapping("/getAllNotification")
    public List<NotificationEntity> getAllNotification() {
        return nService.getAllNotification();
    }

    @PutMapping("/updateNotification")
    public NotificationEntity updateNotification(@RequestParam int notification_id, @RequestBody NotificationEntity newNotificationDetails) {
        return nService.updateNotification(notification_id, newNotificationDetails);
    }

    @DeleteMapping("/deleteNotification/{notification_id}")
    public String deleteNotification(@PathVariable int notification_id) {
        return nService.deleteNotification(notification_id);
    }
}
