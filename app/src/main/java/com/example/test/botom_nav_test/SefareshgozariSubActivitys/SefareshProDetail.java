package com.example.test.botom_nav_test.SefareshgozariSubActivitys;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.botom_nav_test.Adapter.ExampleAdapter_Ryv;
import com.example.test.botom_nav_test.MainMenuActivitys.KaridMiveActivity;
import com.example.test.botom_nav_test.Model.BasketProModel;
import com.example.test.botom_nav_test.Model.ExampleItem_ProModel;
import com.example.test.botom_nav_test.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshBasket.basketArrayList;

public class SefareshProDetail extends AppCompatActivity {

    public static int proID;
    public static boolean state;
    //public static ArrayList<FavProModel> favArrayList = new ArrayList<FavProModel>();
    public int id;
    public String proName, proDesc;
    public String supplier;
    public int int_proPrice;
    public String proImage;
    public ExampleItem_ProModel exampleModel_pro = new ExampleItem_ProModel();
    Context mContext;

    TextView txt_sefaresh_pro_detail_pro_name, txt_sefaresh_pro_detail_pro_desc;
    TextView txt_sefaresh_pro_detail_suplier;
    TextView txt_sefaresh_pro_detail_id;
    TextView txt_sefaresh_pro_detail_proId;
    TextView txt_sefaresh_pro_detail_pro_price;
    ImageView img_sefaresh_pro_detail_img_pro, btn_add_to_favorites;
    Button btn_go_back_to_sefareshgozary;
    ImageView btn_add_pro_itemto_sefaresh_basket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sefaresh_pro_detail);
        setUpViewsEvents();
        getProListIntent();
        checkFav();
        likeState();

        //*** add Fav info to public Model(get and set) for listView use
        /*SendFavDataToPublicModel sendFavDataToPublicModel = new SendFavDataToPublicModel();
        sendFavDataToPublicModel.setProID(proID);
        sendFavDataToPublicModel.setId_(id);
        sendFavDataToPublicModel.setProName(proName);
        sendFavDataToPublicModel.setSupplier(supplier);*/
        //***

    }

    private static void checkFav() {
        Integer toCheckValue = proID;
        for (Integer element : KaridMiveActivity.all_selected_faverit) {
            if (element.equals(toCheckValue)) {
                state = true;
                return;
                //break;
            } else {
                state = false;
                return;
            }
        }
    }

    private void likeState() {
        if (state)
            btn_add_to_favorites.setImageResource(R.drawable.ic_favorite_black_24dp);
    }

    private void getProListIntent() {
        //proID = Objects.requireNonNull(getIntent().getExtras()).getInt("proId");
        proID = getIntent().getExtras().getInt("proId");
        id = getIntent().getExtras().getInt("id");
        proName = getIntent().getExtras().getString("productName");
        proDesc = getIntent().getExtras().getString("ProductDescription");
        supplier = getIntent().getExtras().getString("supplier");
        int_proPrice = getIntent().getExtras().getInt("proPrice");
        proImage = getIntent().getExtras().getString("proImage");

        //Logs
        String proID_ = Integer.toString(proID);
        Log.i("proID_", proID_);
        Log.i("id_check", String.valueOf(id));
        Log.i("name_check", proName);
        Log.i("desk_check", proDesc);
        Log.i("sup_check", supplier);
        Log.i("price_check", String.valueOf(int_proPrice));
        Log.i("img_check", proImage);



        //Convert Price
        //String proPrice = Integer.toString(int_proPrice);

        //format price
        NumberFormat formatter = new DecimalFormat("#,###");
        String formattedNumber = formatter.format(int_proPrice);

        /*String string_id = Integer.toString(id);
        String string_proID = Integer.toString(proID);  */ //int to string id & ID
        txt_sefaresh_pro_detail_pro_name.setText(proName);
        txt_sefaresh_pro_detail_pro_desc.setText(proDesc);
        txt_sefaresh_pro_detail_suplier.setText(supplier);
        txt_sefaresh_pro_detail_pro_price.setText(formattedNumber+" تومان");

        //Picasso.with(mContext).load(proImage).fit().centerInside().into(img_sefaresh_pro_detail_img_pro);
        Picasso.get().load(proImage).fit().centerInside().into(img_sefaresh_pro_detail_img_pro);

        /*txt_sefaresh_pro_detail_id.setText(string_id);
        txt_sefaresh_pro_detail_proId.setText(string_proID);*/ //SetText id & ID
    }

    private void setUpViewsEvents() {
        /*txt_sefaresh_pro_detail_id = (TextView) findViewById(R.id.txt_sefaresh_pro_detail_id);
        txt_sefaresh_pro_detail_proId = (TextView) findViewById(R.id.txt_sefaresh_pro_detail_proId);*/ //TextView id & ID
        txt_sefaresh_pro_detail_pro_name = (TextView) findViewById(R.id.txt_sefaresh_pro_detail_pro_name);
        txt_sefaresh_pro_detail_pro_desc = (TextView) findViewById(R.id.txt_sefaresh_pro_detail_pro_desc);
        txt_sefaresh_pro_detail_suplier = (TextView) findViewById(R.id.txt_sefaresh_pro_detail_suplier);
        img_sefaresh_pro_detail_img_pro = (ImageView) findViewById(R.id.img_sefaresh_pro_detail_img_pro);
        btn_go_back_to_sefareshgozary = (Button) findViewById(R.id.btn_go_back_to_sefareshgozary);
        btn_add_to_favorites = (ImageView) findViewById(R.id.btn_add_to_favorites);
        txt_sefaresh_pro_detail_pro_price = (TextView)findViewById(R.id.txt_sefaresh_pro_detail_pro_price);

        /*btn_add_to_favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkFav();
                if (state) {
                    Toast.makeText(SefareshProDetail.this, "قبلا به علایق اضافه شده بود", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SefareshProDetail.this, "به علاقه مندی ها افزوده شد", Toast.LENGTH_SHORT).show();
                    KaridMiveActivity.addFavID(proID);
                    KaridMiveActivity.showFavID(proID);
                    btn_add_to_favorites.setImageResource(R.drawable.ic_favorite_black_24dp);

                    Intent favIntent = new Intent(SefareshProDetail.this, ListAlayeqActivity.class);
                    favIntent.putExtra("proID", proID);
                    favIntent.putExtra("id", id);
                    favIntent.putExtra("proName", proName);
                    favIntent.putExtra("supplier", supplier);
                    favIntent.putExtra("proPrice", int_proPrice);
                    favIntent.putExtra("proImage", proImage);

                    startActivity(favIntent);
                    finish();
                }


            }
        });*/
        /*checkFav();
                if (state) {
                    Toast.makeText(SefareshProDetail.this, "از علاقه مندی ها حذف شد", Toast.LENGTH_SHORT).show();
                    ListAlayeqActivity.removeFavID(proID);
                    ListAlayeqActivity.showFavID(proID);
                    btn_add_to_favorites.setImageResource(R.drawable.ic_favorite_border_black_24dp_unlike);
                    Intent intent = new Intent(SefareshProDetail.this, ListAlayeqActivity.class);
                    startActivity(intent);
                    finish();
                } else if (!state) {
                    Toast.makeText(SefareshProDetail.this, "به علاقه مندی ها افزوده شد", Toast.LENGTH_SHORT).show();
                    ListAlayeqActivity.addFavID(proID);
                    ListAlayeqActivity.showFavID(proID);
                    btn_add_to_favorites.setImageResource(R.drawable.ic_favorite_black_24dp);
                    Intent intent = new Intent(SefareshProDetail.this, ListAlayeqActivity.class);
                    startActivity(intent);
                    finish();
                } // کُدِ فَر
                checkFav();
                if (state) {
                    Toast.makeText(SefareshProDetail.this, "از علاقه مندی ها حذف شد", Toast.LENGTH_SHORT).show();
                    ListAlayeqActivity.removeFavID(proID);
                    ListAlayeqActivity.showFavID(proID);
                    btn_add_to_favorites.setImageResource(R.drawable.ic_favorite_border_black_24dp_unlike);
                    Intent intent = new Intent(SefareshProDetail.this, ListAlayeqActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SefareshProDetail.this, "به علاقه مندی ها افزوده شد", Toast.LENGTH_SHORT).show();
                    ListAlayeqActivity.addFavID(proID);
                    ListAlayeqActivity.showFavID(proID);
                    btn_add_to_favorites.setImageResource(R.drawable.ic_favorite_black_24dp);
                    Intent intent = new Intent(SefareshProDetail.this, ListAlayeqActivity.class);
                    startActivity(intent);
                    finish();
                }*/// کُدِ مَن

        btn_go_back_to_sefareshgozary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(SefareshProDetail.this, KaridMiveActivity.class);
                startActivity(intent);
                finish();*/ // Intent to Previous Activity
                onBackPressed();
            }
        });

        btn_add_pro_itemto_sefaresh_basket = (ImageView) findViewById(R.id.btn_add_pro_itemto_sefaresh_basket);
        btn_add_pro_itemto_sefaresh_basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SefareshProDetail.this, "به سبد افزوده شد", Toast.LENGTH_SHORT).show();
                ExampleAdapter_Ryv.addID(proID);

                /*String s_Id = Integer.toString(proID);
                try {
                    Log.i("id_in_array", s_Id);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i("dnt_snd_id_t_a", e.toString());
                }*/

                ExampleAdapter_Ryv.showID(proID);
                //>>>
                //basketArrayList.add(new BasketProModel(exampleModel_pro.get$id(), exampleModel_pro.getProID(), exampleModel_pro.getProductName(), exampleModel_pro.getSupplier(), exampleModel_pro.getImage(), exampleModel_pro.getPrice()));
                basketArrayList.add(new BasketProModel(id, proID, proName, supplier, proImage, int_proPrice));
                Intent intent = new Intent(SefareshProDetail.this, SefareshBasket.class);
                startActivity(intent);
                finish();
            }
        });
    }
    /*@Override
    public void onBackPressed() {
        switch (R.id.btn_go_back_to_sefareshgozary) {
            case R.id.btn_go_back_to_sefareshgozary:
                super.onBackPressed();
                //Toast.makeText(getApplicationContext(),"Back button clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return;
    }*/ //BackButton
}