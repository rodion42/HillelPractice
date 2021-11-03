package Lesson2;

import java.util.ArrayList;
import java.util.List;

public class Phone {
    private String model;

    public Phone(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                '}';
    }

    public static void main(String[] args) {

        List<Phone> phones = new ArrayList<>();

        phones.add(new Phone("Iphone"));
        phones.add(new Phone("Samsung"));
        phones.add(new Phone("Vertu"));

        System.out.println(phones.get(0));

    }
}
