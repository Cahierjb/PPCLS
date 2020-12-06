package esiee.andoid.ppcls.ui.main;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import esiee.andoid.ppcls.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView user_name;
        private TextView user_score;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            user_name = itemView.findViewById(R.id.user_name);
            user_score = itemView.findViewById(R.id.user_score);
        }

        public TextView getUser_name(){
            return user_name;
        }
        public TextView getUser_score(){
            return user_score;
        }
}
