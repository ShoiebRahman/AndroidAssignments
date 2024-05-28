package com.example.androidassignments;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class ListItemsActivity extends AppCompatActivity {


    Switch switchButton;
    CheckBox checkboxButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ListItemsActivity", "inside onCreate");
        ImageButton imgButton = (ImageButton) findViewById(R.id.imageButton2);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_items);
        switchButton = (Switch) findViewById(R.id.switch2);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    String text = getString(R.string.switch_on);
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(getApplicationContext() , text, duration);
                    toast.show();

                } else {
                    String text = getString(R.string.switch_off);
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                    toast.show();
                }
            }
        });

        checkboxButton = (CheckBox) findViewById(R.id.checkBox2);
        checkboxButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(ListItemsActivity.this);
                    alertDialogBuilder.setMessage(R.string.dialog_msg)

                            .setTitle(R.string.dialog_title)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent resultIntent = new Intent();
                                    String msgListItems = getString(R.string.msgListItems);
                                    resultIntent.putExtra("Response", msgListItems);
                                    setResult(ListItemsActivity.RESULT_OK, resultIntent);
                                    finish();
                                }
                            })
                            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            })
                            .show();
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void debugPrint(String msg) {
        int duration = Toast.LENGTH_LONG;
        Toast toastMsg = Toast.makeText(getApplicationContext(), msg, duration);
        toastMsg.show();
    }

    public void onImageClicked(View v) {
        debugPrint("DEBUG: Image Button Clicked");
        //Log.i("ListItemsActivity", "Image Button Clicked");
        Intent takePictureIntent =
                new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, 11);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11 &&
                resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageButton imgButton = (ImageButton) findViewById(R.id.imageButton2);
            imgButton.setImageBitmap(imageBitmap);

        }
    }




    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ListItemsActivity", "inside onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ListItemsActivity", "inside onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ListItemsActivity", "inside onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ListItemsActivity", "inside onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ListItemsActivity", "inside onDestroy");
    }
}