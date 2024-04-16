package com.mobile.apicall;

public class Todo {
    private int id;
    private String what;
    private String time;

    public Todo(int id, String what, String time) {
        this.id = id;
        this.what = what;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getWhat() {
        return what;
    }

    public String getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setWhat(String what) {
        this.what = what;
    }
}
