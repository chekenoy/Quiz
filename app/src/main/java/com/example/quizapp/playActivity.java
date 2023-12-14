package com.example.quizapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class playActivity extends AppCompatActivity {
    String[] question_list = {"Как называют людей, идущих по улице?",
            "Где должны ездить машины?",
            "Как называется элемент дороги, предназначенный для движения пешеходов:",
            "Где разрешается переходить улицу пешеходам?",
            "Как нужно переходить улицу?",
            "Можно ли играть с мячом на проезжей части дороги?",
            "Что делать, если мяч выкатился на дорогу?",
            "По какой стороне улицы или тротуара нужно ходить?",
            "Какие сигналы имеют пешеходные светофоры?",
            "На какой сигнал светофора можно переходить улицу?",
    };
    String[] choose_list = {"пешеходы","водители","дети","",
            "по дороге","по тротуару","везде","",
            "обочина","тротуар","полоса движения","",
            "там, где удобно пешеходу","на светофоре или по пешеходному переходу","нигде","",
            "спокойным, твердым шагом, держа взрослого за руку","нужно быстро бежать"," медленно идти при этом петь песни","",
            "нет", "можно, если осторожно", "можно", "",
            "попросить взрослого достать его", "бежать вслед за мячом", "ничего не делать, пусть катится дальше", "",
            "по левой", "надо придерживаться правой стороны", "посередине", "",
            "только жёлтый", "красный и зеленый", "красный, зеленый, желтый", "",
            "на жёлтый", "на красный", "на зеленый", "",
    };
    String[] correct_list = {"пешеходы","по дороге","тротуар","на светофоре или по пешеходному переходу","спокойным, твердым шагом, держа взрослого за руку", "нет", "попросить взрослого достать его", "надо придерживаться правой стороны", "красный и зеленый", "на зеленый",};
    TextView cpt_question, text_question;
    Button btn_choose1, btn_choose2, btn_choose3, btn_choose4, btn_next;
    int currentQuestion = 0;
    int scorePlayer = 0;
    boolean isclickBtn = false;
    String valueChoose = "";
    Button btn_click;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_play);
            cpt_question = findViewById(R.id.cpt_question);
            text_question = findViewById(R.id.text_question);
            btn_choose1 = findViewById(R.id.btn_choose1);
            btn_choose2 = findViewById(R.id.btn_choose2);
            btn_choose3 = findViewById(R.id.btn_choose3);
            btn_choose4 = findViewById(R.id.btn_choose4);
            btn_next = findViewById(R.id.btn_next);
            findViewById(R.id.image_back).setOnClickListener(
                    a-> finish()
            );
        remplirData();
        btn_next.setOnClickListener(
                view -> {
                        if (isclickBtn){
                            isclickBtn = false;
                            if(!valueChoose.equals(correct_list[currentQuestion])){
                                Toast.makeText(playActivity.this , "Не правильно",Toast.LENGTH_LONG).show();
                                btn_click.setBackgroundResource(R.drawable.background_btn_erreur);
                            }else {
                                Toast.makeText(playActivity.this , "Правильно",Toast.LENGTH_LONG).show();
                                btn_click.setBackgroundResource(R.drawable.background_btn_correct);
                                scorePlayer++;
                            }
                            new Handler().postDelayed(() -> {
                                if(currentQuestion!=question_list.length-1){
                                    currentQuestion = currentQuestion + 1;
                                    remplirData();
                                    valueChoose = "";
                                    btn_choose1.setBackgroundResource(R.drawable.background_btn_choose);
                                    btn_choose2.setBackgroundResource(R.drawable.background_btn_choose);
                                    btn_choose3.setBackgroundResource(R.drawable.background_btn_choose);
                                    btn_choose4.setBackgroundResource(R.drawable.background_btn_choose);
                                }else {
                                    Intent intent  = new Intent(playActivity.this , ResulteActivity.class);
                                    intent.putExtra("Resute", scorePlayer);
                                    startActivity(intent);
                                    finish();
                                }
                            },2000);
                        }else {
                            Toast.makeText(playActivity.this ,  "Выберите один из них",Toast.LENGTH_LONG).show();
                        }
                }
        );
    }
    void remplirData(){
        cpt_question.setText((currentQuestion+1) + "/" + question_list.length);
        text_question.setText(question_list[currentQuestion]);
        btn_choose1.setText(choose_list[4 * currentQuestion]);
        btn_choose2.setText(choose_list[4 * currentQuestion+1]);
        btn_choose3.setText(choose_list[4 * currentQuestion+2]);
        btn_choose4.setText(choose_list[4 * currentQuestion+3]);
    }
    public void ClickChoose(View view) {
        btn_click = (Button)view;
        if (isclickBtn) {
            btn_choose1.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose2.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose3.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose4.setBackgroundResource(R.drawable.background_btn_choose);
        }
        chooseBtn();
    }
    void chooseBtn(){
        btn_click.setBackgroundResource(R.drawable.background_btn_choose_color);
        isclickBtn = true;
        valueChoose = btn_click.getText().toString();
    }
}