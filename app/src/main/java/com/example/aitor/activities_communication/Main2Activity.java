package com.example.aitor.activities_communication;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends Activity implements View.OnClickListener {

    Bundle mainActivityInfo;
    Intent intent;
    String name;
    TextView message;
    Button accept, reject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        intent = new Intent(this, MainActivity.class);
        mainActivityInfo = getIntent().getExtras();
        name = mainActivityInfo.getString("name");

        accept = (Button) findViewById(R.id.accept);
        accept.setOnClickListener(this);
        reject = (Button) findViewById(R.id.reject);
        reject.setOnClickListener(this);
        message = (TextView) findViewById(R.id.headerMessage);
        message.setText("Hi "+name+" .Do you agree with the conditions ?");

    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.accept) {
            onAccept();
        } else if(v.getId()== R.id.reject){
            onReject();
        }
    }

    public void onAccept() {
        intent.putExtra("result","Accepted");
        startActivity(intent);
    }
    public void onReject() {
        intent.putExtra("result","Rejected");
        startActivity(intent);
    }
}
