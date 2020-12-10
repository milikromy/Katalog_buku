package com.example.katalogbuku;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    String buku1="fiksi";
    String buku2="non";
    public static final String EXTRA_TEXT = "com.example.katalogbuku.EXTRA_TEXT";
    TextView btnFiksi, btnNonFiksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFiksi = (TextView) findViewById(R.id.buku_fIksi);
        btnFiksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fiksi = new Intent(MainActivity.this, ContohBuku.class);
                fiksi.putExtra(EXTRA_TEXT, buku1);
                startActivity(fiksi);
                MainActivity.this.finish();
            }
        });
        btnNonFiksi = (TextView) findViewById(R.id.buku_non_Iksi);
        btnNonFiksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent non_fiki = new Intent(MainActivity.this, ContohBuku.class);
                non_fiki.putExtra(EXTRA_TEXT, buku2);
                startActivity(non_fiki);
                MainActivity.this.finish();
            }
        });
    }
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(R.string.close_app);
        dialog.setNegativeButton(String.valueOf(getText(R.string.no)), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.setPositiveButton(String.valueOf(getText(R.string.yes)), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.finish();

            }
        });
        dialog.show();
    }
}