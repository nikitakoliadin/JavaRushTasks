package com.javarush.task.task24.task2413;

import com.javarush.task.task24.task2413.controller.Controller;
import com.javarush.task.task24.task2413.model.Model;
import com.javarush.task.task24.task2413.model.MainModel;
import com.javarush.task.task24.task2413.view.EditUserView;
import com.javarush.task.task24.task2413.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        Controller controller = new Controller();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();

        editUserView.setController(controller);
        controller.setEditUserView(editUserView);

        usersView.setController(controller);
        controller.setUsersView(usersView);

        controller.setModel(model);

        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("Ivanova", 123L, 1);
        usersView.fireEventShowDeletedUsers();
    }
}