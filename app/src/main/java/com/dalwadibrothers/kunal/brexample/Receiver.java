package com.dalwadibrothers.kunal.brexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // used to send broadcast from one app to the other.
        if ("com.dalwadibrothers.kunal.EXAMPLE_ACTION".equals(intent.getAction())) {

            String receivedText = intent.getStringExtra("com.dalwadibrothers.kunal.EXTRA_TEXT");
            Toast.makeText(context, receivedText, Toast.LENGTH_SHORT).show();
        }

        //Implicit Broadcast Receiver
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Toast.makeText(context, "Boot Completed", Toast.LENGTH_SHORT).show();
        }

        //Explicit Broadcast Receiver
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {

            boolean noConnection = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

            if (noConnection) {
                Toast.makeText(context, "DIS - Connected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
            }


        }
    }
}
