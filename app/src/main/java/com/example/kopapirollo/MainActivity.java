package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock, b_papper, b_scissors;
    ImageView im_my, im_cup;
    String svalasztas, cvalasztas, result;
    Random r;
    TextView computerEredmeny, emberEredmeny,dontetlen;
    int computerPont = 0;
    int emberPont = 0;
    int dontetlenPont=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im_cup = (ImageView) findViewById(R.id.im_cup);
        im_my = (ImageView) findViewById(R.id.im_my);
        b_rock = (Button) findViewById(R.id.b_rock);
        b_papper = (Button) findViewById(R.id.b_papper);
        b_scissors = (Button) findViewById(R.id.b_scissors);
        r = new Random();
        TextView emberPont = findViewById(R.id.emberEredmeny);
        TextView computerPont = findViewById(R.id.computerEredmeny);
        TextView dontetlenPont = findViewById(R.id.dontetlen);
        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svalasztas = "Rock";
                im_cup.setImageResource(R.drawable.rock);
                calculate();
                jatekVege();
            }
        });
        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svalasztas = "Papper";
                im_cup.setImageResource(R.drawable.paper);
                calculate();
                jatekVege();
            }
        });
        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svalasztas = "Scissors";
                im_cup.setImageResource(R.drawable.scissors);
                calculate();
                jatekVege();
            }
        })

        ;


    }

    public void calculate() {
        int cup = r.nextInt(3);
        if (cup == 0) {
            cvalasztas = "Rock";

        } else if (cup == 1) {
            cvalasztas = "Papper";

        } else if (cup == 2) {
            cvalasztas = "Scissors";

        }
        if (svalasztas.equals("Rock") && cvalasztas.equals("Papper")) {
            result = "You Lose";
            computerPont++;
            computerEredmeny.setText(String.valueOf(computerPont));
            jatekVege();
        } else if (svalasztas.equals("Rock") && cvalasztas.equals("Scissors")) {
            result = "You Win";
            emberPont++;
            emberEredmeny.setText(String.valueOf(emberEredmeny));
            jatekVege();
        } else if (svalasztas.equals("Scissors") && cvalasztas.equals("Papper")) {
            result = "You Win";
            emberPont++;
            emberEredmeny.setText(String.valueOf(emberEredmeny));
            jatekVege();
        } else if (svalasztas.equals("Scissors") && cvalasztas.equals("Rock")) {
            result = "You Lose";
            computerPont++;
            computerEredmeny.setText(String.valueOf(computerPont));
            jatekVege();
        } else if (svalasztas.equals("Papper") && cvalasztas.equals("Scissors")) {
            result = "You Lose";
            computerPont++;
            computerEredmeny.setText(String.valueOf(computerPont));
            jatekVege();
        } else if (svalasztas.equals("Papper") && cvalasztas.equals("Rock")) {
            result = "You Win";
            emberPont++;
            emberEredmeny.setText(String.valueOf(emberEredmeny));
            jatekVege();
        } else if (svalasztas.equals("Scissors") && cvalasztas.equals("Scissors")) {
            result = "Draw";
            dontetlenPont++;
            dontetlen.setText(String.valueOf(dontetlen));
        } else if (svalasztas.equals("Papper") && cvalasztas.equals("Papper")) {
            result = "Draw";
            dontetlenPont++;
            dontetlen.setText(String.valueOf(dontetlen));
        } else if (svalasztas.equals("Rock") && cvalasztas.equals("Rock")) {
            result = "Draw";
            dontetlenPont++;
            dontetlen.setText(String.valueOf(dontetlen));
        }

        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
        emberPont++;
        emberEredmeny.setText(String.valueOf(emberPont));
        jatekVege();
    }

    public void jatekVege() {
        TextView embipont = findViewById(R.id.emberEredmeny);
        TextView compipont = findViewById(R.id.computerEredmeny);
        if (emberPont == 3 || computerPont == 3) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Szeretne új játékot játszani?")
                    .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            emberPont = 0;
                            computerPont = 0;
                            embipont.setText("0");
                            compipont.setText("0");


                        }
                    }).setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();

        }
    }
}