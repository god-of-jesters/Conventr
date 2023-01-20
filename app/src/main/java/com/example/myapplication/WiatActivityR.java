package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class WiatActivityR extends AppCompatActivity {
    String v1;
    String v2;
    String[] val = {"USD", "RUB", "EUR", "GPB", "CNY"};
    double[] values = {70.0, 1.0, 72.0, 85.0, 9.8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiat_r);

        TextView selection = findViewById(R.id.textView1);

        Spinner spinner1 = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.vals, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.vals, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);

        AdapterView.OnItemSelectedListener itemSelectedListener1 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                v1 = (String)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };

        spinner1.setOnItemSelectedListener(itemSelectedListener1);

        AdapterView.OnItemSelectedListener itemSelectedListener2 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                v2 = (String)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner2.setOnItemSelectedListener(itemSelectedListener2);

        EditText editText = findViewById(R.id.list1);
        Button but = findViewById(R.id.button2);
        but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int i = 0;
                while(!v1.equals(val[i])){
                    i+=1;
                }
                double item1 = values[i];
                i = 0;
                while(!v2.equals(val[i])){
                    i+=1;
                }
                double item2 = values[i];
                double es = Double.parseDouble(editText.getText().toString());
                String mon = Double.toString(item1*es/item2);
                selection.setText(mon);
            }
        });
    }
}