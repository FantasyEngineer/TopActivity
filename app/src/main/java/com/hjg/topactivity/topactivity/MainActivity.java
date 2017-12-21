package com.hjg.topactivity.topactivity;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hjg.top.TaskWindowManage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.showWindow).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                TaskWindowManage.INSTANCE.ShowInApplication(MainActivity.this);
            }
        });
        findViewById(R.id.dissWindow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskWindowManage.INSTANCE.dismiss(MainActivity.this);
            }
        });
        findViewById(R.id.modifyWindow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        findViewById(R.id.toNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

    }
}
