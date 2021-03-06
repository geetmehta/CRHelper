package com.example.udham.crhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;


public class StudentActivity extends Activity {

    TextView tv,welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        tv= (TextView) findViewById(R.id.att_text);
        welcome=(TextView) findViewById(R.id.subTitle);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            // do stuff with the user
            welcome.setText("Welcome "+currentUser.getUsername());
        } else {

            // show the signup or login screen

        }


    }

    public void addListenerOnButton() {

        final Context context = this;



        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, attendance.class);
                startActivity(intent);

            }
        });


    }

}
