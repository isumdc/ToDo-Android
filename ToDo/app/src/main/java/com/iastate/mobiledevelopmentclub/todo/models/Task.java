package com.iastate.mobiledevelopmentclub.todo.models;

/**
 * Created by etbrady on 9/28/15.
 */
public class Task {

    private String title;
    private boolean isDone;

    public Task(String title) {
        this.title = title;
        this.isDone = false;
    }

    public void setDone(){
        this.isDone = true;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isDone() {
        return this.isDone;
    }
}
