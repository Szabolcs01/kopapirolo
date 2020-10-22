package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock, b_papper, b_scissors;
    ImageView im_my,im_cup;
    String svalasztas, cvalasztas, result;
    Random r;
    TextView computerEredmeny,emberEredmeny;
    int computerPont = 0;
    int emberPont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
im_cup=(ImageView) findViewById(R.id.im_cup);
        im_my=(ImageView) findViewById(R.id.im_my);
        b_rock=(Button) findViewById(R.id.b_rock);
        b_papper=(Button) findViewById(R.id.b_papper);
        b_scissors=(Button) findViewById(R.id.b_scissors);
r=new Random();
        TextView embipont = findViewById(R.id.emberEredmeny);
        TextView compipont = findViewById(R.id.computerEredmeny);

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               svalasztas="Rock";
                im_cup.setImageResource(R.drawable.rock);
            }
        });
        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svalasztas="Papper";
                im_cup.setImageResource(R.drawable.paper);
            }
        });
        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svalasztas="Scissors";
                im_cup.setImageResource(R.drawable.scissors);
            }
        });



    }

    public void calculate(){
int cup=r.nextInt(3);
if (cup==0){
    cvalasztas="Rock";

}else if(cup==1){
            cvalasztas="Papper";

}
else if(cup==2){
            cvalasztas="Scissors";

        }
if (svalasztas.equals("Rock") && cvalasztas.equals("Papper")){
    result="You Lose";
    computerPont++;
    computerEredmeny.setText(String.valueOf(computerPont));
}else
        if (svalasztas.equals("Rock") && cvalasztas.equals("Scissors")){
            result="You Win";
            emberPont++;
            emberEredmeny.setText(String.valueOf(computerPont));
        }
        else
        if (svalasztas.equals("Scissors") && cvalasztas.equals("Papper")){
            result="You Win";
            emberPont++;
            emberEredmeny.setText(String.valueOf(computerPont));
        }else
        if (svalasztas.equals("Scissors") && cvalasztas.equals("Rock")){
            result="You Lose";
            computerPont++;
            computerEredmeny.setText(String.valueOf(computerPont));
        }else
        if (svalasztas.equals("Papper") && cvalasztas.equals("Scissors")){
            result="You Lose";
            computerPont++;
            computerEredmeny.setText(String.valueOf(computerPont));
        }else
        if (svalasztas.equals("Papper") && cvalasztas.equals("Rock")){
            result="You Win";
            emberPont++;
            emberEredmeny.setText(String.valueOf(computerPont));
        }else
        if (svalasztas.equals("Scissors") && cvalasztas.equals("Scissors")){
            result="Draw";
        }else
        if (svalasztas.equals("Papper") && cvalasztas.equals("Papper")){
            result="Draw";
        }else
        if (svalasztas.equals("Rock") && cvalasztas.equals("Rock")){
            result="Draw";
        }

        Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
    }
}