package com.example.quizapp;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;

import com.example.quizapp.R;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


import android.widget.Button;
import android.widget.TextView;

public class sub3 extends AppCompatActivity implements View.OnClickListener {

    TextView total_QuestionsTextView;
    TextView questionsTextView;
    Button ans_a,ans_b,ans_c,ans_d;
    Button submitBtn;

    int score=0;
    int totalQuestion = com.example.quizapp.QuestionAnswersub3.question.length;
    int currentQuestionIndex=0;
    String selectedAnswer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub3);

        total_QuestionsTextView= findViewById(R.id.total_Questions);
        questionsTextView= findViewById(R.id.questions);
        ans_a = findViewById(R.id.ans_a);
        ans_b =findViewById(R.id.ans_b);
        ans_c =findViewById(R.id.ans_c);
        ans_d =findViewById(R.id.ans_d);
        submitBtn = findViewById(R.id.submitBtn);


        ans_a.setOnClickListener(this);
        ans_b.setOnClickListener(this);
        ans_c.setOnClickListener(this);
        ans_d.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        total_QuestionsTextView.setText("Total Questions:"+totalQuestion);

        loadNewQuestion();

    }


    @Override
    public void onClick(View v) {
        Object view;
        Button clickedButton =(Button) v;
        if(clickedButton.getId()==R.id.submitBtn){
            if(selectedAnswer.equals(com.example.quizapp.QuestionAnswersub3.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();


        }else{
            selectedAnswer=clickedButton.getText().toString();
           // clickedButton.setBackgroundColor(Color.MAGENTA);
        }

    }

    void loadNewQuestion() {
        if(currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }
        questionsTextView.setText(com.example.quizapp.QuestionAnswersub3.question[currentQuestionIndex]);
        ans_a.setText(com.example.quizapp.QuestionAnswersub3.choices[currentQuestionIndex][0]);
        ans_b.setText(com.example.quizapp.QuestionAnswersub3.choices[currentQuestionIndex][1]);
        ans_c.setText(com.example.quizapp.QuestionAnswersub3.choices[currentQuestionIndex][2]);
        ans_d.setText(com.example.quizapp.QuestionAnswersub3.choices[currentQuestionIndex][3]);
    }
    void finishQuiz() {
        String passStatus ="";
        if(score > totalQuestion*0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is"+""+score+""+"out of"+""+totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz())
                .setCancelable(false).show();
    }
    void restartQuiz() {
        score=0;
        currentQuestionIndex=0;
        loadNewQuestion();
    }
}