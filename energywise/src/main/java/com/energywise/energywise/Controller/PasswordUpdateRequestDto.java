package com.energywise.energywise.Controller;

public class PasswordUpdateRequestDto {
    private Integer userId;
    private String currentPassword;
    private String newPassword;

    public PasswordUpdateRequestDto() {
    }

    public PasswordUpdateRequestDto(Integer userId, String currentPassword, String newPassword) {
        this.userId = userId;
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
