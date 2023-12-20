package com.energywise.energywise.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbltips")
public class TipsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tip_id")
    private int tip_id;

    @Column(name = "tip_title")
    private String title;

    @Column(name = "tip_content")
    private String content;

    @Column(name = "tip_date")
    private Date date;

    @Column(name = "isDeleted")
    private boolean isDeleted;

    public int getTip_id() {
        return tip_id;
    }

    public void setTip_id(int tip_id) {
        this.tip_id = tip_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public TipsEntity(int tip_id, String title, String content, Date date, boolean isDeleted) {
        this.tip_id = tip_id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.isDeleted = isDeleted;
    }

    public TipsEntity(){
        super();
    }

    
}
