package com.example.test.botom_nav_test.Adapter.MahsolatDehkade.Tanorestan;

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

import com.example.test.botom_nav_test.Baskets.TanorestanBasket.TanorestanBasket;
import com.example.test.botom_nav_test.Baskets.TanorestanBasket.TanorestanProDetalesActivity;
import com.example.test.botom_nav_test.Model.MahsolatDehkade.GoshtTaze.GoshtTazeModel;
import com.example.test.botom_nav_test.Model.MahsolatDehkade.Tanorestan.TanorestanModel;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshProDetail;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class TanorestanRevAdapter extends RecyclerView.Adapter<TanorestanRevAdapter.TanorestanViewHolder> {

    String proPrice_S;
    private Context mcontext;
    private ArrayList<TanorestanModel> mTanorestanItemList;

    public TanorestanRevAdapter(Context context, ArrayList<TanorestanModel> Tanorestanitem) {
        mcontext = context;
        mTanorestanItemList = Tanorestanitem;
    }

    @NonNull
    @Override
    public TanorestanRevAdapter.TanorestanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.tanorestan_item_layout, parent, false);
        return new TanorestanRevAdapter.TanorestanViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull TanorestanRevAdapter.TanorestanViewHolder holder, int position) {
        final TanorestanModel currentItem = mTanorestanItemList.get(position);

        String imageUrl = currentItem.getImage();
        final String proName = currentItem.getName();
        int proPrice = currentItem.getPrice();

        int $id = currentItem.get$id();
        int ID = currentItem.getID();
        String Supplier = currentItem.getSupplier();
        String Description = currentItem.getDescription();


        //convert price(double) to price(string)
        proPrice_S = String.valueOf(proPrice);

        NumberFormat formatter = new DecimalFormat("#,###");
        String formattedPrice = formatter.format(proPrice);

        holder.txtV_tanorestan_item_pro_name.setText(proName);
        holder.txtV_tanorestan_item_pro_price.setText(formattedPrice + " تومان");
        //Picasso.with(mcontext).load(imageUrl).fit().centerInside().into(holder.img_mive_bahare_item);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.img_tanorestan_item);

        //OnClickListener

        holder.card_view_tanorestan_item.setOnClickListener(new View.OnClickListener() {
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

                Intent intent = new Intent(mcontext, TanorestanProDetalesActivity.class);

                intent.putExtra("proId", currentItem.getID());
                intent.putExtra("id", currentItem.get$id());
                intent.putExtra("productName", currentItem.getName());
                intent.putExtra("ProductDescription", currentItem.getDescription());
                intent.putExtra("supplier", currentItem.getSupplier());
                intent.putExtra("proPrice", currentItem.getPrice());
                intent.putExtra("proImage", currentItem.getImage());

                String s_ID = Integer.toString(currentItem.getID());
                Log.i("chk_id", s_ID);


                /*for (int i = 0; i <= TanorestanBasket.tanorestanBasketModelArrayList.size() -1; i++) {
                    Log.i("A_I_2", "Array item i om : " + TanorestanBasket.tanorestanBasketModelArrayList.get(i));
                }*/

                //Log.i("A_I_2", "Array item i om : " + TanorestanBasket.tanorestanBasketModelArrayList);

                mcontext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mTanorestanItemList.size();
    }

    public static class TanorestanViewHolder extends RecyclerView.ViewHolder {

        public CardView card_view_tanorestan_item;
        public ImageView img_tanorestan_item;
        public TextView txtV_tanorestan_item_pro_name;
        public TextView txtV_tanorestan_item_pro_price;

        public TanorestanViewHolder(@NonNull View itemView) {
            super(itemView);
            card_view_tanorestan_item = (CardView) itemView.findViewById(R.id.card_view_tanorestan_item);
            img_tanorestan_item = (ImageView) itemView.findViewById(R.id.img_tanorestan_item);
            txtV_tanorestan_item_pro_name = (TextView) itemView.findViewById(R.id.txtV_tanorestan_item_pro_name);
            txtV_tanorestan_item_pro_price = (TextView) itemView.findViewById(R.id.txtV_tanorestan_item_pro_price);
        }
    }
}
