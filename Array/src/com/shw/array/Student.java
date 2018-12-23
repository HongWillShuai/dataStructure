package com.shw.array;

/**
 * @author WillShuai
 * @date 2018/12/23--21:45
 */
public class Student {
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("HongWillShuai");
        student.setSex("男");
        Array<Student> arr = new Array<>();
        arr.add(0,student);
        System.err.println(arr);
        int capacity = arr.getCapacity();
        System.err.println(capacity);
    }
}
