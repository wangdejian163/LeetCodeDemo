package com.example.java8;

import java.util.Objects;

/**
 * <p>
 *     stream使用实体类
 * </p>
 *
 * @author wangdejian
 * @since 2018/2/26
 */
public class Student {

    private String name;
    private int age;
    private String stuNum;
    private String address;
    private Double score;

    public Student(String name, int age, String stuNum, String address, Double score) {
        this.name = name;
        this.age = age;
        this.stuNum = stuNum;
        this.address = address;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", stuNum='" + stuNum + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(stuNum, student.stuNum) &&
                Objects.equals(address, student.address) &&
                Objects.equals(score, student.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, stuNum, address, score);
    }
}
