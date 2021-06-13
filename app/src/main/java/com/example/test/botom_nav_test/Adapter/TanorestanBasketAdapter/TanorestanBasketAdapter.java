package com.example.test.botom_nav_test.Adapter.TanorestanBasketAdapter;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.botom_nav_test.Baskets.TanorestanBasket.TanorestanBasket;
import com.example.test.botom_nav_test.Model.KaridMive.BahareModel.BahareProItem_model;
import com.example.test.botom_nav_test.Model.TanorestanBasketModel.TanorestanBasketModel;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshBasket;
import com.example.test.botom_nav_test.ValueHolder.Common;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class TanorestanBasketAdapter extends RecyclerView.Adapter<TanorestanBasketAdapter.TanorestanBasketViewHolder> {

    public static AlertDialog.Builder removeOrNotDialog;
    public Context mcontext;
    public static ArrayList<TanorestanBasketModel> mTanorestanBasketItemList;

    public TanorestanBasketAdapter(Context context, ArrayList<TanorestanBasketModel> tanorestanBasketItem) {
        mcontext = context;
        mTanorestanBasketItemList = tanorestanBasketItem;
    }

    public TanorestanBasketAdapter() {

    }

    public ArrayList<TanorestanBasketModel> getMyList() {
        return mTanorestanBasketItemList;
    }

    @NonNull
    @Override
    public TanorestanBasketAdapter.TanorestanBasketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.tanorestan_basket_item_layout, parent, false);
        return new TanorestanBasketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TanorestanBasketViewHolder holder, final int position) {
        final TanorestanBasketModel currentItem = mTanorestanBasketItemList.get(position);

        String name = currentItem.getName();
        String desc = currentItem.getSupplier();
        String price = currentItem.getPrice();
        final String count = currentItem.getCount();
        String image = currentItem.getImage();


        NumberFormat formatter = new DecimalFormat("#,###");
        String formattedPrice = formatter.format(Integer.parseInt(price));

        holder.txt_tanor_basket_name.setText("نام محصول :\n" + name);
        holder.txt_tanor_basket_desc.setText("توضیحات :\n" + desc);
        holder.txt_tanor_basket_price.setText("قیمت :\n" + formattedPrice);
        holder.txt_tanor_basket_count.setText("تعداد :\n" + count);
        Picasso.get().load(image).fit().centerInside().into(holder.img_tanor_basket_image);

        holder.btn_remove_from_tanor_basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("dialog__", "dialog in true");
                removeOrNotDialog = new AlertDialog.Builder((mcontext))
                        /*
                        .setTitle("Remove Favorite")
                        .setMessage("Are You Sure?")
                        * */ //English
                        .setTitle("حذف از سبد خرید")
                        .setMessage("آیا مطمئن هستید؟")
                        .setIcon(android.R.drawable.ic_delete);
                removeOrNotDialog.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mcontext, "بله | حذف", Toast.LENGTH_SHORT).show();
                        //TanorestanBasket.tanorestanBasketModelArrayList.notifyAll();
                        //TanorestanBasket.refreshBasketCount();
                        //TanorestanBasket.refreshPriceCount(position);
                        Common.priceRemoveBehavior(Integer.parseInt(currentItem.getPrice()), Integer.parseInt(currentItem.getCount()));
                        TanorestanBasket.chekPriceVal();
                        TanorestanBasket.removeBasketItemByPosition(position);
                        dialog.cancel();
                        dialog.dismiss();
                    }
                }).setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mcontext, "خیر | بازگشت", Toast.LENGTH_SHORT).show();
                        //TanorestanBasket.refreshBasketCount();
                        dialog.cancel();
                        dialog.dismiss();
                    }
                });
                removeOrNotDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTanorestanBasketItemList.size();
    }

    public static class TanorestanBasketViewHolder extends RecyclerView.ViewHolder {

        public TextView txt_tanor_basket_name;
        public TextView txt_tanor_basket_desc;
        public TextView txt_tanor_basket_price;
        public TextView txt_tanor_basket_count;
        public ImageView img_tanor_basket_image;
        public Button btn_remove_from_tanor_basket;

        public TanorestanBasketViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_tanor_basket_name = (TextView) itemView.findViewById(R.id.txt_tanorestan_basket_name);
            txt_tanor_basket_desc = (TextView) itemView.findViewById(R.id.txt_tanorestan_basket_desc);
            txt_tanor_basket_price = (TextView) itemView.findViewById(R.id.txt_tanorestan_basket_price);
            txt_tanor_basket_count = (TextView) itemView.findViewById(R.id.txt_tanorestan_basket_count);
            img_tanor_basket_image = (ImageView) itemView.findViewById(R.id.imgview_tan_basket_item_image);
            btn_remove_from_tanor_basket = (Button) itemView.findViewById(R.id.btn_remove_from_tanor_basket);
        }
    }
}
