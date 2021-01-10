package com.example.ksamp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    // TextView textView;
    // Handler handler = new Handler();
    public InputStream dataIs;
    public OutputStream dataOs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btn1);
        //textView = (TextView)findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClientThread thread = new ClientThread();
                thread.start();
            }
        });
    }

    class ClientThread extends Thread {
        @Override
        public void run() {
            int port = 3337;
            String host = "122.34.51.3";
            //int port = 3337;
            //String host = "192.168.0.1";
            try {
                Socket socket = new Socket(host, port);
                //ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
                //outStream.writeObject("kroothii");
                //outStream.flush();
                dataOs = socket.getOutputStream();
                dataIs = socket.getInputStream();

                //byte[] buff = new byte[1024] = "1234";
                int rtn;
                byte[] buff = "1234".getBytes();

                 dataOs.write(buff);

                Log.d("ClientStream", "Send to Server OK");

                //ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());
                //Object input = (String) instream.readObject();
                rtn = dataIs.read(buff);
                String tmp = new String(buff, 0, rtn);
                Log.d("ClientThread", "Recv: " + tmp);

                //final Object input = (String) instream.readObject();
                //handler.post(new Runnable() {
                //    @Override
                //    public void run() {
                 //       textView.setText("Recv: " + input);
                 //   }
                // });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}