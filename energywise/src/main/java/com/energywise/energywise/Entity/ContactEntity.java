package com.energywise.energywise.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblcontact")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private int contact_id;

    @Column(name = "contact_name")
    private String contact_name;

    @Column(name = "contact_email")
    private String contact_email;

    @Column(name = "contact_message")
    private String contact_message;

    @Column(name = "contact_isDeleted")
    private boolean isDeleted;

    public ContactEntity() {
        super();
    }

    public ContactEntity(int contact_id, String contact_name, String contact_email, String contact_message,
            boolean isDeleted) {
        this.contact_id = contact_id;
        this.contact_name = contact_name;
        this.contact_email = contact_email;
        this.contact_message = contact_message;
        this.isDeleted = isDeleted;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getContact_message() {
        return contact_message;
    }

    public void setContact_message(String contact_message) {
        this.contact_message = contact_message;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}
