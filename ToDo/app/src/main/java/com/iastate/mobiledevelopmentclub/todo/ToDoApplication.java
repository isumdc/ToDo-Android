package com.iastate.mobiledevelopmentclub.todo;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by etbrady on 11/2/15.
 */
public class ToDoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "cbKPyD03OaVEVxx4kmkJT74BCPMGKM5xi5I1xgoX", "vqAELdoabdUSA8OJENbB6Vw7EyvxPjXxm811aiU1");
    }
}
