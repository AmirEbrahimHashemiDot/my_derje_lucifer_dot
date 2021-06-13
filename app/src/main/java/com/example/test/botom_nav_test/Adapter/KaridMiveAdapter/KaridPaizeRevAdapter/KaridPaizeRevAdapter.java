package com.example.test.botom_nav_test.Adapter.KaridMiveAdapter.KaridPaizeRevAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.botom_nav_test.Model.KaridMive.BahareModel.BahareProItem_model;
import com.example.test.botom_nav_test.Model.KaridMive.PaizeModel.PaizeProItem_model;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshProDetail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class KaridPaizeRevAdapter extends RecyclerView.Adapter<KaridPaizeRevAdapter.KaridPaizeViewHolder> {

    String proPrice_S;
    private Context mcontext;
    private ArrayList<PaizeProItem_model> mPaizeProItemList;


    public KaridPaizeRevAdapter(Context context, ArrayList<PaizeProItem_model> Paizeproitem) {
        mcontext = context;
        mPaizeProItemList = Paizeproitem;
    }

    @NonNull
    @Override
    public KaridPaizeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.paize_item_layout, parent, false);
        return new KaridPaizeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KaridPaizeViewHolder holder, int position) {

        final PaizeProItem_model currentItem = mPaizeProItemList.get(position);

        String imageUrl = currentItem.getImage();
        String proName = currentItem.getName();
        int proPrice = currentItem.getPrice();

        proPrice_S = String.valueOf(proPrice);

        holder.txtV_mive_paize_item_pro_name.setText(proName);
        holder.txtV_mive_paize_item_pro_price.setText(proPrice_S);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.img_mive_paize_item);

        holder.card_view_paize_item.setOnClickListener(new View.OnClickListener() {
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
                Intent intent = new Intent(mcontext, SefareshProDetail.class);
                /*intent.putExtra("proImage", currentItem.getImage());
                intent.putExtra("productName", currentItem.getName());
                intent.putExtra("proPrice", currentItem.getPrice());
                intent.putExtra("id", currentItem.get$id());
                intent.putExtra("ID", currentItem.getID());
                intent.putExtra("supplier", currentItem.getSupplier());
                intent.putExtra("ProductDescription", currentItem.getDescription());*/

                intent.putExtra("proId", currentItem.getID());
                intent.putExtra("id", currentItem.get$id());
                intent.putExtra("productName", currentItem.getName());
                intent.putExtra("ProductDescription", currentItem.getDescription());
                intent.putExtra("supplier", currentItem.getSupplier());
                intent.putExtra("proPrice", currentItem.getPrice());
                intent.putExtra("proImage", currentItem.getImage());

                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPaizeProItemList.size();
    }


    public class KaridPaizeViewHolder extends RecyclerView.ViewHolder {

        public CardView card_view_paize_item;
        public ImageView img_mive_paize_item;
        public TextView txtV_mive_paize_item_pro_name;
        public TextView txtV_mive_paize_item_pro_price;

        public KaridPaizeViewHolder(@NonNull View itemView) {
            super(itemView);
            card_view_paize_item = (CardView) itemView.findViewById(R.id.card_view_paize_item);
            img_mive_paize_item = (ImageView) itemView.findViewById(R.id.img_mive_paize_item);
            txtV_mive_paize_item_pro_name = (TextView) itemView.findViewById(R.id.txtV_mive_paize_item_pro_name);
            txtV_mive_paize_item_pro_price = (TextView) itemView.findViewById(R.id.txtV_mive_paize_item_pro_price);
        }
    }
}