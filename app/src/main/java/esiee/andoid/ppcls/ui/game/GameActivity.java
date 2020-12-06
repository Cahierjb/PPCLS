package esiee.andoid.ppcls.ui.game;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.sql.SQLOutput;

import esiee.andoid.ppcls.R;
import esiee.andoid.ppcls.controllers.askToDb;
import esiee.andoid.ppcls.model.*;

public class GameActivity  extends Activity {

    private int score1 =0;
    private int score2=0;
    private int manche=0;
    private Button jouer;
    private Toolbar toolbar;
    private ImageView pierreimg,papierimg,ciseauimg,lezardimg,spockimg,versusimg,bar, player1choice,player2choice;
    private TextView  player1,player1score,player2,player2score;
    private Coup coupj1,coupj2;
    private IA ordinateur;
    private User player;
    AlertDialog.Builder builder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        builder = new AlertDialog.Builder(this);
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
        Bundle extras = getIntent().getExtras();
        ordinateur=new IA(extras.getInt("difficulte"));
        player = (User)extras.getSerializable("currentUser");

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

    }

    private void play(){

        coupj2 = ordinateur.Joue(coupj1);
        player2choice.setBackground(ContextCompat.getDrawable(getBaseContext(), coupj2.getImage()));
        int result = coupj1.compareTo(coupj2);
        manche++;
        if (result==0){
            System.out.println("j1 gagne!");
             score1++;
             player1score.setText(String.valueOf(score1));
             System.out.println("le joueur 1 à " + score1 +" point");
        }else if(result==-1) {
            System.out.println("égalité");
            System.out.println("le joueur 2 à " + score2 +" point");
        }else{
            System.out.println("ordinateur win");
            score2++;
            player2score.setText(String.valueOf(score2));
            System.out.println("le joueur 2 à " + score2 +" point");
        }
        if (manche >= 3 ){
            finPartie();
        }


    }

    public int finPartie(){
        if(manche <=5 && score1 >= 3) {
            System.out.println("le joueur 1 a gagné");
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("vous avez win.");
            builder1.setCancelable(true);

            Toast.makeText(this, "Vous avez gagné !",
                    Toast.LENGTH_LONG).show();


            builder.setMessage(R.string.fin).setTitle(R.string.win);
            //Setting message manually and performing action on button click

            builder.setMessage("Bravo voulez vous rejouer ?")
                    .setCancelable(false)
                    .setPositiveButton("Quitter", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                            Toast.makeText(getApplicationContext(), "à une prochaine fois !",
                                    Toast.LENGTH_SHORT).show();
                        }

                    })
                    .setNegativeButton("rejouer", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //  Action for 'NO' Button
                            dialog.cancel();
                            Toast.makeText(getApplicationContext(), "rejouons ensemble !",
                                    Toast.LENGTH_SHORT).show();

                        }
                    });
            AlertDialog alert = builder.create();
            alert.setTitle("");
            alert.show();
            score1 = 0;
            score2 = 0;
            manche = 0;
            player1score.setText(String.valueOf(score1));
            player2score.setText(String.valueOf(score2));

            askToDb.SauvegardeScoreUser(player.getMail(), score1);
            return 0;
        }else{
                System.out.println("l' ordinateur a gagné");
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setMessage("ordinateur win.");
                builder1.setCancelable(true);

                Toast.makeText(this, "Vous avez perdu !",
                        Toast.LENGTH_LONG).show();

                builder.setMessage(R.string.fin) .setTitle(R.string.ordiwin);
                //Setting message manually and performing action on button click

                builder.setMessage(" Dommage, Voulez Vous rejouer ?")
                        .setCancelable(false)
                        .setPositiveButton("Quitter", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(),"à une prochaine fois !",
                                        Toast.LENGTH_SHORT).show();
                            }

                        })
                        .setNegativeButton("rejouer", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"rejouons ensemble !",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("Fin de partie");
                alert.show();
                score1=0;
                score2=0;
                manche=0;
                player1score.setText(String.valueOf(score1));
                player2score.setText(String.valueOf(score2));
                return 1;

        }
    }


}
