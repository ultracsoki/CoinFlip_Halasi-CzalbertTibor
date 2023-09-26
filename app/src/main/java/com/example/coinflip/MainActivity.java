package com.example.coinflip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

import kotlin.random.URandomKt;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewCoin;
    private Button buttonFej;
    private Button buttonIras;
    private TextView textViewDobasok;
    private int dobasokSzama;
    private TextView textViewGyozelem;
    private int gyozelemSzama;
    private TextView textViewVereseg;
    private int veresegSzama;
    private int tipp;
    private int randomNumber;
    private int dobasSzamlalo;
    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonFej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dobasSzamlalo++;
                tipp = 0;
                Random random = new Random();
                randomNumber = random.nextInt(2);
                //Animáció
                if (randomNumber == tipp)
                {
                    imageViewCoin.setImageResource(R.drawable.heads);
                    Toast.makeText(MainActivity.this, "Fej lett", Toast.LENGTH_SHORT).show();
                    gyozelemSzama++;
                    textViewGyozelem.setText("Győzelem: " + gyozelemSzama);
                }
                else
                {
                    imageViewCoin.setImageResource(R.drawable.tails);
                    Toast.makeText(MainActivity.this, "Írás lett", Toast.LENGTH_SHORT).show();
                    veresegSzama++;
                    textViewVereseg.setText("Vereség: " + veresegSzama);
                }
                dobasokSzama++;
                textViewDobasok.setText("Dobások: " + dobasokSzama);
                if (dobasSzamlalo == 5 || gyozelemSzama == 3 || veresegSzama == 3)
                {
                    if (gyozelemSzama > veresegSzama)
                    {
                        alertDialog.setTitle("Győzelem").create().show();
                    }
                    else
                    {
                        alertDialog.setTitle("Vereség").create().show();
                    }
                }
            }
        });

        buttonIras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dobasSzamlalo++;
                tipp = 1;
                Random random = new Random();
                randomNumber = random.nextInt(2);
                //Animáció
                if (randomNumber == tipp)
                {
                    imageViewCoin.setImageResource(R.drawable.tails);
                    Toast.makeText(MainActivity.this, "Írás lett", Toast.LENGTH_SHORT).show();
                    gyozelemSzama++;
                    textViewGyozelem.setText("Győzelem: " + gyozelemSzama);
                }
                else
                {
                    imageViewCoin.setImageResource(R.drawable.heads);
                    Toast.makeText(MainActivity.this, "Fej lett", Toast.LENGTH_SHORT).show();
                    veresegSzama++;
                    textViewVereseg.setText("Vereség: " + veresegSzama);
                }
                dobasokSzama++;
                textViewDobasok.setText("Dobások: " + dobasokSzama);
                if (dobasSzamlalo == 5 || gyozelemSzama == 3 || veresegSzama == 3)
                {
                    if (gyozelemSzama > veresegSzama)
                    {
                        alertDialog.setTitle("Győzelem").create().show();
                    }
                    else
                    {
                        alertDialog.setTitle("Vereség").create().show();
                    }
                }
            }
        });
    }

    public void init()
    {
        imageViewCoin = findViewById(R.id.imageViewCoin);
        buttonFej = findViewById(R.id.buttonFej);
        buttonIras = findViewById(R.id.buttonIras);
        textViewDobasok = findViewById(R.id.textViewDobasok);
        textViewGyozelem = findViewById(R.id.textViewGyozelem);
        textViewVereseg = findViewById(R.id.textViewVereseg);
        tipp = 0;
        dobasokSzama = 0;
        gyozelemSzama = 0;
        veresegSzama = 0;
        dobasSzamlalo = 0;
        imageViewCoin.setImageResource(R.drawable.heads);
        alertDialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Győzelem")
                .setMessage("Szeretne új játékot játszani?")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ujJatek();
                    }
                })
                .setCancelable(false);
    }

    public void ujJatek()
    {
        dobasSzamlalo = 0;
        gyozelemSzama = 0;
        veresegSzama = 0;
        dobasokSzama = 0;
        textViewDobasok.setText("Dobások: 0");
        textViewGyozelem.setText("Győzelem: 0");
        textViewVereseg.setText("Vereség: 0");
        imageViewCoin.setImageResource(R.drawable.heads);

    }
}