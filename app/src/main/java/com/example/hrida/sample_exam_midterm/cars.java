package com.example.hrida.sample_exam_midterm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class cars extends AppCompatActivity {

    private ListView ls1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);

        ls1 = (ListView)findViewById(R.id.carList);
        ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, Data.names);
        ls1.setAdapter(a);

        ls1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i1 = new Intent(cars.this, BookingActivity.class);
                i1.putExtra("pos", i);
                startActivity(i1);
            }
        });
    }
}
