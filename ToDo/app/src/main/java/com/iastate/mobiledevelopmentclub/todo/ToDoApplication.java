package com.iastate.mobiledevelopmentclub.todo;

import android.app.Application;

import com.iastate.mobiledevelopmentclub.todo.models.Task;
import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by etbrady on 11/2/15.
 */
public class ToDoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(Task.class);
        Parse.initialize(this, "6i56ezsQtXbfzsSHaiKToW7shmQwnFUFAq17Pf45", "szqzOirSc2tqB6pCuTcTDXd4DLHGFGo4Kvt7Uz2p");
    }
}
