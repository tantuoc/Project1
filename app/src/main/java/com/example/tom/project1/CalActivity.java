package com.example.tom.project1;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class CalActivity extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        r1 = (RadioButton) findViewById(R.id.radioButton1);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton3);
        r4 = (RadioButton) findViewById(R.id.radioButton4);



        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
    }


    public void onClick(View v){
        String s1 = e1.getText().toString().trim();
        String s2 = e2.getText().toString().trim();
        if (s1==null||s1.equals("")||s2==null||s2.equals("")){
            Toast.makeText(getApplicationContext(),"A and B are not empty",Toast.LENGTH_LONG).show();
        }
        else{
            if (r1.isChecked()){
            int kq = Integer.parseInt(s1)+Integer.parseInt(s2);
                String k = kq +"";
                Intent i = new Intent();
                i.putExtra("RS",k);
                setResult(1,i);
                finish();
            }
           else if (r2.isChecked()){
                int kq = Integer.parseInt(s1)-Integer.parseInt(s2);
                String k = kq +"";
                Intent i = new Intent();
                i.putExtra("RS",k);
                setResult(1,i);
                finish();
            }
           else if (r3.isChecked()){
                int kq = Integer.parseInt(s1)*Integer.parseInt(s2);
                String k = kq +"";
                Intent i = new Intent();
                i.putExtra("RS",k);
                setResult(1,i);
                finish();
            }
            else if (r4.isChecked()){
                if(Integer.parseInt(s2)==0){
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }
                else {
                    Float kq = Integer.parseInt(s1) /Float.parseFloat(s2);
                    String k = kq + "";
                    Intent i = new Intent();
                    i.putExtra("RS", k);
                    setResult(1, i);
                    finish();
                }
            }


        }


    }

    public void onBackPressed() {

        Intent data = getIntent();
        String rs = data.getExtras().get("back1").toString();
        Intent intent=new Intent();
        intent.putExtra("RS",rs);
        setResult(1, intent);
        finish();
    }
}
