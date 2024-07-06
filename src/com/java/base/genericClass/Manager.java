package com.java.base.genericClass;

import com.java.base.entity.Employee;

import java.time.LocalDate;

/**
 * mjt 梅锦涛
 * 2024/7/6
 *
 * @author mjt
 */
public class Manager {

    private String name;
    private double salary;
    private LocalDate hireDay;

        public Manager(String name, double salary, int year, int month, int day) {
            this.name = name;
            this.salary = salary;
            hireDay = LocalDate.of(year, month, day);
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public LocalDate getHireDay() {
            return hireDay;
        }

        public void raiseSalary(double byPercent) {
            double raise = salary * byPercent / 100;
            salary += raise;
        }

        public String toString() {
            return "Manager[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
        }




}


