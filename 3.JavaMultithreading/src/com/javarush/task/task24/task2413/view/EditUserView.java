package com.javarush.task.task24.task2413.view;

import com.javarush.task.task24.task2413.controller.Controller;
import com.javarush.task.task24.task2413.model.ModelData;

public class EditUserView implements View {

    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited:");
        System.out.println("\t" + modelData.getActiveUser());
        System.out.println("===================================================");
    }

    @Override
    public void fireEventShowDeletedUsers() {
//       not created
    }

    public void fireEventUserDeleted(long id) {
        controller.onUserDelete(id);
    }

    public void fireEventUserChanged(String name, long id, int level) {
        controller.onUserChange(name, id, level);
    }
}
