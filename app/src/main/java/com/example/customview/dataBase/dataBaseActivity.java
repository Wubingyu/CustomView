package com.example.customview.dataBase;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.customview.R;

public class dataBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        dataBaseHelper helper = new dataBaseHelper(this, "test");
        SQLiteDatabase database = helper.getWritableDatabase();


    }
}
