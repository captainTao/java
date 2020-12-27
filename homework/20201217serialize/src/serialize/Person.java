package serialize;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 8388489882340028254L;
    private String name;
    private Gender gender;
    private transient int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person: {" +
                "name :" + getName() +
                ", age : " + getAge() +
                ", gender : " + getGender() +
                "}";
    }
}

enum Gender {
    male, female
}