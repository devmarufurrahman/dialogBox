package com.example.dialougebox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button singleBtn, customBtn, doubleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        singleBtn = findViewById(R.id.singleDialoug);
        doubleBtn = findViewById(R.id.doubleBtn);
        customBtn = findViewById(R.id.customBtn);

        // signle  button dialog box

        singleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder singleAlert = new AlertDialog.Builder(MainActivity.this);
                singleAlert.setTitle("Terms & Condition");
                singleAlert.setIcon(R.drawable.baseline_info_24);
                singleAlert.setMessage("Have you read the terms & condition?");
                singleAlert.setPositiveButton("Yes, I read", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Yes, you can proceed now", Toast.LENGTH_SHORT).show();
                    }
                });
                singleAlert.show();
            }
        });


        // double button dialog
        doubleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure want to Delete")
                        .setIcon(R.drawable.baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Yes this is delete", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Delete cancel", Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.show();
            }
        });

       // custom dialog
        customBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom_dialog);


                Button btnOkay = dialog.findViewById(R.id.okBtn);
                btnOkay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Closed dialog", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

    }
}