package com.iastate.mobiledevelopmentclub.todo.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.iastate.mobiledevelopmentclub.todo.R;
import com.iastate.mobiledevelopmentclub.todo.adapters.TaskArrayAdapter;
import com.iastate.mobiledevelopmentclub.todo.models.Task;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected List<Task> tasks;
    private ParseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentUser = ParseUser.getCurrentUser();
        tasks = new ArrayList<>();

        ListView listView = (ListView) findViewById(R.id.listview_tasks);
        ArrayAdapter listAdapter = new TaskArrayAdapter(this, R.layout.item_task, tasks);

        listView.setAdapter(listAdapter);
    }

    private void retrieveTasks() {
        ParseQuery<Task> taskParseQuery = new ParseQuery<>(Task.class);
        taskParseQuery.whereEqualTo("createdBy", currentUser);
        taskParseQuery.findInBackground(new FindCallback<Task>() {
            @Override
            public void done(List<Task> list, ParseException e) {
                //this.tasks = list;
            }
        });

    }

    private void addTask() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setTitle(R.string.newTaskDialog_title);

        final View alertDialogView = inflater.inflate(R.layout.alertdialog_add_task, null);

        builder.setView(alertDialogView);

        builder.setPositiveButton(R.string.newTaskDialog_positiveButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText editTextTitle = (EditText) alertDialogView.findViewById(R.id.edittext_title);
                String title = editTextTitle.getText().toString();
                Task task = new Task();
                task.setTitle(title);
                tasks.add(task);
            }
        });

        builder.setNegativeButton(R.string.newTaskDialog_negativeButton, null);

        builder.create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_addTask:
                addTask();
                return true;
            case R.id.action_logout:
                ParseUser.logOut();
                Intent intent = new Intent(this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            default:
                return false;
        }
    }
}
