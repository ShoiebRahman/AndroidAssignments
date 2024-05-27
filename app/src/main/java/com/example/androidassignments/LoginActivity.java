package com.example.androidassignments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText usernm;
    EditText passtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("LoginActivity", "inside onCreate");
        Button myButton = (Button) findViewById(R.id.login_button);
        setContentView(R.layout.activity_login);
        loadUserData();

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onLoginClicked(View v){

        usernm = (EditText) findViewById(R.id.edit_email);
        passtxt = (EditText) findViewById(R.id.edit_pass);
        String email = usernm.getText().toString().trim();
        String passwd = passtxt.getText().toString().trim();

        if(verifyInput(email, passwd))
        {
            saveUserData();
            Intent mIntent = new Intent(LoginActivity.this,
                    MainActivity.class);
            startActivity(mIntent);
        }
        else return;
    }

    private boolean verifyInput(String email, String passwd) {

        int duration = Toast.LENGTH_LONG;
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Log.i("LoginActivity", "Invalid Email");
            String text = this.getString(R.string.incr_email);
            Toast toast = Toast.makeText(getApplicationContext(), text, duration);
            toast.show();
            return false;
        }
        else if ( passwd.isEmpty()) {
            Log.i("LoginActivity", "Invalid Password");
            String text = this.getString(R.string.incr_passwd);
            Toast toast = Toast.makeText(getApplicationContext(), text, duration);
            toast.show();
            return false;
        }
        else {
            return true;
        }
    }

    private void saveUserData() {
        Log.d("LoginActivity", "saveUserData()");
        // Getting the shared preferences editor
        String preference_file_name = getString(R.string.preference_name);
        SharedPreferences mPrefs = getSharedPreferences(preference_file_name,
                MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mPrefs.edit();
        mEditor.clear();
        // Save email information
        String email_key = getString(R.string.preference_key_profile_email);
        String new_email_entered = (String) ((EditText)
                findViewById(R.id.edit_email)).getText().toString();
        mEditor.putString(email_key, new_email_entered);
        // Commit all the changes into the shared preference
        mEditor.commit();
    }

    private void loadUserData() {
        Log.d("LoginActivity", "loadUserData()");

        String preference_file_name = getString(R.string.preference_name);
        SharedPreferences mPrefs =
                getSharedPreferences(preference_file_name, MODE_PRIVATE);

        String email_key = getString(R.string.preference_key_profile_email);
        String new_email_value = mPrefs.getString(email_key, "abc@example.com");
        ((EditText) findViewById(R.id.edit_email)).setText(new_email_value);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LoginActivity", "inside onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LoginActivity", "inside onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LoginActivity", "inside onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LoginActivity", "inside onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LoginActivity", "inside onDestroy");
    }
}