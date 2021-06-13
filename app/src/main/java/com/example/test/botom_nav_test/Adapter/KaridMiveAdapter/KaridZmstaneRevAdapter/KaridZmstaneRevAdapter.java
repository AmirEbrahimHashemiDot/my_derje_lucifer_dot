package com.example.test.botom_nav_test.Adapter.KaridMiveAdapter.KaridZmstaneRevAdapter;

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

import com.example.test.botom_nav_test.Adapter.KaridMiveAdapter.KaridBahareRevAdapter.KaridBahareRevAdapter;
import com.example.test.botom_nav_test.Model.KaridMive.BahareModel.BahareProItem_model;
import com.example.test.botom_nav_test.Model.KaridMive.ZemestaneModel.ZemestaneProItem_model;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshProDetail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class KaridZmstaneRevAdapter extends RecyclerView.Adapter<KaridZmstaneRevAdapter.KaridZemestaneViewHolder> {


    String proPrice_S;
    private Context mcontext;
    private ArrayList<ZemestaneProItem_model> mZemestaneProItemList;

    public KaridZmstaneRevAdapter(Context context, ArrayList<ZemestaneProItem_model> Zemestaneproitem) {
        mcontext = context;
        mZemestaneProItemList = Zemestaneproitem;
    }

    @NonNull
    @Override
    public KaridZemestaneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.zmstane_item_layout, parent, false);
        return new KaridZemestaneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KaridZemestaneViewHolder holder, int position) {
        final ZemestaneProItem_model currentItem = mZemestaneProItemList.get(position);

        String imageUrl = currentItem.getImage();
        String proName = currentItem.getName();
        int proPrice = currentItem.getPrice();

        proPrice_S = String.valueOf(proPrice);

        holder.txtV_mive_zmstane_item_pro_name.setText(proName);
        holder.txtV_mive_zmstane_item_pro_price.setText(proPrice_S);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.img_mive_zmstane_item);

        holder.card_view_zmstane_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, SefareshProDetail.class);
                /*intent.putExtra("ID", currentItem.getID());
                intent.putExtra("proImage", currentItem.getImage());
                intent.putExtra("productName", currentItem.getName());
                intent.putExtra("proPrice", currentItem.getPrice());
                intent.putExtra("id", currentItem.get$id());
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
        return mZemestaneProItemList.size();
    }


    public class KaridZemestaneViewHolder extends RecyclerView.ViewHolder {

        public CardView card_view_zmstane_item;
        public ImageView img_mive_zmstane_item;
        public TextView txtV_mive_zmstane_item_pro_name;
        public TextView txtV_mive_zmstane_item_pro_price;

        public KaridZemestaneViewHolder(@NonNull View itemView) {
            super(itemView);
            card_view_zmstane_item = (CardView) itemView.findViewById(R.id.card_view_zmstane_item);
            img_mive_zmstane_item = (ImageView) itemView.findViewById(R.id.img_mive_zmstane_item);
            txtV_mive_zmstane_item_pro_name = (TextView) itemView.findViewById(R.id.txtV_mive_zmstane_item_pro_name);
            txtV_mive_zmstane_item_pro_price = (TextView) itemView.findViewById(R.id.txtV_mive_zmstane_item_pro_price);
        }
    }
}