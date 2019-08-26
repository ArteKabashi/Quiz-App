package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int age;
    int points=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Results(View view) {
        EditText nameField = findViewById(R.id.edit_text_1);
        String name = nameField.getText().toString();
        if (name.matches("")) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show();
        }

        EditText editText2 = findViewById(R.id.edit_text_2);
        String numberRes = editText2.getText().toString();
        if (numberRes.matches("")) {
            Toast.makeText(this, "Please enter a number for question 5", Toast.LENGTH_SHORT).show();
            return;
        }

        checkAnswersInQuestion1();
        checkAnswersInQuestion3();
        checkAnswersInQuestion5();
        checkAnswersInQuestion2();
        checkAnswersInQuestion4();

            String resultMessage = submitResults(name, checkAnswersInQuestion1(),checkAnswersInQuestion2(), checkAnswersInQuestion3(),checkAnswersInQuestion4(), checkAnswersInQuestion5());
        displayMessage(resultMessage);
    }

    public void increment(View view) {
        age = age + 1;
        displayAge(age);
    }

    public void decrement(View view) {
        if (age > 0) {
            age = age - 1;
        } else if (age < 0) {
            age = 0;
        }
        displayAge(age);
    }

    private String submitResults(String name, String checkAnswersInQuestion1,String checkAnswersInQuestion2,String checkAnswersInQuestion3,String checkAnswersInQuestion4,String checkAnswersInQuestion5) {
        String resultMessage = "Hello, " + name;
        resultMessage += "\n";
        resultMessage += "\n" + checkAnswersInQuestion1;
        resultMessage += "\n" + checkAnswersInQuestion2;
        resultMessage += "\n" + checkAnswersInQuestion3;
        resultMessage += "\n" + checkAnswersInQuestion4;
        resultMessage += "\n" + checkAnswersInQuestion5;
        resultMessage += "\n" ;
        resultMessage += "\n" + "Points: "+ points;
        return resultMessage;
    }

    private String checkAnswersInQuestion1() {
        CheckBox checkBox21 = findViewById(R.id.number21);
        CheckBox checkBox104 = findViewById(R.id.number104);
        CheckBox checkBox34 = findViewById(R.id.number34);
        points +=points;
        if (checkBox21.isChecked() && checkBox34.isChecked()&& checkBox104.isChecked()) {
            return "Your answer for question 1 is incorrect.";
        }else if (checkBox21.isChecked() && checkBox34.isChecked()) {
            points=points+ 5;
            return "Your answer for question 1 is correct. ";
        } else if (checkBox21.isChecked() && checkBox104.isChecked()) {
            points+=points;
            return "Your answer for question 1 is incorrect.";
        } else if (checkBox34.isChecked() && checkBox104.isChecked()) {
            points+=points;
            return "Your answer for question 1 is incorrect.";
        } else if(checkBox21.isChecked()){
            return "You should select two numbers for question 1.";
        } else if(checkBox104.isChecked()){
            return "You should select two numbers for question 1.";
        } else if(checkBox34.isChecked()){
            return "You should select two numbers for question 1.";
        } else {
            return "Please select the answers for question 1.";
        }
    }

    public void checkRadioButton(View view){
        RadioButton rB1 = findViewById(R.id.radioButtonOne);
        RadioButton rB2 = findViewById(R.id.radioButtonTwo);
        RadioButton rB3 = findViewById(R.id.radioButtonThree);
    }

    private String checkAnswersInQuestion2() {
        RadioButton rB1 = findViewById(R.id.radioButtonOne);
        RadioButton rB2 = findViewById(R.id.radioButtonTwo);
        RadioButton rB3 = findViewById(R.id.radioButtonThree);
        if (rB3.isChecked()) {
            points=points+5;
            return "Your answer for question 2 is correct. ";
        } else if(rB1.isChecked() || rB2.isChecked()) {
            points+=points;
            return "Your answer for question 2 is incorrect.";
        }
        return "Please select the answer for question 2.";
        }

    private String checkAnswersInQuestion3() {
        CheckBox checkBox10 = findViewById(R.id.number10);
        CheckBox checkBox02 = findViewById(R.id.numberMinus02);
        CheckBox checkBox1 = findViewById(R.id.numberMinus1);
        if(checkBox1.isChecked()&&checkBox02.isChecked()&&checkBox10.isChecked()){
            points +=points;
            return "Your answer for question 3 is incorrect. ";
    }else if (checkBox1.isChecked() && checkBox02.isChecked()) {
            points =points+ 5;
            return "Your answer for question 3 is correct. " ;
        } else if (checkBox1.isChecked() && checkBox10.isChecked()) {
            points+=points;
            return "Your answer for question 3 is incorrect. ";
        } else if (checkBox10.isChecked() && checkBox02.isChecked()) {
            return "Your answer for question 3 is incorrect. ";
        } else if (checkBox10.isChecked()) {
            return "You should select two numbers for question 3.";
        } else if (checkBox02.isChecked()) {
            return "You should select two numbers for question 3.";
        } else if (checkBox1.isChecked()) {
            return "You should select two numbers for question 3.";
        } else {
            return "Please select the answers for question 3.";
        }
    }

    public void checkButtonTwo(View view){
        RadioButton rB201=findViewById(R.id.radioButton201);
        RadioButton rB202=findViewById(R.id.radioButton202);
        RadioButton rB203=findViewById(R.id.radioButton203);
    }

    private String checkAnswersInQuestion4() {
        RadioButton rB201 = findViewById(R.id.radioButton201);
        RadioButton rB202 = findViewById(R.id.radioButton202);
        RadioButton rB203 = findViewById(R.id.radioButton203);
        if (rB202.isChecked()) {
            points+=5;
            return "Your answer for question 4 is correct. " ;
        } else if(rB201.isChecked()||rB203.isChecked()){
            points=+points;
            return "Your answer for question 4 is incorrect. ";
        }
        return "Please select the answer for question 4.";

    }

    private String checkAnswersInQuestion5() {
        EditText editText2 = findViewById(R.id.edit_text_2);
        String numberRes = editText2.getText().toString();
        int num = Integer.parseInt(numberRes);
        if (num == 4) {
            points =points+ 5;
            return "Your answer for question 5 is correct. ";
        } else {
            points +=points;
            return "Your answer for question 5 is incorrect. ";
        }
    }


    private void displayAge(int ageNumber){
        TextView ageTextView=findViewById(R.id.age_id);
        ageTextView.setText(ageNumber);
    }

   private void displayMessage(String resultMessage){
        TextView submitResultsTextView=findViewById(R.id.results_id);
        submitResultsTextView.setText(resultMessage);
   }


}
