package com.javarush.task.task24.task2413.view;

import com.javarush.task.task24.task2413.controller.Controller;
import com.javarush.task.task24.task2413.model.ModelData;

public interface View {

    void refresh(ModelData modelData);

    void setController(Controller controller);

    void fireEventShowDeletedUsers();
}
