package com.example.xiaoshao.call;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener{

    private LocalBroadcastManager localBroadcastManager;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;
    private Button button15;

    private IntentFilter intentFilter;
    private MyReceiver myReceiver;

    private NotificationManager notificationManager;
    private Intent intent2;
    private PendingIntent pendingIntent;
    private Notification notification;






    private TextView textView;
    static StringBuilder str = new StringBuilder();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        button1= (Button) findViewById(R.id.button_1);
        button2= (Button) findViewById(R.id.button_2);
        button3= (Button) findViewById(R.id.button_3);
        button4= (Button) findViewById(R.id.button_4);
        button5= (Button) findViewById(R.id.button_5);
        button6= (Button) findViewById(R.id.button_6);
        button7= (Button) findViewById(R.id.button_7);
        button8= (Button) findViewById(R.id.button_8);
        button9= (Button) findViewById(R.id.button_9);
        button10= (Button) findViewById(R.id.button_10);
        button11= (Button) findViewById(R.id.button_11);
        button12= (Button) findViewById(R.id.button_12);
        button13= (Button) findViewById(R.id.button_13);
        button14= (Button) findViewById(R.id.button_14);
        button15= (Button) findViewById(R.id.button_15);
        textView= (TextView) findViewById(R.id.textview);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        intent2 = new Intent(MainActivity.this, SecondActivity.class);
        pendingIntent = pendingIntent.getActivity(MainActivity.this, 0, intent2, 0);
        notification = new Notification();





        intentFilter = new IntentFilter("com.example.xiaoshao.call.2");
        myReceiver = new MyReceiver();



        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);
        button15.setOnClickListener(this);


    }

    @Override
    protected void onResume() {
        super.onResume();
//        registerReceiver(myReceiver, intentFilter);
        localBroadcastManager.registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(myReceiver);
        localBroadcastManager.unregisterReceiver(myReceiver);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_1:{
                str=str.append("1");
                textView.setText(str);

                break;
            }
            case R.id.button_2:{

                str=str.append("2");
                textView.setText(str);
                break;
            }
            case R.id.button_3:{
                str=str.append("3");
                textView.setText(str);
                break;
            }
            case R.id.button_4:{
                str=str.append("4");
                textView.setText(str);
                break;
            }
            case R.id.button_5:{
                str=str.append("5");
                textView.setText(str);
                break;
            }
            case R.id.button_6:{
                str=str.append("6");
                textView.setText(str);
                break;
            }
            case R.id.button_7:{
                str=str.append("7");
                textView.setText(str);
                break;
            }
            case R.id.button_8:{
                str=str.append("8");
                textView.setText(str);
                break;
            }
            case R.id.button_9:{
                str=str.append("9");
                textView.setText(str);
                break;
            }
            case R.id.button_10:{

                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+str.toString()));
                startActivity(intent);

                break;
            }
            case R.id.button_11:{
                str=str.append("0");
                textView.setText(str);

                break;
            }
            case R.id.button_12:{
                str.delete(0, str.length());
                str.append("");
                textView.setText(str);





                break;
            }
            case R.id.button_13:{

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                break;

            }
            case R.id.button_14:{


//                Intent intent = new Intent("com.example.xiaoshao.call.2");
//                localBroadcastManager.sendBroadcast(intent);

                BatteryInfoBroadcastReceiver batteryInfoBroadcastReceiver = new BatteryInfoBroadcastReceiver();
                IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
                MainActivity.this.registerReceiver(batteryInfoBroadcastReceiver, intentFilter);





                break;
            }
            case R.id.button_15:{

                notification.icon = R.mipmap.ic_launcher;
                notification.tickerText = "this is a notification";
                notification.defaults = Notification.DEFAULT_SOUND;
                notification.setLatestEventInfo(MainActivity.this, "button15", "notification",pendingIntent);
                notificationManager.notify(0, notification);


                break;
            }


        }

    }
}
