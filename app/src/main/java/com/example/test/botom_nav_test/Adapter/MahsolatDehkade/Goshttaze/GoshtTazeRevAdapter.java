package com.example.test.botom_nav_test.Adapter.MahsolatDehkade.Goshttaze;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.botom_nav_test.Adapter.KaridMiveAdapter.KaridBahareRevAdapter.KaridBahareRevAdapter;
import com.example.test.botom_nav_test.Model.KaridMive.BahareModel.BahareProItem_model;
import com.example.test.botom_nav_test.Model.MahsolatDehkade.GoshtTaze.GoshtTazeModel;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshProDetail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GoshtTazeRevAdapter extends RecyclerView.Adapter<GoshtTazeRevAdapter.GoshtTazeViewHolder> {

    String proPrice_S;
    private Context mcontext;
    private ArrayList<GoshtTazeModel> mGoshtTazeItemList;

    public GoshtTazeRevAdapter(Context context, ArrayList<GoshtTazeModel> Goshttazeitem) {
        mcontext = context;
        mGoshtTazeItemList = Goshttazeitem;
    }

    @NonNull
    @Override
    public GoshtTazeRevAdapter.GoshtTazeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.goshtaze_item_layout, parent, false);
        return new GoshtTazeRevAdapter.GoshtTazeViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull GoshtTazeRevAdapter.GoshtTazeViewHolder holder, int position) {
        final GoshtTazeModel currentItem = mGoshtTazeItemList.get(position);

        String imageUrl = currentItem.getImage();
        String proName = currentItem.getName();
        int proPrice = currentItem.getPrice();

        int $id = currentItem.get$id();
        int ID = currentItem.getID();
        String Supplier = currentItem.getSupplier();
        String Description = currentItem.getDescription();


        //convert price(double) to price(string)
        proPrice_S = String.valueOf(proPrice);

        holder.txtV_goshttaze_item_pro_name.setText(proName);
        holder.txtV_goshttaze_item_pro_price.setText(proPrice_S);
        //Picasso.with(mcontext).load(imageUrl).fit().centerInside().into(holder.img_mive_bahare_item);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.img_goshttaze_item);

        //OnClickListener

        holder.card_view_goshttaze_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mcontext, "clicked", Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent(mcontext, SefareshProDetail.class);
                intent.putExtra("imageUrl", currentItem.getImage());
                intent.putExtra("proName", currentItem.getName());
                intent.putExtra("proPrice", currentItem.getPrice());
                intent.putExtra("$id", currentItem.get$id());
                intent.putExtra("ID", currentItem.getID());
                intent.putExtra("Supplier", currentItem.getSupplier());
                intent.putExtra("Description", currentItem.getDescription());
                mcontext.startActivity(intent);*/

                /*Intent intent = new Intent(mcontext, SefareshProDetail.class);
                intent.putExtra("proImage", currentItem.getImage());
                intent.putExtra("productName", currentItem.getName());
                intent.putExtra("proPrice", currentItem.getPrice());
                intent.putExtra("id", currentItem.get$id());
                intent.putExtra("ID", currentItem.getID());
                intent.putExtra("supplier", currentItem.getSupplier());
                intent.putExtra("ProductDescription", currentItem.getDescription());
                mcontext.startActivity(intent);*/ //old intent

                Intent intent = new Intent(mcontext, SefareshProDetail.class);

                intent.putExtra("proId", currentItem.getID());
                intent.putExtra("id", currentItem.get$id());
                intent.putExtra("productName", currentItem.getName());
                intent.putExtra("ProductDescription", currentItem.getDescription());
                intent.putExtra("supplier", currentItem.getSupplier());
                intent.putExtra("proPrice", currentItem.getPrice());
                intent.putExtra("proImage", currentItem.getImage());

                String s_ID = Integer.toString(currentItem.getID());
                Log.i("chk_id", s_ID);

                mcontext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mGoshtTazeItemList.size();
    }

    public /*static*/ class GoshtTazeViewHolder extends RecyclerView.ViewHolder {

        public CardView card_view_goshttaze_item;
        public ImageView img_goshttaze_item;
        public TextView txtV_goshttaze_item_pro_name;
        public TextView txtV_goshttaze_item_pro_price;

        public GoshtTazeViewHolder(@NonNull View itemView) {
            super(itemView);
            card_view_goshttaze_item = (CardView) itemView.findViewById(R.id.card_view_goshttaze_item);
            img_goshttaze_item = (ImageView) itemView.findViewById(R.id.img_goshttaze_item);
            txtV_goshttaze_item_pro_name = (TextView) itemView.findViewById(R.id.txtV_goshttaze_item_pro_name);
            txtV_goshttaze_item_pro_price = (TextView) itemView.findViewById(R.id.txtV_goshttaze_item_pro_price);
        }
    }
}
