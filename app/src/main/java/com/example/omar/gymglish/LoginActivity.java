package com.example.omar.gymglish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {

    private EditText loginEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEditText = (EditText) findViewById(R.id.editText_login);
        passwordEditText = (EditText) findViewById(R.id.editText_password);
        loginButton = (Button) findViewById(R.id.button_login);
        errorTextView = (TextView) findViewById(R.id.textView_login_error);

        loginButton.setOnClickListener(new LoginButtonClickListener());
    }

    @Override
    protected void onResume() {
        super.onResume();
        errorTextView.setText(null);
        loginEditText.setText(null);
        passwordEditText.setText(null);
    }

    private class LoginButtonClickListener implements View.OnClickListener {

        UserAuthenticator authenticator = new UserAuthenticator();

        @Override
        public void onClick(View v) {
            if (authenticator.authenticate(loginEditText.getText().toString(), passwordEditText.getText().toString())) {
                Intent intent = new Intent(LoginActivity.this, WebsitesListActivity.class);
                startActivity(intent);
            } else {
                errorTextView.setText("Incorrect login or password");
            }
        }
    }
}
