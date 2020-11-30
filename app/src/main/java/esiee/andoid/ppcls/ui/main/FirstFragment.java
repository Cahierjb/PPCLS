package esiee.andoid.ppcls.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.firebase.auth.api.fallback.service.FirebaseAuthFallbackService;

import esiee.andoid.ppcls.R;
import esiee.andoid.ppcls.ui.game.GameActivity;

public class FirstFragment extends Fragment {

    private SeekBar seek;
    private TextView text;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.seek = (SeekBar)view.findViewById(R.id.difficulte);
        this.text = (TextView) view.findViewById(R.id.textDifficulte);

        this.seek.setMax(5);
        this.seek.setProgress(1);
        this.text.setText("Difficulté de l'IA : " + seek.getProgress() + "/" + seek.getMax());

        this.seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            // When Progress value changed.
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                text.setText("Difficulté de l'IA : " + seek.getProgress() + "/" + seek.getMax());
            }
            // Notification that the user has started a touch gesture.
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            // Notification that the user has finished a touch gesture
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                text.setText("Difficulté de l'IA : " + progress + "/" + seekBar.getMax());

            }

        });

        view.findViewById(R.id.lancerLeJeu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent game = new Intent(FirstFragment.super.getActivity(), GameActivity.class);
                Bundle bund = new Bundle();
                bund.putInt("difficulte", seek.getProgress());
                game.putExtras(bund);
                startActivity(game);
            }
        });

        view.findViewById(R.id.leaderBoard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}