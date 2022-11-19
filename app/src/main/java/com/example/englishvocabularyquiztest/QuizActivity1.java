package com.example.englishvocabularyquiztest;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity1 extends AppCompatActivity {
    private TextView question,noCounter1;
    private LinearLayout optLayout;
    private Button nextBtn;
    private int count=0;
    private List<QuestionModel> list;
    private int position=0;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        question=findViewById(R.id.quesID);
        noCounter1=findViewById(R.id.noCounterID1);
        optLayout=findViewById(R.id.optLayoutID);
        nextBtn=findViewById(R.id.nextBtnID);
        list=new ArrayList<>();
        list.add(new QuestionModel("Q01. The synonym of 'initiative' is-","Apathy","Indolence","Enterprise","Activity","Enterprise"));
        list.add(new QuestionModel("Q02. The synonym of 'Disdain' is-","Belittle","Brave","Beau","Beckon","Belittle"));
        list.add(new QuestionModel("Q03. The verb 'succumb' means-","Achieve","Submit","Win","Conquer","Submit"));
        list.add(new QuestionModel("Q04.The word 'Permissive' implies-","Humble","Law-abiding","Liberal","Submissive","Liberal"));
        list.add(new QuestionModel("Q05.Pick the word that is synonymous with 'authoritarian'","Autocratic","Senior","Elderly","Potential","Autocratic"));
        list.add(new QuestionModel("Q06.Find the opposite word of 'TENDER'?","hardened","leonine","tepid","difficult","hardened"));
        list.add(new QuestionModel("Q07.Find the opposite word of 'INDIGENT'?","inferior","subordinate","wealthy","insolvent","wealthy"));
        list.add(new QuestionModel("Q08.Find the same meaning word of 'OBTUSE'?","difficult","interfering","concealed","blunt","blunt"));
        list.add(new QuestionModel("Q09.Find the same meaning word of 'OSTENTATION'?","showy","wealthy","decorative","protruding","showy"));
        list.add(new QuestionModel("Q10.What would be the best antonyme of 'hibernate'","Dormancy","Liveliness","Sluggishness","Democracy","Liveliness"));

//        list.add(new QuestionModel("Q02.","aaa","bbb","ccc","ddd","eee"));



        for(int i=0; i<4; i++){
            optLayout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAnswer((Button)view);
                }
            });

        }

        playAnim(question,0,list.get(position).getQuestion());
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextBtn.setEnabled(false);
                nextBtn.setAlpha(0.07f);
                enableoption(true);
                position++;

                if(position==list.size()){
                    Intent scoreIntent=new Intent(QuizActivity1.this,ScoreActivity.class);
                    finish();
                    scoreIntent.putExtra("score",score);
                    scoreIntent.putExtra("total",list.size());
                    startActivity(scoreIntent);
                    return;
                }
                count=0;
                playAnim(question,0,list.get(position).getQuestion());
            }
        });



    }

    private void enableoption(boolean enable) {
        for(int i=0; i<4; i++){
            optLayout.getChildAt(i).setEnabled(enable);
            if(enable){
                optLayout.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3d3636")));

            }
        }
    }

    private void playAnim( final View view, final int value, final String data) {
        view.animate().alpha(value).scaleX(value).scaleY(1).setDuration(500).setStartDelay(50)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (value == 0 && count < 4) {
                    String option="";
                    if (count == 0) {
                        option = list.get(position).getOptionA();

                    } else if (count == 1) {
                        option = list.get(position).getOptionB();
                    } else if (count == 2) {
                        option = list.get(position).getOptionC();
                    } else if (count == 3) {
                        option = list.get(position).getOptionD();
                    }

                    playAnim(optLayout.getChildAt(count),0,option);
                    count++;
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(value==0){
                    try {
                        ((TextView)view).setText(data);
                        noCounter1.setText(position+1+"/"+list.size());

                    }
                    catch (ClassCastException ex){
                        ((Button)view).setText(data);
                    }
                    view.setTag(data);

                    playAnim(view,1,data);
                }

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void checkAnswer(Button selectedoption){

        enableoption(false);
        nextBtn.setEnabled(true);
        nextBtn.setAlpha(1);
        if(selectedoption.getText().toString().equals(list.get(position).getCorrectAns())){
            score++;
            selectedoption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0e9913")));

            StyleableToast.makeText(getApplicationContext(),"Right Answer",R.style.rightToast).show();
        }

        else {
            selectedoption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
            Button corectOption=(Button) optLayout.findViewWithTag(list.get(position).getCorrectAns());
            corectOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0c9913")));

            StyleableToast.makeText(getApplicationContext(),"Wrong Answer",R.style.wrongToast).show();
        }





    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(QuizActivity1.this,QuizActivity.class);
        startActivity(intent);
        finish();
    }
}