package com.energywise.energywise.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblenergyconsumption")
public class EnergyConsumptionTableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ect_id")
    private int ect_id;

    @Column(name = "ect_month", nullable = false)
    private String ectMonth;

    @Column(name = "ect_consumption", nullable = false)
    private float ectConsumption;

    @Column(name = "ect_price", nullable = false)
    private float ectPrice;

    @Column(name = "user_id", nullable = false)
    private int userId;

    public EnergyConsumptionTableEntity() {
        super();
    }

    public EnergyConsumptionTableEntity(int ect_id, String ectMonth, float ectConsumption, float ectPrice,
            int userId) {
        this.ect_id = ect_id;
        this.ectMonth = ectMonth;
        this.ectConsumption = ectConsumption;
        this.ectPrice = ectPrice;
        this.userId = userId;
    }

    public int getEct_id() {
        return ect_id;
    }

    public void setEct_id(int ect_id) {
        this.ect_id = ect_id;
    }

    public String getEctMonth() {
        return ectMonth;
    }

    public void setEctMonth(String ectMonth) {
        this.ectMonth = ectMonth;
    }

    public float getEctConsumption() {
        return ectConsumption;
    }

    public void setEctConsumption(float ectConsumption) {
        this.ectConsumption = ectConsumption;
    }

    public float getEctPrice() {
        return ectPrice;
    }

    public void setEctPrice(float ectPrice) {
        this.ectPrice = ectPrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
