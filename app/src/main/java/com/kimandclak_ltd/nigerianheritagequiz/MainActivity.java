package com.kimandclak_ltd.nigerianheritagequiz;

import android.annotation.SuppressLint;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

public class MainActivity extends Activity {
    static final String STATE_SCORE = "playerScore";
    static final String STATE_QUESTION_ATTEMPTED = "questionAttempted";
    static final String STATE_QUESTION_FAILED = "questionFailed";
    int quizScore;
    private LinkedList<View> radioGroupList;
    private Set<String> questionAttempted;
    private Set<String> questionFailed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quizScore = 0;
        questionFailed = new HashSet<>();
        questionAttempted = new HashSet<>();
        radioGroupList = new LinkedList<>();
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        quizScore = savedInstanceState.getInt(STATE_SCORE);
        questionAttempted.addAll(Arrays.asList(Objects.requireNonNull(savedInstanceState.getStringArray(STATE_QUESTION_ATTEMPTED))));
        questionFailed.addAll(Arrays.asList(Objects.requireNonNull(savedInstanceState.getStringArray(STATE_QUESTION_FAILED))));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current quiz score
        String[] questionAttemptedArray = questionAttempted.toArray(new String[0]);
        String[] questionFailedArray = questionFailed.toArray(new String[0]);
        savedInstanceState.putInt(STATE_SCORE, quizScore);
        savedInstanceState.putStringArray(STATE_QUESTION_ATTEMPTED, questionAttemptedArray);
        savedInstanceState.putStringArray(STATE_QUESTION_FAILED, questionFailedArray);

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
     * @param view view
     */
    public void onCorrectRadioClicked(View view) {
        RadioButton currentRB = (RadioButton) view;
        RadioGroup radioGroup = (RadioGroup) currentRB.getParent();
        if (!radioGroupList.contains(radioGroup)) {
            increaseScoreByOne();
            radioGroupList.add(radioGroup);
        }
        //Removes question with correct answer once only.
        int idNumber = currentRB.getId();
        if (idNumber <= R.id.q1_option4) {
            questionFailed.remove("q1");
            questionAttempted.add("q1");
        }
        if (idNumber > R.id.q1_option4 && idNumber <= R.id.q2_option4) {
            questionFailed.remove("q2");
            questionAttempted.add("q2");
        }
        if (idNumber > R.id.q2_option4 && idNumber <= R.id.q3_option4) {
            questionFailed.remove("q3");
            questionAttempted.add("q3");
        }
        if (idNumber > R.id.q3_option4 && idNumber <= R.id.q4_option4) {
            questionFailed.remove("q4");
            questionAttempted.add("q4");
        }
        if (idNumber > R.id.q4_option4 && idNumber <= R.id.q5_option4) {
            questionFailed.remove("q5");
            questionAttempted.add("q5");
        }
        if (idNumber > R.id.q5_option4 && idNumber <= R.id.q6_option4) {
            questionFailed.remove("q6");
            questionAttempted.add("q6");
        }
        if (idNumber > R.id.q7_option4 && idNumber <= R.id.q8_option4) {
            questionFailed.remove("q8");
            questionAttempted.add("q8");
        }
        if (idNumber > R.id.q8_option4 && idNumber <= R.id.q9_option4) {
            questionFailed.remove("q9");
            questionAttempted.add("q9");
        }
    }

    /**
     * Decrease quiz score by only one unit if the incorrect radio button is checked
     *
     * @param view view
     */
    public void onWrongRadioBoxClicked(View view) {
        RadioButton currentRB = (RadioButton) view;
        RadioGroup radioGroup = (RadioGroup) currentRB.getParent();
        if (radioGroupList.contains(radioGroup)) {
            decreaseScoreByOne();
            radioGroupList.remove(radioGroup);
        }
        //Registers question with incorrect answer once only.
        int idNumber = currentRB.getId();
        if (idNumber <= R.id.q1_option4) {
            questionFailed.add("q1");
            questionAttempted.add("q1");
        }
        if (idNumber > R.id.q1_option4 && idNumber <= R.id.q2_option4) {
            questionFailed.add("q2");
            questionAttempted.add("q2");
        }
        if (idNumber > R.id.q2_option4 && idNumber <= R.id.q3_option4) {
            questionFailed.add("q3");
            questionAttempted.add("q3");

        }
        if (idNumber > R.id.q3_option4 && idNumber <= R.id.q4_option4) {
            questionFailed.add("q4");
            questionAttempted.add("q4");
        }
        if (idNumber > R.id.q4_option4 && idNumber <= R.id.q5_option4) {
            questionFailed.add("q5");
            questionAttempted.add("q5");
        }
        if (idNumber > R.id.q5_option4 && idNumber <= R.id.q6_option4) {
            questionFailed.add("q6");
            questionAttempted.add("q6");
        }
        if (idNumber >= R.id.q8_option1 && idNumber <= R.id.q8_option4) {
            questionFailed.add("q8");
            questionAttempted.add("q8");
        }
        if (idNumber > R.id.q8_option4 && idNumber <= R.id.q9_option4) {
            questionFailed.add("q9");
            questionAttempted.add("q9");
        }

    }

    /**
     * Indicates the question with wrong answers
     */
    @SuppressLint("SetTextI18n")
    private void indicateInCorrect(String qNumber) {
        int n;
        int correctAns;
        switch (qNumber) {
            case "q1":
                n = R.id.q1_view;
                correctAns = R.id.q1_option2;
                break;
            case "q2":
                n = R.id.q2_view;
                correctAns = R.id.q2_option4;
                break;
            case "q3":
                n = R.id.q3_view;
                correctAns = R.id.q3_option3;
                break;
            case "q4":
                n = R.id.q4_view;
                correctAns = R.id.q4_option2;
                break;
            case "q5":
                n = R.id.q5_view;
                correctAns = R.id.q5_option1;
                break;
            case "q6":
                n = R.id.q6_view;
                correctAns = R.id.q6_option4;
                break;
            case "q7":
                n = R.id.q7_view;
                correctAns = R.id.question7;
                break;
            case "q8":
                n = R.id.q8_view;
                correctAns = R.id.q8_option1;
                break;
            case "q9":
                n = R.id.q9_view;
                correctAns = R.id.q9_option2;
                break;
            case "q10":
                n = R.id.q10_view;
                correctAns = R.id.question10;
                break;
            default:
                n = 0;
                correctAns = 0;
        }
        if (!(n == 0)) {
            View qView = findViewById(n);
            qView.setBackgroundColor(0xFFFAB9B9);
            if (correctAns == R.id.question10) {
                TextView displayAns = findViewById(R.id.display_ans_q10);
                displayAns.setText("Correct Answer: Oloibiri");
            } else if (correctAns == R.id.question7) {
                CheckBox q7Option1 = findViewById(R.id.q7_option1);
                CheckBox q7Option2 = findViewById(R.id.q7_option2);
                CheckBox q7Option3 = findViewById(R.id.q7_option3);
                CheckBox q7Option4 = findViewById(R.id.q7_option4);
                q7Option1.setBackgroundColor(0xFF8DBC8F);
                q7Option2.setBackgroundColor(0xFF8DBC8F);
                q7Option3.setBackgroundColor(0xFF8DBC8F);
                q7Option4.setBackgroundColor(0xFF8DBC8F);
            } else {
                RadioButton correctRB = findViewById(correctAns);
                correctRB.setBackgroundColor(0xFF8DBC8F);
            }

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
            questionAttempted.add("q7");
            increaseScoreByOne();
        } else {
            if (q7Option1.isChecked() || q7Option2.isChecked() || q7Option3.isChecked() || q7Option4.isChecked()) {
                questionAttempted.add("q7");
                questionFailed.add("q7");

            }

        }

        //Add Score for question 10
        EditText answerTextView = findViewById(R.id.q10_EditText);
        String answerText = answerTextView.getText().toString();
        answerText = answerText.toLowerCase();
        answerText = answerText.replace(" ", "");
        if (answerText.equals("oloibiri")) {
            questionAttempted.add("q10");
            increaseScoreByOne();
        }
        else {
            if (!answerText.equals("")) {
                questionAttempted.add("q10");
                questionFailed.add("q10");
            }
        }
    }


    /**
     * Display quiz score to screen as toast if all question have been attempted else display "attempt all question" warning
     *
     * @param view view
     *
     */
    public void submitScore(View view) {
        addScoresForQ7Q10();
        Context context = getApplicationContext();
        if (questionAttempted.size() < 10) {
            Toast answerAllQuestions = Toast.makeText(context, "Please attempt all question to proceed", Toast.LENGTH_SHORT);
            answerAllQuestions.show();
            return;
        }

        //A message to indicate how good the quiz score is.
        String performMessage;
        if (quizScore == 10)
            performMessage = "Wow, you are awesome!";
        else if (quizScore > 7 && quizScore < 10)
            performMessage = "Very good!\n Any question you missed will be marked Red";
        else
            performMessage = "You can do better next time\n Any question you missed will be marked Red";
        CharSequence text = "You scored " + quizScore + " out of 10 \n" + performMessage;

        //Create toast to display quiz score.
        Toast scoreDisplay = Toast.makeText(context, text, Toast.LENGTH_LONG);
        scoreDisplay.show();

        //Disable submit button
        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setEnabled(false);
        for (String e : questionFailed) {
            indicateInCorrect(e);
        }
    }

    /**
     * Reset the layout and the score
     */
    public void resetQuiz(View view) {
        setContentView(R.layout.activity_main);
        quizScore = 0;
        questionAttempted = new HashSet<>();
        questionFailed = new HashSet<>();
        radioGroupList = new LinkedList<>();
    }
}
