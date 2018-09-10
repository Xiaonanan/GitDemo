package com.example.administrator.demo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imgDog;
    private Button btnChange;
    private int dogs[] = {R.drawable.dog1,R.drawable.dog2,R.drawable.dog3,R.drawable.dog4,R.drawable.dog5};
    private int index = 0;
    private Handler handler;
    private final int MSG_CHANGE_DOG = 1001;
    //是否暂停
    private boolean isPause = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(msg.what == MSG_CHANGE_DOG){
                    index = (index + 1) % dogs.length;
                    imgDog.setImageResource(dogs[index]);
                    return true;
                }
                return false;
            }
        });

        textView = findViewById(R.id.text1);

        textView.setText(R.string.study);

        imgDog = findViewById(R.id.imgDog);
        btnChange = findViewById(R.id.btnChange);

        //自动切换图片，使用多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        //每隔2s休眠
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //Only the original thread that created a view hierarchy can touch its views.
                    //在子线程中不能修改主线程创建的View
                    //需要使用消息处理机制Handler，告诉主线程更新
                    if(isPause) {
                        Message message = new Message();
                        message.what = MSG_CHANGE_DOG;
                        //handler设置发送消息
                        handler.sendMessage(message);
                        //日志设置
                        Log.e("MainActivity", "send change message");
                    }
                    // index = (index + 1) % dogs.length;
                    // imgDog.setImageResource(dogs[index]);
                }
            }
        }).start();

        // new 快捷键Ctrl+Shift+空格键
        btnChange.setOnClickListener(new View.OnClickListener() {
            //快捷键 Alt+Enter
            @Override
            public void onClick(View v) {
                isPause = !isPause;
            }
        });
    }
}
