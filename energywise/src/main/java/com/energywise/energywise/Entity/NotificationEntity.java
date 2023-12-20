package com.energywise.energywise.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblnotification")

public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private int notification_id;

    @Column(name = "message")
    private String message;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "isDeleted")
    private boolean isDeleted;

public class NotitificationStatus{

    @Column(name = "status")
    private NotitificationStatus status;

}
public NotificationEntity() {
    super();
}

 public NotificationEntity(int notification_id, String message, Date timestamp, boolean isDeleted) {
        this.notification_id = notification_id;
        this.message = message;
        this.timestamp = timestamp;
        this.isDeleted = isDeleted;
    }

public int getNotification_ID() {
    return notification_id;
}

public void setNotifcation_ID(int notification_id) {
    this.notification_id = notification_id;
}

public String getMessage() {
    return message;
}

public void setMessage(String message) {
    this.message = message;
}

public Date getTimestamp() {
    return timestamp;
}

public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
}
public boolean isDeleted() {
    return isDeleted;
}

public void setDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
}



}