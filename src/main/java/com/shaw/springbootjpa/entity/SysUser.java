package com.shaw.springbootjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author shaw
 * @date 2023/3/20
 */
@Entity(name = "sys_user")
//@Table(name = "sys_user") 功能已经被@Entity替代
public class SysUser {

    private String id;
    private String userName;
    private String userCode;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
//@GeneratedValue(strategy= GenerationType.IDENTITY) 该注解由数据库自动生成，主键自增型，在 mysql 数据库中使用最频繁，oracle 不支持。
//@GeneratedValue(strategy= GenerationType.AUTO) 主键由程序控制，默认的主键生成策略，oracle 默认是序列化的方式，mysql 默认是主键自增的方式。
//@GeneratedValue(strategy= GenerationType.SEQUENCE) 根据底层数据库的序列来生成主键，条件是数据库支持序列，Oracle支持，Mysql不支持。
//@GeneratedValue(strategy= GenerationType.TABLE) 使用一个特定的数据库表格来保存主键，较少使用。
    @Column(name = "id", length = 36, unique = true)
    public String getId() {
        return id;
    }

    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "user_code")
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
