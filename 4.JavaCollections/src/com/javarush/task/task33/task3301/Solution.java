package com.javarush.task.task33.task3301;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

/* 
Первая сериализация в JSON
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 3;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jeferson";

        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(cat);
        pets.add(dog);

        StringWriter writer = new StringWriter();

        convertToJSON(writer, pets);

        System.out.println(writer.toString()); // OUTPUT : [{"name":"Murka","age":5,"weight":3},{"name":"Killer","age":8,"owner":"Bill Jeferson"}]
    }

    public static void convertToJSON(StringWriter writer, Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, object);
    }

    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NON_PRIVATE
    )
    public static class Pet {
        String name;
    }

    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NON_PRIVATE
    )
    public static class Cat extends Pet {
        int age;
        int weight;
    }

    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NON_PRIVATE
    )
    public static class Dog extends Pet {
        int age;
        String owner;
    }
}
