package com.iastate.mobiledevelopmentclub.todo.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by etbrady on 9/28/15.
 */
@ParseClassName("Task")
public class Task extends ParseObject {

    private String title;
    private boolean isDone;

    public Task() {
        this.isDone = false;
    }

    public void setDone(){
        this.isDone = true;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return this.isDone;
    }
}
