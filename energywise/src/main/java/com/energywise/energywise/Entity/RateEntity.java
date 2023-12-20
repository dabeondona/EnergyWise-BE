package com.energywise.energywise.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblrate")
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "month")
    private String month;

    @Column(name = "price")
    private float price;

    @Column(name = "previous_month")
    private String previous_month;

    @Column(name = "previous_price")
    private String previous_price;

    @Column(name = "price_luzon")
    private float price_luzon;

    @Column(name = "price_mindanao")
    private float price_mindanao;

    @Column(name = "price_isDeleted")
    private boolean isDeleted;

    public RateEntity() {
        super();
    }

    public RateEntity(int id, String month, float price, String previous_month, String previous_price,
            float price_luzon, float price_mindanao, boolean isDeleted) {
        this.id = id;
        this.month = month;
        this.price = price;
        this.previous_month = previous_month;
        this.previous_price = previous_price;
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPrevious_month() {
        return previous_month;
    }

    public void setPrevious_month(String previous_month) {
        this.previous_month = previous_month;
    }

    public String getPrevious_price() {
        return previous_price;
    }

    public void setPrevious_price(String previous_price) {
        this.previous_price = previous_price;
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
