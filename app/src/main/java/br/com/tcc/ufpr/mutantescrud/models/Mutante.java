package br.com.tcc.ufpr.mutantescrud.models;

import java.io.Serializable;

public class Mutante implements Serializable{
    private int id;
    private String name;
    private String skills;

    public Mutante() {}

    public Mutante(String name, String skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
}
