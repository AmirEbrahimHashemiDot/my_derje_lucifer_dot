package com.example.test.botom_nav_test.Adapter;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;

import com.example.test.botom_nav_test.MainMenuActivitys.ListAlayeqActivity;
import com.example.test.botom_nav_test.Model.BasketProModel;
import com.example.test.botom_nav_test.Model.FavProModel;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshBasket;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class BasketProAdapter extends ArrayAdapter {

    public int resourceID;
    public Activity activity;
    public ArrayList<BasketProModel> data;
    public static int removeBasketItemPosition;
    public static AlertDialog.Builder removeOrNotDialog;

    public BasketProAdapter(Activity activity, int resourceID, ArrayList<BasketProModel> object) {
        super(activity, resourceID, object);

        this.resourceID = resourceID;
        this.activity = activity;
        this.data = object;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        view = this.activity.getLayoutInflater().inflate(this.resourceID, null);
        removeBasketItemPosition = position;
        CardView custom_basket_item_layout_card = (CardView) view.findViewById(R.id.custom_basket_item_layout_card);
        ImageView imgview_custom_basket_item_layout = (ImageView) view.findViewById(R.id.imgview_custom_basket_item_layout);
        TextView txtview_custom_basket_item_layout_proid = (TextView) view.findViewById(R.id.txtview_custom_basket_item_layout_proid);
        TextView txtview_custom_basket_item_layout_proname = (TextView) view.findViewById(R.id.txtview_custom_basket_item_layout_proname);
        TextView txtview_custom_basket_item_layout_proprice = (TextView) view.findViewById(R.id.txtview_custom_basket_item_layout_proprice);
        Button btn_remove_from_basket = (Button) view.findViewById(R.id.btn_remove_from_basket);

        BasketProModel basketProModel = data.get(position);
        //Picasso.with(getContext()).load(basketProModel.proImage).fit().centerInside().into(imgview_custom_basket_item_layout);
        Picasso.get().load(basketProModel.proImage).fit().centerInside().into(imgview_custom_basket_item_layout);
        String proIdToShow = Integer.toString(basketProModel.proID);
        String proSupToShow = basketProModel.supplier;
        txtview_custom_basket_item_layout_proid.setText(proSupToShow);
        txtview_custom_basket_item_layout_proname.setText(basketProModel.proName);


        String priceToShow = Integer.toString(basketProModel.proPrice);
        txtview_custom_basket_item_layout_proprice.setText(priceToShow);
        custom_basket_item_layout_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "position: " + position, Toast.LENGTH_SHORT).show();
            }
        });
        btn_remove_from_basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeOrNotDialog = new AlertDialog.Builder(getContext())
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
                        Toast.makeText(getContext(), "بله | حذف", Toast.LENGTH_SHORT).show();
                        SefareshBasket.removeBasketItemByPosition(position);

                        dialog.cancel();
                        dialog.dismiss();
                    }
                }).setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "خیر | بازگشت", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                        dialog.dismiss();
                    }
                });
                removeOrNotDialog.show();
            }
        });
        return view;
    }

}