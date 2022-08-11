package com.example.androidprojectmemorygame;

public class customerModel {
    private int id;
    private String name;

    //default cons
    public customerModel() {
    }

    //parameterised cons


    public customerModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "customerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}



