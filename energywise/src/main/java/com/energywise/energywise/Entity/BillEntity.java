package com.energywise.energywise.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblbill")
public class BillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private int billId;

    @Column(name = "bill_name")
    private String billName;

    @Column(name = "due_date")
    private java.sql.Date dueDate;

    @Column(name = "amount")
    private float amount;

    @Column(name = "status")
    private String status;

    public BillEntity() {
        super();
    }

    public BillEntity(int billId, String billName, java.sql.Date dueDate, float amount, String status) {
        this.billId = billId;
        this.billName = billName;
        this.dueDate = dueDate;
        this.amount = amount;
        this.status = status;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public java.sql.Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(java.sql.Date dueDate) {
        this.dueDate = dueDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addBill() {
    }

    public void editBill() {
    }

    public void viewBill() {
    }

    public void deleteBill() {
    }
}
