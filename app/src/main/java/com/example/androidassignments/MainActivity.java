package com.example.androidassignments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String tag = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity", "inside onCreate");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button mainButton = (Button) findViewById(R.id.main_button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onButtonClicked(View v){

        Intent newIntent = new Intent(MainActivity.this,
                ListItemsActivity.class);
        startActivityForResult(newIntent, 10);

    }

    public void onStartChatClicked(View v){

        Log.i(tag, "User clicked on Start Chat button");
        Intent newIntent = new Intent(MainActivity.this,
                ChatWindow.class);
        startActivityForResult(newIntent, 10);

    }

    public void onTestToolbarClicked(View v){

        Log.i(tag, "User clicked on TestToolbar button");
        Intent newIntent = new Intent(MainActivity.this,
                TestToolbar.class);
        startActivityForResult(newIntent, 10);

    }
    @Override
    public void onActivityResult(int requestCode, int responseCode, Intent data){
        super.onActivityResult(requestCode, responseCode, data);
        if(requestCode == 10){
            Log.i("MainActivity", "Returned to MainActivity.onActivityResult()");
        }
        if(responseCode == ListItemsActivity.RESULT_OK) {
            String messagePassed = data.getStringExtra("Response");
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(getApplicationContext(), messagePassed, duration);
            toast.show();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "inside onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "inside onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "inside onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "inside onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "inside onDestroy");
    }
}