package com.javarush.task.task24.task2413.model;

import com.javarush.task.task24.task2413.bean.User;

import java.util.List;

public class ModelData {
    private List<User> users; // список пользователей для отображения
    private User activeUser;
    private boolean displayDeletedUserList;

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public boolean isDisplayDeletedUserList() {
        return displayDeletedUserList;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
        this.displayDeletedUserList = displayDeletedUserList;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
