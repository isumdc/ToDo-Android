package com.iastate.mobiledevelopmentclub.todo.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iastate.mobiledevelopmentclub.todo.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button signUpButton = (Button) findViewById(R.id.button_signUp);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp() {
        EditText firstNameEditText = (EditText) findViewById(R.id.edittext_firstName);
        String firstName = firstNameEditText.getText().toString();

        EditText lastNameEditText = (EditText) findViewById(R.id.edittext_lastName);
        String lastName = lastNameEditText.getText().toString();

        String name = firstName + " " + lastName;

        EditText phoneEditText = (EditText) findViewById(R.id.edittext_phone);
        String phone = phoneEditText.getText().toString();

        EditText emailEdiText = (EditText) findViewById(R.id.edittext_email);
        String email = emailEdiText.getText().toString();

        EditText passwordEditText = (EditText) findViewById(R.id.edittext_password);
        String password = passwordEditText.getText().toString();

        ParseUser user = new ParseUser();
        user.setUsername(email);
        user.setEmail(email);
        user.setPassword(password);
        user.put("name", name);
        user.put("phone", phone);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                Context context = SignUpActivity.this;
                if(e == null) {
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    String errorPrompt = getString(R.string.error_signup);
                    String errorMessage = errorPrompt + " " + e.getMessage();
                    Toast toast = Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
