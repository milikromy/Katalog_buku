package com.example.katalogbuku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ContohBuku extends Activity {

    private int num_now;
    int[] fiksi = {R.drawable.malaikat_jatuh,R.drawable.dilan, R.drawable.prahu_kertas};
    int[] non_fik = {R.drawable.habibi,R.drawable.mimpi};
    Button btnNext,btnPrev,btnFirst,btnLast;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contoh_buku);
        Intent i = getIntent();
        String text = i.getStringExtra(MainActivity.EXTRA_TEXT);
        TextView title = (TextView) findViewById(R.id.text_top);
        imgView = (ImageView) findViewById(R.id.pic_view);
        btnFirst = (Button) findViewById(R.id.bFirst);
        btnLast = (Button) findViewById(R.id.bLast);
        btnNext = (Button) findViewById(R.id.bNext);
        btnPrev = (Button) findViewById(R.id.bPrev);

        if (text.equals("fiksi")){
            title.setText("Contoh Buku Fiksi");
            imgView.setImageResource(R.drawable.malaikat_jatuh);
            btnSelanjut();
            btnSebelum();
            btnPertama();
            btnterakhir();
        } else if (text.equals("non")){
            title.setText("Contoh Buku Non-Fiksi");
            imgView.setImageResource(R.drawable.habibi);
            btnSelNon();
            btnSebNon();
            btnPerNon();
            nol();
        }
    }
    public void onBackPressed() {
        Intent kembali = new Intent(ContohBuku.this, MainActivity.class );
        startActivity(kembali);
        ContohBuku.super.finish();
    }
     public void btnSelanjut(){
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num_now++;
                num_now = num_now % fiksi.length;
                imgView.setImageResource(fiksi[num_now]);
            }
        });
     }
     public void btnSelNon(){
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num_now++;
                num_now = num_now % non_fik.length;
                imgView.setImageResource(non_fik[num_now]);
            }
        });
     }
     public void btnSebelum(){
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num_now--;
                if (num_now < 0){
                    num_now = 2;
                } else{
                    //
                }
                imgView.setImageResource(fiksi[num_now]);
            }
        });
     }
     public void btnSebNon(){
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num_now--;
                if (num_now < 0){
                    num_now = 1;
                } else {
                    //
                }
                imgView.setImageResource(non_fik[num_now]);
            }
        });
     }
     public void btnPertama(){
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView.setImageResource(fiksi[0]);
            }
        });
     }
     public void btnPerNon(){
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView.setImageResource(non_fik[0]);
            }
        });
     }
     public void btnterakhir(){
        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView.setImageResource(fiksi[2]);
            }
        });

     }
     public void nol (){
        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView.setImageResource(non_fik[1]);
            }
        });
     }

}