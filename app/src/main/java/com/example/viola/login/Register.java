package com.example.viola.login;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Register extends Activity {

    private Spinner spinner1;
    private Button btnsubmit;
    private Button submit;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        addItemsOnSpinner2();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();

        Thread timer=new Thread() {
            @Override
            public void run(){
                ////  try{
                mediaPlayer = MediaPlayer.create(Register.this, R.raw.cartoon);
                mediaPlayer.start();
                //sleep(50000);
                //}
                // catch(InterruptedException e)
                //  {

                ////  }
                //  finally {
                //    Intent i=new Intent(Login.this,MainActivity.class);
                //    startActivity(i);
                //    }
            }

        };
        timer.start();

        submit=findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Registered!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

    }

    public void addItemsOnSpinner2() {

        spinner1 = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("India");
        list.add("Malaysia");
        list.add("Indonesia");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection(){
        spinner1=(Spinner) findViewById(R.id.spinner);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListner());
    }
    public void addListenerOnButton(){
        spinner1=(Spinner) findViewById(R.id.spinner);
        btnsubmit =(Button) findViewById(R.id.button);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Toast.makeText(Register.this, "OnClickListner :" + "\nSpinner 1:" + String.valueOf(spinner1.getSelectedItem()), Toast.LENGTH_SHORT).show();
            }
        });
    }



}
