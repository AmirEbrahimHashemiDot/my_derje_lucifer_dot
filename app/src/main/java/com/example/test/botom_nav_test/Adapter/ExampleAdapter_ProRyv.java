package com.example.test.botom_nav_test.Adapter;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.test.botom_nav_test.Model.ExampleItem_ProModel;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshProDetail;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class ExampleAdapter_ProRyv extends RecyclerView.Adapter<ExampleAdapter_ProRyv.ExampleViewHolderPro> {

    //public Boolean is_selected = false;
    //public KaridMiveActivity sefareshGozariActivity;
    //private ExampleAdapter_ProRyv.onItemClickListenerPro mListenerPro;

    //public ArrayList<Integer> selected_pro_items;
    //public Stack<Integer> selected_pro_items__ = new Stack<>();
    //public ArrayList<Integer> all_selected_pro_items;
    public Integer public_position;
    private Context mContextPro;
    private ArrayList<ExampleItem_ProModel> mExampleList_pro;//آرایه ای که مدل RYV برمیگرداند در mExampleListpro نگهداری میشود
    private OnItemClickListenerPro mListener_pro;
    //public PublicSelectedProIDs selectedProIDs = new PublicSelectedProIDs();

    public ExampleAdapter_ProRyv(Context contextPro, ArrayList<ExampleItem_ProModel> exampleListpro) {
        mContextPro = contextPro;
        mExampleList_pro = exampleListpro;
    }

    public void setOnItemClickListenerPro(OnItemClickListenerPro listener_pro) {
        mListener_pro = listener_pro;
    }

    @NonNull
    @Override
    public ExampleAdapter_ProRyv.ExampleViewHolderPro onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vPro = LayoutInflater.from(mContextPro).inflate(R.layout.pro_ryv_item, parent, false);
        return new ExampleAdapter_ProRyv.ExampleViewHolderPro(vPro);
    }

    @Override
    public void onBindViewHolder(final ExampleAdapter_ProRyv.ExampleViewHolderPro holder_pro, final int position_pro) {
        final ExampleItem_ProModel currentItem = mExampleList_pro.get(position_pro);

        //selected_pro_items = new ArrayList<Integer>();
        //sefareshGozariActivity = new KaridMiveActivity();
        //all_selected_pro_items = new ArrayList<Integer>();
        public_position = position_pro;

        String Supplier = currentItem.getSupplier();
        String ProductName = currentItem.getProductName();
        String ProImage_url = currentItem.getImage();
        int int_ProPrice = currentItem.getPrice();
        String ProPrice = Integer.toString(int_ProPrice);

        //selected_pro_items = new ArrayList<>();
        //selected_pro_items__ = new Stack<>();
        //String Image = currentItem.getImage();
        /*if (Supplier.length()>20) {
            Supplier=Supplier.substring(0,20)+"...";
            holder_pro.txt_view_Supplier.setText(Supplier*//*Html.fromHtml(Supplier+"<font color='red'> <u>View More</u></font>")*//*);
        }*/

        holder_pro.txt_view_Supplier.setText(Supplier);
        holder_pro.txt_view_pro_name.setText(ProductName);

        NumberFormat formatter = new DecimalFormat("#,###");
        String formattedNumber = formatter.format(int_ProPrice);

        holder_pro.txt_view_pro_price.setText(formattedNumber+" تومان");

        //Picasso.with(mContextPro).load(ProImage_url).fit().centerInside().into(holder_pro.img_view_ryv_pro_item);
        Picasso.get().load(ProImage_url).fit().centerInside().into(holder_pro.img_view_ryv_pro_item);

        /*List<Integer> num = new ArrayList<>();
        for (String s : args) {
            int neki = Integer.parseInt(s);
            num.add(neki);
        }*/
        /*for (int i = 0; i < mExampleList_pro.size(); i++) {

            holder_pro.btn_add_pro_item_to_basket.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    holder_pro.btn_add_pro_item_to_basket.setImageResource(R.drawable.ic_add_shopping_cart_black_);
                    int pro_id;
                    pro_id = currentItem.getProID();
                    selected_pro_items.add(pro_id);

                    if (item_state == true) {
                        holder_pro.btn_add_pro_item_to_basket.setImageResource(R.drawable.ic_add_shopping_cart_black_24dp);
                        int pro_id_;
                        pro_id_ = currentItem.getProID();
                        selected_pro_items.remove(pro_id_);
                        item_state = false;
                    }
                }
            });
        }*/

        holder_pro.parent_pro_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int proID = currentItem.getProID();
                int id = currentItem.get$id();
                String productname = currentItem.getProductName();
                String proDESC = currentItem.getProDesc();
                String supplier = currentItem.getSupplier();
                int proPrice = currentItem.getPrice();
                String proImage = currentItem.getImage();

                Intent intent = new Intent(mContextPro, SefareshProDetail.class);
                intent.putExtra("proId", proID);
                intent.putExtra("id", id);
                intent.putExtra("productName", productname);
                intent.putExtra("ProductDescription", proDESC);
                intent.putExtra("supplier", supplier);
                intent.putExtra("proPrice", proPrice);
                intent.putExtra("proImage", proImage);
                mContextPro.startActivity(intent);
            }
        });
        /*holder_pro.ch_btn_add_pro_item_to_basket.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (holder_pro.ch_btn_add_pro_item_to_basket.isChecked()) {
                    holder_pro.img_view_ryv_pro_item.setImageResource(R.drawable.ic_shop_black_24dp);
                    ExampleAdapter_Ryv.addID(currentItem.getProID());
                    ExampleAdapter_Ryv.showID(currentItem.getProID());
                    KaridMiveActivity.getLastState_checkBox(true);

                } else if (!holder_pro.ch_btn_add_pro_item_to_basket.isChecked()) {
                    holder_pro.img_view_ryv_pro_item.setImageResource(R.drawable.ic_shop_off_black_24dp);
                    //Integer i = currentItem.getProID();
                    ExampleAdapter_Ryv.removeID(currentItem.getProID());
                    ExampleAdapter_Ryv.showID(currentItem.getProID());
                    KaridMiveActivity.getLastState_checkBox(false);

                }

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mExampleList_pro.size();
    }

    public interface OnItemClickListenerPro {
        void onItemClickPro(int position_pro);
    }

    /*public void setOnItemClickListenerPro(ExampleAdapter_ProRyv.onItemClickListenerPro listener) {
        mListenerPro = listener;
    }*/
    /*public interface onItemClickListenerPro {
        void onItemClickPro(int position);
    }*/

    public class ExampleViewHolderPro extends RecyclerView.ViewHolder {

        public RelativeLayout parent_pro_cardview;
        public TextView txt_view_Supplier;
        public TextView txt_view_pro_name;
        public ImageView img_view_ryv_pro_item;
        public TextView txt_view_pro_price;

        //public AppCompatCheckBox ch_btn_add_pro_item_to_basket;

        public ExampleViewHolderPro(View itemViewPro) {
            super(itemViewPro);
            img_view_ryv_pro_item = (ImageView) itemViewPro.findViewById(R.id.img_view_ryv_pro_item);
            parent_pro_cardview = (RelativeLayout) itemViewPro.findViewById(R.id.parent_pro_cardview);
            txt_view_Supplier = (TextView) itemViewPro.findViewById(R.id.txt_view_Supplier);
            txt_view_pro_name = (TextView) itemViewPro.findViewById(R.id.txt_view_pro_name);
            txt_view_pro_price = (TextView) itemViewPro.findViewById(R.id.txt_view_pro_price);
            //ch_btn_add_pro_item_to_basket = (AppCompatCheckBox) itemViewPro.findViewById(R.id.ch_btn_add_pro_item_to_basket);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener_pro != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener_pro.onItemClickPro(position);
                        }
                    }
                }
            });
            /*itemViewPro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListenerPro != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListenerPro.onItemClickPro(position);
                        }
                    }
                }
            });*/
        }
    }
}