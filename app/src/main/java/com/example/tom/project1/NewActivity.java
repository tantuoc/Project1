package com.example.tom.project1;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class NewActivity extends AppCompatActivity {
    private ConstraintLayout cslayout;
    private Button buttonPush, buttonBack;
    private NotificationCompat.Builder notBuilder;


    TextView txt;
    private static final int MY_NOTIFICATION_ID = 12345;

    private static final int MY_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        // csshow = (ConstraintLayout) findViewById(R.id.csLayoutshow);

        buttonPush = (Button) findViewById(R.id.buttonPush);
        buttonBack = (Button) findViewById(R.id.buttonBack);
        txt = (TextView) findViewById(R.id.textNew);


        cslayout = (ConstraintLayout) findViewById(R.id.cslayout);
        Intent i = getIntent();
        if (i.getExtras().getBoolean("Light")) {
            cslayout.setBackgroundColor(Color.WHITE);
            txt.setText(getString(R.string.stt) + " LIGHT MODE");
            txt.setTextSize(30);
            txt.setTextColor(Color.DKGRAY);
        } else {
            cslayout.setBackgroundColor(Color.DKGRAY);
            txt.setText(getString(R.string.stt) + " DARK MODE");
            txt.setTextSize(30);
            txt.setTextColor(Color.WHITE);
        }


        buttonPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notiButtonClicked();

            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    public void notiButtonClicked() {
        this.notBuilder = new NotificationCompat.Builder(this);
        this.notBuilder.setAutoCancel(true);
        this.notBuilder.setSmallIcon(R.mipmap.ic_launcher);
        this.notBuilder.setTicker("This is a ticker");
        this.notBuilder.setWhen(System.currentTimeMillis() + 10 * 1000);
        this.notBuilder.setContentTitle(getString(R.string.app_name));
        this.notBuilder.setContentText(getString(R.string.contentnoti));
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, MY_REQUEST_CODE,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        this.notBuilder.setContentIntent(pendingIntent);
        NotificationManager notificationService =
                (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = notBuilder.build();
        notificationService.notify(MY_NOTIFICATION_ID, notification);

    }



    public void getString(View v) {
        // Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_LONG ).show();
        Intent i = new Intent(NewActivity.this, ChildActivity.class);
        i.putExtra("back", txt.getText().toString());
        startActivityForResult(i, 0);
    }


    public void getInt(View v) {
        // Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_LONG ).show();
        Intent i = new Intent(NewActivity.this, CalActivity.class);
        i.putExtra("back1", txt.getText().toString());
        startActivityForResult(i, 1);
    }


    public void show(View view) {
        switch (view.getId()) {
            case R.id.buttonshowok:
               // Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_LONG).show();
                Snackbar.make(cslayout, "Ok", Snackbar.LENGTH_INDEFINITE).setAction("HIDE", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).setDuration(2000).show();

                break;

            case R.id.buttonshowcancle:
                Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_LONG);
                Snackbar.make(cslayout, "Cancel", Snackbar.LENGTH_INDEFINITE).setAction("HIDE", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).setDuration(2000).show();

//            case R.id.buttongetint:
//                Intent i = new Intent(NewActivity.this, CalActivity.class);
//                i.putExtra("back", txt.getText().toString());
//                startActivityForResult(i, 1);
//                break;



        }


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 0:
                String message = data.getStringExtra("MESSAGE");
                txt.setText(message);
                break;
            case 1:
                String message1 = data.getStringExtra("RS");
                txt.setText(message1);
                break;


        }


    }


}
