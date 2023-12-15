package com.energywise.energywise.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energywise.energywise.Entity.NotificationEntity;
import com.energywise.energywise.Repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository nRepo;

    // C
    public NotificationEntity insertNotification(NotificationEntity notify) {
        return nRepo.save(notify);
    }

    // R
    public List<NotificationEntity> getAllNotification() {
        return nRepo.findAll();
    }

    // U
    @SuppressWarnings("finally")
    public NotificationEntity updateNotification(int notification_id, NotificationEntity newNotificationDetails) {
        NotificationEntity notify = new NotificationEntity();

        try {
            notify = nRepo.findById(notification_id).get();
            notify.setMessage(newNotificationDetails.getMessage());
            notify.setTimestamp(newNotificationDetails.getTimestamp());
            notify.setDeleted(newNotificationDetails.isDeleted());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Notification " + notification_id + " not found!");
        } finally {
            return nRepo.save(notify);
        }
    }

    // D
    public String deleteNotification(int notification_id) {
        String msg = "";

        if (nRepo.findById(notification_id) != null) {
            nRepo.deleteById(notification_id);
            msg = "Notification " + notification_id + " is deleted!";
        } else {
            msg = "Notification " + notification_id + " not found!";
        }

        return msg;
    }
}
