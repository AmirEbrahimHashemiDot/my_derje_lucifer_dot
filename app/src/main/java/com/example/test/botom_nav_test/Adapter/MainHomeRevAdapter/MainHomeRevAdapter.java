package com.example.test.botom_nav_test.Adapter.MainHomeRevAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.test.botom_nav_test.Model.MainHomeModel.MainHomeModel;
import com.example.test.botom_nav_test.R;

import java.util.List;

public class MainHomeRevAdapter extends RecyclerView.Adapter<MainHomeRevAdapter.MainHomeViewHolder> {

    private Context mContext;
    private List<MainHomeModel> mHomeModels;
    private OnClickHomeListener mOnClickHomeListener;

    public MainHomeRevAdapter(Context mContext, List<MainHomeModel> mHomeModels, OnClickHomeListener onClickHomeListener) {
        this.mContext = mContext;
        this.mHomeModels = mHomeModels;
        this.mOnClickHomeListener = onClickHomeListener;
    }

    @NonNull
    @Override
    public MainHomeRevAdapter.MainHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.main_home_item_layout, parent, false);

        return new MainHomeViewHolder(view, mOnClickHomeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHomeRevAdapter.MainHomeViewHolder holder, int position) {
        holder.main_home_item_txtview.setText(mHomeModels.get(position).getItem_title());
        holder.main_home_item_imgview.setImageResource(mHomeModels.get(position).getItem_image());
    }

    @Override
    public int getItemCount() {
        return mHomeModels.size();
    }

    public interface OnClickHomeListener {
        void onHomeClick(int position);
    }

    public class MainHomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public CardView main_home_item_cardview;
        public TextView main_home_item_txtview;
        public ImageView main_home_item_imgview;
        public OnClickHomeListener onClickHomeListener;

        public MainHomeViewHolder(View itemView, OnClickHomeListener onClickHomeListener) {
            super(itemView);

            main_home_item_txtview = (TextView) itemView.findViewById(R.id.main_home_item_txtview);
            main_home_item_imgview = (ImageView) itemView.findViewById(R.id.main_home_item_imgview);
            main_home_item_cardview = (CardView) itemView.findViewById(R.id.main_home_item_cardview);


            /*try {
                YoYo.with(Techniques.Hinge)*//*Tada*//*
                        .duration(1000)
                        .repeat(5)
                        .playOn(itemView.findViewById(R.id.main_home_item_imgview));
            } catch (Exception anim_e) {
                anim_e.printStackTrace();
                Log.i("anim_error", anim_e.getMessage().toString());
            }*/


            this.onClickHomeListener = onClickHomeListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickHomeListener.onHomeClick(getAdapterPosition());
        }
    }
}