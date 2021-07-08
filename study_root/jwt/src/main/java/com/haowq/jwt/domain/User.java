package com.haowq.jwt.domain;

/**
 * @Auther: haowq
 * @Date: 2021/6/2 17:27
 * @Description:
 */
public class User {
    private String id;
    private String name;
    private String password;
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public User() {
        super();
    }
    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
