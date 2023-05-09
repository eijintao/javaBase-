package com.java.base.entity;

import java.time.LocalDate;

/**
 * asus 梅锦涛
 * 2022/10/30
 *
 * @author mjt
 */
public class Employee {

    private String name;
    private double salary;
    private LocalDate hireDay;

    public boolean isJudgment() {
        return isJudgment;
    }

    public void setJudgment(boolean judgment) {
        isJudgment = judgment;
    }

    private boolean isJudgment;

    public Employee(String name, double salary, LocalDate hireDay, boolean isJudgment) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
        this.isJudgment = isJudgment;
    }

    public Employee(String n, double s, int year, int month, int day, boolean isJudgment) {
        this.name = n;
        this.salary = s;
        this.hireDay = LocalDate.of(year,month,day);
        this.isJudgment = isJudgment;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseDalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                ", isJudgment=" + isJudgment +
                '}';
    }
}
