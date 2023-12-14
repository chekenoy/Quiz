package com.example.quizapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class playActivity2 extends AppCompatActivity {
    String[] question_list = {"Какой сигнал должны включить водители, чтобы показать, что они собираются повернуть налево?",
            "Как водитель должен передвигаться по перекрестку с круговым движением?",
            "Что означает желтый сигнал светофора?",
            "Каким должно быть поведение водителя при обгоне другого транспортного средства?",
            " Что означает знак Движение запрещено?",
            "Сколько полос движения должно быть свободно, чтобы совершить разворот?",
            "Каким должно быть расстояние между автомобилями при движении?",
            "Когда водителю разрешено разговаривать по мобильному телефону без использования гарнитуры?",
            "Водитель считается пристегнутым, если его пристегнул:",
            "Какой максимально допустимый уровень алкоголя в крови для водителей?",
    };
    String[] choose_list = {"Фары","Задние фонари","Левый указатель поворота","",
            "Проезжая перекресток, не снижая скорость","Уступая дорогу только справа.","Двигаясь по круговому движению по внешней стороне.","",
            "Остановиться и ожидать изменения сигнала","Переключиться на более высокую скорость","Продолжать движение, но быть готовым к остановке","",
            "Убедиться, что дорога свободна оказаться и продолжать обгон","Подать звуковой сигнал и сразу начинать обгон","Убедиться, что дорога свободна и выполнить маневр","",
            "Пешеходам запрещено переходить дорогу","Велосипедистам запрещено ездить","Движение транспортных средств запрещено","",
            "Не менее одной", "Не менее двух", "Не менее трех", "",
            "Только водителю известно", "Расстояние должно быть таким, чтобы можно было свободно остановиться в случае необходимости", "Расстояние не имеет значения", "",
            "Только при простое", "В любое время при движении", "Разговаривать по мобильному телефону без использования гарнитуры запрещено", "",
            "Пассажир на переднем сиденье", "Пассажир на заднем сиденье", "Сам водитель", "",
            "0,2 ‰", "1,0 ‰", "0,5 ‰", "",
    };
    String[] correct_list = {"Левый указатель поворота","Проезжая перекресток, не снижая скорость","Продолжать движение, но быть готовым к остановке","Убедиться, что дорога свободна и выполнить маневр", "Движение транспортных средств запрещено", "Не менее одной", "Расстояние должно быть таким, чтобы можно было свободно остановиться в случае необходимости", "Разговаривать по мобильному телефону без использования гарнитуры запрещено","Сам водитель",  "0,5 ‰",};
    TextView cpt_question , text_question;
    Button btn_choose1 , btn_choose2 , btn_choose3 , btn_choose4 , btn_next;
    int currentQuestion =  0  ;
    int scorePlayer =  0  ;
    boolean isclickBtn = false;
    String valueChoose = "";
    Button btn_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play2);
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
                            Toast.makeText(playActivity2.this , "Не правильно",Toast.LENGTH_LONG).show();
                            btn_click.setBackgroundResource(R.drawable.background_btn_erreur);
                        }else {
                            Toast.makeText(playActivity2.this , "Правильно",Toast.LENGTH_LONG).show();
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
                                Intent intent  = new Intent(playActivity2.this , ResulteActivity.class);
                                intent.putExtra("Resute" , scorePlayer);
                                startActivity(intent);
                                finish();
                            }
                        },2000);
                    }else {
                        Toast.makeText(playActivity2.this ,  "Выберите один из них",Toast.LENGTH_LONG).show();
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