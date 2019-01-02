package com.example.viola.login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button button;
    private TextView txt;
    private TextView txt1;
    private EditText name;
    private EditText pwd;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button=findViewById(R.id.submit);
        name=(EditText)findViewById(R.id.name);

        pwd=(EditText)findViewById(R.id.textView3);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String nam=name.getText().toString();
                    String passwd=pwd.getText().toString();
                   if(nam.equals("Vio")&&passwd.equals("vvv"))
                   {
                        Intent i = new Intent(Login.this, Register.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), name.getText().toString(), Toast.LENGTH_LONG).show();
                    }
                }

            });

        txt=findViewById(R.id.txt);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Already done!",Toast.LENGTH_SHORT).show();
            }
        });
        txt1=findViewById(R.id.txt1);
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Login.this,Register.class);
                startActivity(i);
            }
        });

}
}
