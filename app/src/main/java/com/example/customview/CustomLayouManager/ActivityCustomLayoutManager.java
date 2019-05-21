package com.example.customview.CustomLayouManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.customview.R;

import java.util.ArrayList;

public class ActivityCustomLayoutManager extends AppCompatActivity {
    ArrayList<RecyclerViewItem> items = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_layout_manager);

        initItems();
        adapter = new RecyclerViewAdapter(items);

        recyclerView = findViewById(R.id.ExploreFragment_RecyclerView);
        RecyclerView.LayoutManager layoutManager = new customLayoutManager();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initItems() {
        RecyclerViewItem item1 = new RecyclerViewItem("how many roads must a man walk down");
        RecyclerViewItem item2 = new RecyclerViewItem("The answer is blowing in the wind");
        items.add(item1);
        items.add(item2);
    }
}
