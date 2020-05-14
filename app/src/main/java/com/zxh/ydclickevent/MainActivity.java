package com.zxh.ydclickevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zxh.annotation.ClickView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectTools.inject(this);
    }

    @ClickView({R.id.btn_qq,R.id.btn_wechat})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_qq:
                Toast.makeText(this, "qq", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wechat:
                Toast.makeText(this, "微信", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
