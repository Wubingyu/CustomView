package com.example.customview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button_1_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        find_and_clickable(button_1_1, R.id.jump_1_1);
    }

    private void find_and_clickable(Button button, int Rid) {
        button = findViewById(Rid);
        button.setOnClickListener(v -> click_jump(CustomView_1_1.class));
    }

    private void click_jump(Class<?> activity) {
        Intent intent = new Intent(MainActivity.this, activity);
        startActivity(intent);
    }
}
