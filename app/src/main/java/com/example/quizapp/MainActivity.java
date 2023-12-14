package com.example.quizapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void main_btn(View view) {
        switch (view.getId()){
            case R.id.btn_play:
                startActivity(new Intent(MainActivity.this , playActivity.class));
                break;
            case R.id.btn_play2:
                startActivity(new Intent(MainActivity.this , playActivity2.class));
                break;
            case R.id.btn_play3:
                startActivity(new Intent(MainActivity.this , playActivity3.class));
                break;
            case R.id.btn_exit:
                this.finishAffinity();
                break;
        }
    }
}