package com.example.test.botom_nav_test.Adapter.KaridMiveAdapter.KaridBahareRevAdapter;

import android.content.Context;
import android.content.Intent;
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

import com.example.test.botom_nav_test.Adapter.ExampleAdapter_Ryv;
import com.example.test.botom_nav_test.Model.KaridMive.BahareModel.BahareProItem_model;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshProDetail;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class KaridBahareRevAdapter extends RecyclerView.Adapter<KaridBahareRevAdapter.KaridBahareViewHolder> {

    String proPrice_S;
    private Context mcontext;
    private ArrayList<BahareProItem_model> mBahareProItemList;

    public KaridBahareRevAdapter(Context context, ArrayList<BahareProItem_model> Bahareproitem) {
        mcontext = context;
        mBahareProItemList = Bahareproitem;
    }

    @NonNull
    @Override
    public KaridBahareViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.bahare_item_layout, parent, false);
        return new KaridBahareViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KaridBahareViewHolder holder, int position) {
        final BahareProItem_model currentItem = mBahareProItemList.get(position);

        String imageUrl = currentItem.getImage();
        String proName = currentItem.getName();
        int proPrice = currentItem.getPrice();

        int $id = currentItem.get$id();
        int ID = currentItem.getID();
        String Supplier = currentItem.getSupplier();
        String Description = currentItem.getDescription();


        //convert price(double) to price(string)
        proPrice_S = String.valueOf(proPrice);

        holder.txtV_mive_bahare_item_pro_name.setText(proName);
        holder.txtV_mive_bahare_item_pro_price.setText(proPrice_S);
        //Picasso.with(mcontext).load(imageUrl).fit().centerInside().into(holder.img_mive_bahare_item);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.img_mive_bahare_item);

        //OnClickListener

        holder.card_view_bahare_item.setOnClickListener(new View.OnClickListener() {
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
        return mBahareProItemList.size();
    }

    public /*static*/ class KaridBahareViewHolder extends RecyclerView.ViewHolder {

        public CardView card_view_bahare_item;
        public ImageView img_mive_bahare_item;
        public TextView txtV_mive_bahare_item_pro_name;
        public TextView txtV_mive_bahare_item_pro_price;

        public KaridBahareViewHolder(@NonNull View itemView) {
            super(itemView);
            card_view_bahare_item = (CardView) itemView.findViewById(R.id.card_view_bahare_item);
            img_mive_bahare_item = (ImageView) itemView.findViewById(R.id.img_mive_bahare_item);
            txtV_mive_bahare_item_pro_name = (TextView) itemView.findViewById(R.id.txtV_mive_bahare_item_pro_name);
            txtV_mive_bahare_item_pro_price = (TextView) itemView.findViewById(R.id.txtV_mive_bahare_item_pro_price);
        }
    }
}