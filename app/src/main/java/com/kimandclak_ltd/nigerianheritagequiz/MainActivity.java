package com.kimandclak_ltd.nigerianheritagequiz;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class MainActivity extends Activity {
    static final String STATE_SCORE = "playerScore";
    int quizScore;
    LinkedList<View> radioGroupList;
    boolean checked;
    int counter = 0;
    private ArrayDeque<String> qList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quizScore = 0;
        qList = new ArrayDeque<>();
        radioGroupList = new LinkedList<>();
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        quizScore = savedInstanceState.getInt(STATE_SCORE);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current quiz state
        savedInstanceState.putInt(STATE_SCORE, quizScore);

        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Increase quiz score by one unit
     */
    private void increaseScoreByOne() {
        quizScore++;
    }

    /**
     * Decrease quiz score by one unit
     */
    private void decreaseScoreByOne() {
        quizScore--;
    }

    /**
     * Increase quiz score by only one unit if the correct radio button is checked
     *
     * @param view
     */
    public void onCorrectRadioClicked(View view) {
        RadioButton currentRB = (RadioButton) view;
        if (!radioGroupList.contains(currentRB.getParent())) {
            increaseScoreByOne();
            radioGroupList.add((RadioGroup) currentRB.getParent());
        }
        //Removes question with correct answer once only.
        int idNumber = currentRB.getId();
        if (idNumber <= R.id.q1_option4) {
            if (qList.contains("q1")) {
                qList.remove("q1");
            }
        }
        if (idNumber > R.id.q1_option4 && idNumber <= R.id.q2_option4) {
            if (qList.contains("q2")) {
                qList.remove("q2");
            }
        }
        if (idNumber > R.id.q2_option4 && idNumber <= R.id.q3_option4) {
            if (qList.contains("q3")) {
                qList.remove("q3");
            }
        }
        if (idNumber > R.id.q3_option4 && idNumber <= R.id.q4_option4) {
            if (qList.contains("q4")) {
                qList.remove("q4");
            }
        }
        if (idNumber > R.id.q4_option4 && idNumber <= R.id.q5_option4) {
            if (qList.contains("q5")) {
                qList.remove("q5");
            }
        }
        if (idNumber > R.id.q5_option4 && idNumber <= R.id.q6_option4) {
            if (qList.contains("q6")) {
                qList.remove("q6");
            }
        }
        if (idNumber > R.id.q7_option4 && idNumber <= R.id.q8_option4) {
            if (qList.contains("q8")) {
                qList.remove("q8");
            }
        }
        if (idNumber > R.id.q8_option4 && idNumber <= R.id.q9_option4) {
            if (qList.contains("q9")) {
                qList.remove("q9");
            }
        }
    }

    /**
     * Decrease quiz score by only one unit if the incorrect radio button is checked
     *
     * @param view
     */
    public void onWrongRadioBoxClicked(View view) {
        RadioButton currentRB = (RadioButton) view;
        if (radioGroupList.contains(currentRB.getParent())) {
            decreaseScoreByOne();
            radioGroupList.remove(currentRB.getParent());
        }
        //Registers question with incorrect answer once only.
        int idNumber = currentRB.getId();
        if (idNumber <= 2131165290) {
            if (!qList.contains("q1")) {
                qList.add("q1");
            }
        }
        if (idNumber > R.id.q1_option4 && idNumber <= R.id.q2_option4) {
            if (!qList.contains("q2")) {
                qList.add("q2");
            }
        }
        if (idNumber > R.id.q2_option4 && idNumber <= R.id.q3_option4) {
            if (!qList.contains("q3")) {
                qList.add("q3");
            }
        }
        if (idNumber > R.id.q3_option4 && idNumber <= R.id.q4_option4) {
            if (!qList.contains("q4")) {
                qList.add("q4");
            }
        }
        if (idNumber > R.id.q4_option4 && idNumber <= R.id.q5_option4) {
            if (!qList.contains("q5")) {
                qList.add("q5");
            }
        }
        if (idNumber > R.id.q5_option4 && idNumber <= R.id.q6_option4) {
            if (!qList.contains("q6")) {
                qList.add("q6");
            }
        }
        if (idNumber >= R.id.q8_option1 && idNumber <= R.id.q8_option4) {
            if (!qList.contains("q8")) {
                qList.add("q8");
            }
        }
        if (idNumber > R.id.q8_option4 && idNumber <= R.id.q9_option4) {
            if (!qList.contains("q9")) {
                qList.add("q9");
            }
        }

    }

    /**
     * Indicates the question with wrong answers
     */
    private void indicateInCorrect(String qNumber) {
        int n;
        switch (qNumber) {
            case "q1":
                n = R.id.q1_view;
                break;
            case "q2":
                n = R.id.q2_view;
                break;
            case "q3":
                n = R.id.q3_view;
                break;
            case "q4":
                n = R.id.q4_view;
                break;
            case "q5":
                n = R.id.q5_view;
                break;
            case "q6":
                n = R.id.q6_view;
                break;
            case "q7":
                n = R.id.q7_view;
                break;
            case "q8":
                n = R.id.q8_view;
                break;
            case "q9":
                n = R.id.q9_view;
                break;
            case "q10":
                n = R.id.q10_view;
                break;
            default:
                n = 0;
        }
        if (!(n == 0)) {
            View qView = findViewById(n);
            qView.setBackgroundColor(0xFFFAB9B9);
        }
    }

    /**
     * Add question 7 and question 10 scores to quiz score
     */
    private void addScoresForQ7Q10() {
        //Add Score for question 7
        CheckBox q7Option1 = findViewById(R.id.q7_option1);
        CheckBox q7Option2 = findViewById(R.id.q7_option2);
        CheckBox q7Option3 = findViewById(R.id.q7_option3);
        CheckBox q7Option4 = findViewById(R.id.q7_option4);
        if (q7Option1.isChecked() && q7Option2.isChecked() && q7Option3.isChecked() && q7Option4.isChecked()) {
            increaseScoreByOne();
        } else {
            if (q7Option1.isChecked() || q7Option2.isChecked() || q7Option3.isChecked() || q7Option4.isChecked())
                qList.add("q7");

        }

        //Add Score for question 10
        EditText answerTextView = findViewById(R.id.q10_EditText);
        String answerText = answerTextView.getText().toString();
        answerText = answerText.toLowerCase();
        answerText = answerText.replace(" ", "");
        if (answerText.equals("oloibiri"))
            increaseScoreByOne();
        else {
            if (!answerText.equals("")) {
                qList.add("q10");
            }
        }
    }


    /**
     * Display quiz score to screen as toast
     *
     * @param view
     */
    public void submitScore(View view) {
        addScoresForQ7Q10();

        //A message to indicate how good the quiz score is.
        String performMessage;
        if (quizScore == 10)
            performMessage = "Wow, you are awesome!";
        else if (quizScore > 7 && quizScore < 10)
            performMessage = "Very good!\n Any question you missed will be marked Red";
        else
            performMessage = "You can do better next time\n Any question you missed will be marked Red";
        CharSequence text = "You scored " + quizScore + " out of 10 \n" + performMessage;
        int duration = Toast.LENGTH_LONG;

        //Create toast to display quiz score.
        Context context = getApplicationContext();
        Toast scoreDisplay = Toast.makeText(context, text, duration);
        scoreDisplay.show();

        //Disable submit button
        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setEnabled(false);
        for (String e : qList) {
            indicateInCorrect(e);
        }
    }

    /**
     * Reset the layout and the score
     */
    public void resetQuiz(View view) {
        setContentView(R.layout.activity_main);
        quizScore = 0;
        qList = new ArrayDeque<>();
        radioGroupList = new LinkedList<>();
    }
}
