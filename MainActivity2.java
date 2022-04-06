package com.example.general;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.general.R;

import java.text.BreakIterator;

public class MainActivity2 extends AppCompatActivity {

    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
               calculateIt();
            }
       });
         }
         public void calculateIt() {
          TextView output = (TextView) findViewById(R.id.textView6);
             EditText inpt = (EditText) findViewById(R.id.inputNumber);
             String inptAsString = inpt.getText().toString();
             int inptAsINT = parseInt(inptAsString);



             if(inptAsINT >=10 ) {
                 output.setText("YOU WILL WIN GENERAL!!!");

             }
             else{
                 output.setText("YOU WILL LOSE GENERAL!!!");

             }

         }
}

