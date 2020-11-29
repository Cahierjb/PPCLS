package esiee.andoid.ppcls.ui.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import esiee.andoid.ppcls.R;
import esiee.andoid.ppcls.model.*;

public class GameActivity  extends Activity {



    private Toolbar toolbar;
    private Button pierre;
    private ImageView pierreimg,papierimg,ciseauimg,lezardimg,spockimg,versusimg,bar, player1choice,player2choice;
    private TextView  player1,player1score,player2,player2score;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        //toolbar
        //ImageView
        pierre= (Button)findViewById(R.id.pierre);
        papierimg= (ImageView)findViewById(R.id.papierimg);
        ciseauimg= (ImageView)findViewById(R.id.ciseauimg);
        lezardimg= (ImageView)findViewById(R.id.lezardimg);
        spockimg= (ImageView)findViewById(R.id.spockimg);
        versusimg= (ImageView)findViewById(R.id.versusimg);
        player1choice=(ImageView)findViewById(R.id.player1choice);
        player2choice=(ImageView)findViewById(R.id.player2choice);
        bar= (ImageView)findViewById(R.id.bar);
        //ImageView
        //TextView
        player1=(TextView)findViewById(R.id.player1);
        player1score=(TextView)findViewById(R.id.player1score);
        player2=(TextView)findViewById(R.id.player2);
        player2score=(TextView)findViewById(R.id.player2score);
        //TextView




        while(Integer.getInteger(player1score.getText().toString()) < 3  || Integer.getInteger(player2score.getText().toString()) < 3 ){
            //Le jouer choisis son coup
            Coup coupJoueur = new Pierre();
            //L'IA

        }

    }

    private void initialisation(){

    }


}
