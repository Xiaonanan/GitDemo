package com.example.yls.demoa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imgDog;
    private Button btnChange;
    //图片，id等通过编译成R资源；是一个内存地址
    private int[] dogs = {R.drawable.dog1,R.drawable.dog2,R.drawable.dog3,
    R.drawable.dog4,R.drawable.dog5};
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgDog = findViewById(R.id.imgDog);
        btnChange = findViewById(R.id.btnChange);

        //new 快捷键Ctrl+Shift+空格
        btnChange.setOnClickListener(new View.OnClickListener() {

            //Alt+Enter实现方法
            @Override
            public void onClick(View view) {
                index = (index+1)%dogs.length;
                imgDog.setImageResource(dogs[index]);
            }
        });
    }
}
