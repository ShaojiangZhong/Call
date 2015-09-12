package com.example.xiaoshao.call;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

public class BatteryInfoBroadcastReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())){
            int level = intent.getIntExtra("level", 0);
            int scale = intent.getIntExtra("scale", 0);
            int voltage = intent.getIntExtra("voltage", 0);
            int temperature = intent.getIntExtra("temperature", 0);
            String technology = intent.getStringExtra("technology");
            Dialog dialog = new AlertDialog.Builder(context)
                    .setTitle("电池电量")
                    .setMessage(
                            "电池电量为：" + String.valueOf(level * 100 / scale) + "%" +
                                    "电池电压为：" + String.valueOf((float)voltage / 1000) + "v" +
                    "电池温度为：" + String.valueOf((float)temperature / 10) + "度")
                    .setNegativeButton("关闭", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create();
            dialog.show();


        }



    }





}
