package com.example.ksamp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterActivity extends AppCompatActivity {
    EditText editText;
//    Button enterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
//        enterButton = (Button)findViewById(R.id.enterButton);
        editText = (EditText)findViewById(R.id.editText);

        /*
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                String username = editText.getText().toString();
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });
        */
    }

    public void OnClickHandle(View view)
    {
        Intent resultIntent = new Intent();

        resultIntent.putExtra("username", editText.getText().toString());

        //resultIntent.putExtra("name", editText_name.getText().toString());
        //resultIntent.putExtra("number", editText_number.getText().toString());

        setResult(Code.resultCode, resultIntent);
        finish();
    }
}