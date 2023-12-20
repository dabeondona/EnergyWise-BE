package com.energywise.energywise.Controller;

public class PasswordUpdateRequestDto {
    private Integer userId;
    private String newPassword;

    public PasswordUpdateRequestDto() {
    }

    public PasswordUpdateRequestDto(Integer userId, String newPassword) {
        this.userId = userId;
        this.newPassword = newPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
