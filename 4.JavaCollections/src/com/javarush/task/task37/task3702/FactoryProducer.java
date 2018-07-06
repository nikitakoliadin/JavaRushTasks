package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

import static com.javarush.task.task37.task3702.FactoryProducer.HumanFactoryType.*;

public class FactoryProducer {

    public enum HumanFactoryType {
        MALE,
        FEMALE
    }

    public static AbstractFactory getFactory(HumanFactoryType humanFactoryType) {
        if (humanFactoryType == MALE) {
            return new MaleFactory();
        } else {
            return new FemaleFactory();
        }
    }
}
