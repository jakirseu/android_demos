package me.jakir.gson;

/**
 * Created by jack on 3/5/16.
 */
public class Friend {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "Friends [name=" + name + ", Email=" + email ;
    }
}
