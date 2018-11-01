package com.example.aitor.activities_communication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Bundle Main2ActivityInfo;

    String nameToSend, accpt_rejectInfo;

    Button checkButton;
    EditText inputName;
    TextView resultView;
    String viewText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this,Main2Activity.class);

        viewText = "Result: ";

        checkButton = (Button) findViewById(R.id.checkButton);
        inputName = (EditText) findViewById(R.id.inputName);
        resultView = (TextView) findViewById(R.id.resultView);

        resultView.setText("Result: ");
        checkButton.setOnClickListener(this);
        inputName.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.checkButton)
            test();
    }

    public void test(){


        nameToSend = inputName.getText().toString();

        if(nameToSend.length() <= 0) {
            Toast toast = Toast.makeText(this,"Please introduce a name", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            intent.putExtra("name",nameToSend);
            startActivity(intent);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        Main2ActivityInfo = getIntent().getExtras();

        if(Main2ActivityInfo != null) {
            accpt_rejectInfo = Main2ActivityInfo.getString("result");
            viewText+=accpt_rejectInfo;
            resultView.setText(viewText);
        }
     }
}
