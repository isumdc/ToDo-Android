package com.iastate.mobiledevelopmentclub.todo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.iastate.mobiledevelopmentclub.todo.R;
import com.iastate.mobiledevelopmentclub.todo.models.Task;

import java.util.List;

/**
 * Created by etbrady on 9/28/15.
 */
public class TaskArrayAdapter extends ArrayAdapter<Task> {

    public TaskArrayAdapter(Context context, int resource, List<Task> tasks) {
        super(context, resource, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Task task = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_task, parent, false);
        }
        TextView titleTextView = (TextView)convertView.findViewById(R.id.textview_title);
        titleTextView.setText(task.getTitle());

        Button removeButton = (Button) convertView.findViewById(R.id.button_remove);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(task);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

}