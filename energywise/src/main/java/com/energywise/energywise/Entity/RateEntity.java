package com.energywise.energywise.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblrate")
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "price")
    private float price;

    @Column(name = "price_luzon")
    private float price_luzon;

    @Column(name = "price_mindanao")
    private float price_mindanao;

    @Column(name = "price_isDeleted")
    private boolean isDeleted;

    public RateEntity() {
        super();
    }

    public RateEntity(int id, Date date, float price, float price_luzon, float price_mindanao, boolean isDeleted) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.price_luzon = price_luzon;
        this.price_mindanao = price_mindanao;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice_luzon() {
        return price_luzon;
    }

    public void setPrice_luzon(float price_luzon) {
        this.price_luzon = price_luzon;
    }

    public float getPrice_mindanao() {
        return price_mindanao;
    }

    public void setPrice_mindanao(float price_mindanao) {
        this.price_mindanao = price_mindanao;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}
