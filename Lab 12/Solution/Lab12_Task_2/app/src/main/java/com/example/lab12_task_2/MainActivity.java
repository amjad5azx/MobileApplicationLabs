package com.example.lab12_task_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView commentsTextView;
    private EditText commentEditText;
    private Button saveButton;
    private SharedPreferences sharedPreferences;

    private static final String PREFS_NAME = "CommentPrefs";
    private static final String COMMENTS_KEY = "Comments";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        commentsTextView = findViewById(R.id.commentsTextView);
        commentEditText = findViewById(R.id.commentEditText);
        saveButton = findViewById(R.id.saveButton);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        displayPreviousComments();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = commentEditText.getText().toString();
                saveComment(comment);
            }
        });
    }

    private void saveComment(String comment) {
        String existingComments = sharedPreferences.getString(COMMENTS_KEY, "");
        String newComments = existingComments + "\n" + comment;

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(COMMENTS_KEY, newComments);
        editor.apply();

        appendCommentToTextView(comment);
        commentEditText.setText("");
    }

    private void displayPreviousComments() {
        String existingComments = sharedPreferences.getString(COMMENTS_KEY, "");
        commentsTextView.setText(existingComments);
    }

    private void appendCommentToTextView(String comment) {
        String existingComments = commentsTextView.getText().toString();
        String newComments = existingComments + "\n" + comment;
        commentsTextView.setText(newComments);
    }
}