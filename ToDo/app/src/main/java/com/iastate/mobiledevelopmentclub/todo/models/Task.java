package com.iastate.mobiledevelopmentclub.todo.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by etbrady on 9/28/15.
 */
@ParseClassName("Task")
public class Task extends ParseObject {

    public Task() { }

    public void setCreatedBy(ParseUser user) {
        put("createdBy", user);
    }

    public ParseUser getCreatedBy() {
        return getParseUser("createdBy");
    }

    public void setDone(boolean isDone){
        put("isDone", isDone);
    }

    public String getTitle() {
        return getString("title");
    }

    public void setTitle(String title) {
        put("title", title);
    }

    public boolean isDone() {
        return getBoolean("isDone");
    }
}
