
package com.example.androidprojectmemorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.List;

public class Activity2 extends AppCompatActivity {

    Button viewer,delete;
    ListView lv;
    ArrayAdapter adapter;

    EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        viewer=(Button)findViewById(R.id.viewer);
        delete=(Button)findViewById(R.id.delete);
        lv=(ListView)findViewById(R.id.list_view);
        text=(EditText)findViewById(R.id.text);

        viewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(Activity2.this);
                List<customerModel> all=databaseHelper.getalldata();
                adapter = new ArrayAdapter<customerModel>(Activity2.this, android.R.layout.simple_list_item_1,all);
                lv.setAdapter(adapter);
                //ArrayAdapter
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(Activity2.this);
                Integer input= databaseHelper.delete(text.getText().toString());
                if(input > 0)
                    Toast.makeText(Activity2.this,"deleted successfully",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Activity2.this,"deletion failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}