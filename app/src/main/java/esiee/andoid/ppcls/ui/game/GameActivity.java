package esiee.andoid.ppcls.ui.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import esiee.andoid.ppcls.R;
import esiee.andoid.ppcls.model.*;

public class GameActivity  extends Activity {


    private Button jouer;
    private Toolbar toolbar;
    private ImageView pierreimg,papierimg,ciseauimg,lezardimg,spockimg,versusimg,bar, player1choice,player2choice;
    private TextView  player1,player1score,player2,player2score;
    private Coup coupj1,coupj2;
    private IA ordinateur;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        //toolbar
        //button
        jouer=(Button)findViewById(R.id.playbutton);
        //button
        //ImageView
        pierreimg= (ImageView)findViewById(R.id.pierreimg);
        papierimg= (ImageView)findViewById(R.id.papierimg);
        ciseauimg= (ImageView)findViewById(R.id.ciseauimg);
        lezardimg= (ImageView)findViewById(R.id.lezardimg);
        spockimg= (ImageView)findViewById(R.id.spockimg);
        versusimg= (ImageView)findViewById(R.id.versusimg);
        player1choice=(ImageView)findViewById(R.id.player1choice);
        player2choice=(ImageView)findViewById(R.id.player2choice);
        bar= (ImageView)findViewById(R.id.bar);
        pierreimg.setVisibility(View.VISIBLE);
        papierimg.setVisibility(View.VISIBLE);
        ciseauimg.setVisibility(View.VISIBLE);
        //ImageView
        //TextView
        player1=(TextView)findViewById(R.id.player1);
        player1score=(TextView)findViewById(R.id.player1score);
        player2=(TextView)findViewById(R.id.player2);
        player2score=(TextView)findViewById(R.id.player2score);
        //TextView
        ordinateur=new IA(1);

        pierreimg.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //code
                coupj1=new Pierre();
                //graphique
                player1choice.setBackground(ContextCompat.getDrawable(getBaseContext(), coupj1.getImage()));
            }
        });
        papierimg.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //code
                coupj1 = new Feuille();
                //graphique
                player1choice.setBackground(ContextCompat.getDrawable(getBaseContext(), coupj1.getImage()));

            }
        });
        ciseauimg.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //code
                coupj1=new Ciseau();
                //graphique
                player1choice.setBackground(ContextCompat.getDrawable(getBaseContext(), coupj1.getImage()));
            }
        });
        lezardimg.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //code
                coupj1=new Lezard();
                //graphique
                player1choice.setBackground(ContextCompat.getDrawable(getBaseContext(), coupj1.getImage()));
            }
        });
        spockimg.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //code
                coupj1=new Spock();
                //graphique
                player1choice.setBackground(ContextCompat.getDrawable(getBaseContext(), coupj1.getImage()));
            }
        });
        jouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });

        /*while(Integer.getInteger(player1score.getText().toString()) < 3  || Integer.getInteger(player2score.getText().toString()) < 3 ){
            //Le jouer choisis son coup
            Coup coupJoueur = new Pierre();
            //L'IA

        }*/


    }

    private void initialisation(){

    }

    private void play(){
        coupj2 = ordinateur.Joue(coupj1);
        player2choice.setBackground(ContextCompat.getDrawable(getBaseContext(), coupj2.getImage()));
        int result = coupj1.compareTo(coupj2);
        if (result==0){
            System.out.println("j1 gagne!");
        }else if(result==-1) {
            System.out.println("égalité");
        }else{
            System.out.println("ordinateur win");
        }

    }


}
