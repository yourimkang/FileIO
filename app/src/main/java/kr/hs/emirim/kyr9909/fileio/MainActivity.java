package kr.hs.emirim.kyr9909.fileio;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    Button butOut, butIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butOut=(Button)findViewById(R.id.but_output);
        butIn=(Button)findViewById(R.id.but_input);
        butOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream out = openFileOutput("1017rim.txt", Context.MODE_WORLD_WRITEABLE);
                    String massage="미림정보과학고 학생들이 제일 예쁘다.";
                    out.write(massage.getBytes());
                    out.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
        });

        butIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream in = openFileInput("1017rim.txt");
                    byte[] readMessage=new byte[200];
                    in.read(readMessage);
                    Toast.makeText(getApplicationContext(),new String(readMessage), Toast.LENGTH_LONG).show();
                    in.close();

                } catch (java.io.IOException e) {
                    Toast.makeText(getApplicationContext(),"파일이 존재하지 않는다.", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }
}
