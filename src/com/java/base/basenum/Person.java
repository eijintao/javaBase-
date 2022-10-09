package com.java.base.basenum;

import java.util.Date;

/**
 * asus 梅锦涛
 * 2021/11/12
 *
 * @author mjt
 */
public class Person {

    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    private String city;

    private String address;

    private String status;

    private Date creatime;

    private Date lasttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatime() {
        return creatime;
    }

    public void setCreatime(Date creatime) {
        this.creatime = creatime;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", creatime=" + creatime +
                ", lasttime=" + lasttime +
                '}';
    }

    public Person(Integer id, String name, Integer age, String sex, String city, String address, String status, Date creatime, Date lasttime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.city = city;
        this.address = address;
        this.status = status;
        this.creatime = creatime;
        this.lasttime = lasttime;
    }

    public Person(Integer id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Person(Integer id, String name, Integer age, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Person() {
    }
}
