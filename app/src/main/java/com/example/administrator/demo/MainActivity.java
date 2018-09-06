package com.example.administrator.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text1);

        textView.setText(R.string.study);

        imgDog = findViewById(R.id.imgDog);
        btnChange = findViewById(R.id.btnChange);

        //按钮的单击事件
        // new 快捷键Ctrl+Shift+空格键
        btnChange.setOnClickListener(new View.OnClickListener() {
            //快捷键 Alt+Enter
            @Override
            public void onClick(View v) {
                //数组
                //index++; 报错，下标循环时超出范围，没有dogs.length及以上的
                index = (index+1) % dogs.length;    //实现图片的衔接
                imgDog.setImageResource(dogs[index]);
                /*
                //指定一张图片的来源路径
                imgDog.setImageResource(R.drawable.dog2);
                */
            }
        });
    }
}
