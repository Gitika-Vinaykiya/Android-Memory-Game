package com.example.androidprojectmemorygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button add,view;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add=(Button)findViewById(R.id.add);
        view=(Button)findViewById(R.id.view);
        name=(EditText)findViewById(R.id.p1);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customerModel customermodel;
                try {
                    //create new customer reference object
                    customermodel = new customerModel(1,name.getText().toString() );
                    Toast.makeText(MainActivity.this, customermodel.toString(), Toast.LENGTH_SHORT).show();


                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "error in creating data", Toast.LENGTH_SHORT).show();
                    customermodel= new customerModel(1,"error");
                }

                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                boolean b=databaseHelper.addrecord(customermodel);
                Toast.makeText(MainActivity.this,"success = " + b,Toast.LENGTH_SHORT).show();

                //success=true
                String value = name.getText().toString();
                Intent intent = new Intent(MainActivity.this,Activity1.class);
                intent.putExtra("key",value);
                startActivity(intent);

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,Activity2.class);
                startActivity(intent1);

            }
        });

    }
}