package esiee.andoid.ppcls.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import esiee.andoid.ppcls.R;
import esiee.andoid.ppcls.controllers.askToDb;
import esiee.andoid.ppcls.model.User;

public class UserScoreAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    List<User> listUsers = null;

    public UserScoreAdapter() {
        askToDb.setListUsers();
        listUsers = askToDb.getListUsers();
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.recyclerview_viewholder;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.getUser_name().setText(listUsers.get(position).getUsername());
        holder.getUser_name().setText(listUsers.get(position).getScore());
    }

    @Override
    public int getItemCount() {
        return listUsers.size();
    }

}
