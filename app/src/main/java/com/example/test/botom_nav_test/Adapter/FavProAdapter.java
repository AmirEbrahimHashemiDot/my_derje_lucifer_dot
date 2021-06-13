package com.example.test.botom_nav_test.Adapter;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.Html;
import android.util.Log;
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
import com.example.test.botom_nav_test.Model.FavProModel;
import com.example.test.botom_nav_test.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FavProAdapter extends ArrayAdapter {
    public int resourceID;
    public Activity activity;
    public ArrayList<FavProModel> data;

    public static AlertDialog.Builder removeOrNotDialog;

    public FavProAdapter(Activity activity, int resourceID, ArrayList<FavProModel> object) {
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

        CardView custom_fav_item_layout_card = (CardView) view.findViewById(R.id.custom_fav_item_layout_card);
        ImageView imgview_custom_fav_item_layout = (ImageView) view.findViewById(R.id.imgview_custom_fav_item_layout);
        TextView txtview_custom_fav_item_layout_proname = (TextView) view.findViewById(R.id.txtview_custom_fav_item_layout_proname);
        TextView txtview_custom_fav_item_layout_prosupliier = (TextView) view.findViewById(R.id.txtview_custom_fav_item_layout_prosupliier);
        Button btn_remove_from_fav = (Button) view.findViewById(R.id.btn_remove_from_fav);

        FavProModel favProModel = data.get(position);
        //Picasso.with(getContext()).load(favProModel.proImage).fit().centerInside().into(imgview_custom_fav_item_layout);
        Picasso.get().load(favProModel.proImage).fit().centerInside().into(imgview_custom_fav_item_layout);
        //viewMore...
        String productName = favProModel.txt_pro_id_fav;

        /*if (productName.length()>10) {
            productName=productName.substring(0,10)+"...";
            txtview_custom_fav_item_layout_proname.setText(productName*//*Html.fromHtml(productName+"<font color='red'> <u>View More</u></font>")*//*);
        }*/

        txtview_custom_fav_item_layout_proname.setText(productName);
        txtview_custom_fav_item_layout_prosupliier.setText(favProModel.txt_pro_name_fav);
        custom_fav_item_layout_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "position: " + position, Toast.LENGTH_SHORT).show();
            }
        });
        btn_remove_from_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeOrNotDialog = new AlertDialog.Builder(getContext())
                        /*
                        .setTitle("Remove Favorite")
                        .setMessage("Are You Sure?")
                        * */ //English
                        .setTitle("حذف از علایق")
                        .setMessage("آیا مطمئن هستید؟")
                        .setIcon(android.R.drawable.ic_delete);
                removeOrNotDialog.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "بله | حذف", Toast.LENGTH_SHORT).show();

                        ListAlayeqActivity.removeItemByPosition(position);

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
