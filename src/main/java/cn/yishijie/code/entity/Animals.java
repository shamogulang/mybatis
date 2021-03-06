package cn.yishijie.code.entity;

import javax.persistence.*;

public class Animals {
    /**
     * 动物ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 动物名称
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 获取动物ID
     *
     * @return id - 动物ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置动物ID
     *
     * @param id 动物ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取动物名称
     *
     * @return name - 动物名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置动物名称
     *
     * @param name 动物名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}