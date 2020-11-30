package esiee.andoid.ppcls.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import esiee.andoid.ppcls.R;

public class SecondFragment extends Fragment {

    private RecyclerView leaderBoard;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Add the following lines to create RecyclerView
        leaderBoard = view.findViewById(R.id.recyclerView);
        leaderBoard.setHasFixedSize(true);
        leaderBoard.setLayoutManager(new LinearLayoutManager(view.getContext()));
        leaderBoard.setAdapter(new UserScoreAdapter());


    }
}