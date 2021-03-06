package com.example.udham.crhelper;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;


public class sign_up extends ActionBarActivity {

    AutoCompleteTextView username=null;
    EditText password=null;
    EditText retype_pwd=null;
    Button Register;
    String pwd,retype,uname;
    TextView out=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        input();

        addListenerOnButton();


    }



    public void addListenerOnButton()
    {
        Register=(Button)findViewById(R.id.sign_in);


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname = username.getText().toString();
                pwd = password.getText().toString();
                retype = retype_pwd.toString();
                ParseUser user = new ParseUser();
                user.setUsername(uname);
                user.setPassword(pwd);

                if (retype_pwd.equals(pwd)) {
                    user.signUpInBackground(new SignUpCallback() {
                        public void done(com.parse.ParseException e) {
                            if (e == null) {
                                // Hooray! Let them use the app now.
                                Intent intent = new Intent(sign_up.this, StudentActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }else
                {
                    out.setTextColor(Color.RED);
                    out.setText("Password Doesn't Match !!!");

                }
            }


        });
    }

    public void input()
    {
        try {


            username = (AutoCompleteTextView) findViewById(R.id.email);
            password = (EditText) findViewById(R.id.password);
            retype_pwd = (EditText) findViewById(R.id.re_type);
            out=(TextView)findViewById(R.id.textView);

        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_SHORT).show();

        }

    }


}
