package com.example.test.botom_nav_test.Adapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test.botom_nav_test.Model.ExampleItem_model;
import com.example.test.botom_nav_test.R;

import java.util.ArrayList;

public class ExampleAdapter_Ryv extends RecyclerView.Adapter<ExampleAdapter_Ryv.ExampleViewHolder> {

    public static final ArrayList<Integer> all_selected_pro_items = new ArrayList<>();
    private Context mContext;
    private ArrayList<ExampleItem_model> mExampleList;//آرایه ای که مدل RYV برمیگرداند در mExampleList نگهداری میشود
    private onItemClickListener mListener;

    public ExampleAdapter_Ryv(Context context, ArrayList<ExampleItem_model> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }

    public static boolean addID(Integer ID) {
        all_selected_pro_items.add(ID);
        Log.i("LOG_selected_items", all_selected_pro_items.toString());
        return true;
    }

    public static boolean removeID(Integer ID) {
        all_selected_pro_items.remove(ID);
        Log.i("LOG_selected_items", all_selected_pro_items.toString());
        return false;
    }

    public static boolean showID(Integer ID) {
        Log.i("log", all_selected_pro_items.toString());
        return true;
    }

    public static ArrayList<Integer> setSelectedArrayList() {
        Log.i("setSelectedArrayList", all_selected_pro_items.toString());
        return all_selected_pro_items;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.cat_ryv_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        final ExampleItem_model currentItem = mExampleList.get(position);
        int $id = currentItem.get$id();
        String Name = currentItem.getName();
        final int ID = currentItem.getID();
        //String Image = currentItem.getImage();
        holder.txt_view_ryv_cat_item.setText(Name);
        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext, "id : " + currentItem.getID() + " name : " + currentItem.getName(), Toast.LENGTH_SHORT).show();

                Intent catInfoIntent = new Intent(mContext, KaridMiveActivity.class);
                catInfoIntent.putExtra("ID", currentItem.getID());
                catInfoIntent.putExtra("Name", currentItem.getName());
                mContext.startActivity(catInfoIntent);
            }
        });*/

        //Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.txt_view_ryv_cat_item);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        mListener = listener;
    }

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        //public ImageView img_view_ryv_cat_item;
        public TextView txt_view_ryv_cat_item;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            //img_view_ryv_cat_item = itemView.findViewById(R.id.img_view_ryv_cat_item);
            txt_view_ryv_cat_item = itemView.findViewById(R.id.txt_view_ryv_cat_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}