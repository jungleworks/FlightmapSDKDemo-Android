package com.FlightMapSdkTestApp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.FlightMapSdkTestApp.R;

public class LoginActivity extends AppCompatActivity {

    private RelativeLayout rl_loginbttn;
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor localdata;

    private EditText et_accesstoken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        init();
    }

    private void init() {
        sharedPreferences = getSharedPreferences("MySharedPref",
                Context.MODE_PRIVATE);
        localdata = sharedPreferences.edit();
        rl_loginbttn = (RelativeLayout)findViewById(R.id.rl_loginbttn);
        et_accesstoken = (EditText)findViewById(R.id.et_accesstoken);

        rl_loginbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_accesstoken!=null&&!et_accesstoken.getText().toString().equalsIgnoreCase("")){
                    localdata.putString(
                            "accesstoken",
                            et_accesstoken.getText().toString());
                    localdata.commit();
                    Intent intent =new Intent(LoginActivity.this, FeatureHomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Please Add Access Token ", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }


}
