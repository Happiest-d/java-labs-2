package org.donstu.domain;

import java.util.List;

public class Vacancy {
    private String name;
    private int salary;
    private String description;
    private List<Response> responses;

    public Vacancy(String name, int salary, String description, List<Response> responses) {
        this.name = name;
        this.salary = salary;
        this.description = description;
        this.responses = responses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }
}
