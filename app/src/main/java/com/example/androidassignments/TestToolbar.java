package com.example.androidassignments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import android.view.LayoutInflater;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.androidassignments.databinding.ActivityTestToolbarBinding;

public class TestToolbar extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityTestToolbarBinding binding;

    public String snackMessage = "Standard Text from Snackbar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityTestToolbarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        snackMessage = "Standard Text from Snackbar";
/*
        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_test_toolbar);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
*/

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, snackMessage, Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.toolbar_menu, m );
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem mi){
        int id = mi.getItemId();

        if(id == R.id.opt_1){
            Log.d("Toolbar", "Option 1 selected");
            Snackbar.make(findViewById(R.id.opt_1), snackMessage, Snackbar.LENGTH_LONG)
                    .setAnchorView(R.id.fab)
                    .setAction("Action", null).show();
            return true;
        }
        else if(id == R.id.opt_2){
            Log.d("Toolbar", "Option 2 selected");
            AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(TestToolbar.this);
            alertDialogBuilder.setMessage(R.string.exit_title)

                    .setTitle(R.string.exit_ques)
                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent resultIntent = new Intent();
                            finish();
                        }
                    })
                    .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    })
                    .show();
            return true;
        }
        else if(id == R.id.opt_3){
            //Log.d("Toolbar", "Option 3 selected");
            LayoutInflater inflater = this.getLayoutInflater();
            View result = null;
            result = inflater.inflate(R.layout.custom_input_layout, null);
            EditText newSnackMsg = result.findViewById(R.id.custom_msg_input);

            AlertDialog.Builder builder = new AlertDialog.Builder(TestToolbar.this);

            builder.setView(result)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            snackMessage = newSnackMsg.getText().toString();
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();

            return true;
        }
        else if(id == R.id.about){
            int duration = Toast.LENGTH_SHORT;
            String message = getString(R.string.about);
            Toast toast = Toast.makeText(getApplicationContext(), message, duration);
            toast.show();

            return true;
        }

        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        /*
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_test_toolbar);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();*/
        return false;
    }
}