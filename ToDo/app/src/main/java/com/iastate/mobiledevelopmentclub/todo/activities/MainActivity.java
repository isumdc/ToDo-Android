package com.iastate.mobiledevelopmentclub.todo.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasks = new ArrayList<>();

        ListView listView = (ListView) findViewById(R.id.listview_tasks);
        ArrayAdapter listAdapter = new TaskArrayAdapter(this, R.layout.item_task, tasks);

        listView.setAdapter(listAdapter);
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
                Task task = new Task(title);
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
            default:
                return false;
        }
    }
}
