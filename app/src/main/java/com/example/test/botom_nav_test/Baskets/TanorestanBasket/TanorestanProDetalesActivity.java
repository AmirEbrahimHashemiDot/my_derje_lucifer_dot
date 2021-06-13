package com.example.test.botom_nav_test.Baskets.TanorestanBasket;

import androidx.annotation.IntegerRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.botom_nav_test.Adapter.ExampleAdapter_Ryv;
import com.example.test.botom_nav_test.Adapter.TanorestanBasketAdapter.TanorestanBasketAdapter;
import com.example.test.botom_nav_test.MainMenuActivitys.KaridMiveActivity;
import com.example.test.botom_nav_test.Model.BasketProModel;
import com.example.test.botom_nav_test.Model.ExampleItem_ProModel;
import com.example.test.botom_nav_test.Model.TanorestanBasketModel.TanorestanBasketModel;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshBasket;
import com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshProDetail;
import com.example.test.botom_nav_test.ValueHolder.Common;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import static com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshBasket.basketArrayList;
import static com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshBasket.context;

import static com.example.test.botom_nav_test.SefareshgozariSubActivitys.SefareshBasket.basketArrayList;
//import com.example.test.botom_nav_test.Baskets.TanorestanBasket.TanorestanBasket.mTanorestanBasketItemList;

public class TanorestanProDetalesActivity extends AppCompatActivity {


    public static int proID;
    public static boolean state;
    public static TextView txt_goto_basket_title;
    public ScrollView scrl_view;
    //public static ArrayList<FavProModel> favArrayList = new ArrayList<FavProModel>();
    public int id;
    public String proName, proDesc;
    public String supplier;
    public int int_proPrice;
    public String public_string_proPrice;
    public String proImage;
    public ExampleItem_ProModel exampleModel_pro = new ExampleItem_ProModel();
    public EditText edt_tanorestan_product_count;
    public String product_count;
    public TanorestanBasketAdapter tanorestanBasketAdapter;
    public ArrayList<TanorestanBasketModel> mTanorestanBasketItemList;
    public TanorestanBasket basket;
    public TanorestanBasket tanorestanBasket = new TanorestanBasket();
    Context mContext;
    TextView txt_sefaresh_pro_detail_pro_name, txt_sefaresh_pro_detail_pro_desc;
    TextView txt_sefaresh_pro_detail_suplier;
    TextView txt_sefaresh_pro_detail_id;
    TextView txt_sefaresh_pro_detail_proId;
    TextView txt_sefaresh_pro_detail_pro_price;
    ImageView img_sefaresh_pro_detail_img_pro, btn_add_to_favorites;
    Button btn_go_back_to_sefareshgozary;
    ImageView btn_add_pro_itemto_sefaresh_basket;

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

    //@RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanorestan_pro_detales);
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setUpViewsEvents();
        }*/
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setUpViewsEvents();
        }*/
        setUpViewsEvents();
        //scrollToEnd();
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

    private void scrollToEnd() {
        /*scrl_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrl_view.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });*/
        scrl_view.fullScroll(ScrollView.FOCUS_DOWN);
    }

    /*@RequiresApi(api = Build.VERSION_CODES.M)
    private void scrollToEnd() {
        //scrl_view.fullScroll(ScrollView.FOCUS_DOWN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            scrl_view.scrollToDescendant(edt_tanorestan_product_count);
        }
    }*/

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
        public_string_proPrice = Integer.toString(int_proPrice);
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
        txt_sefaresh_pro_detail_pro_price.setText(formattedNumber + " تومان");
        //Picasso.with(mContext).load(proImage).fit().centerInside().into(img_sefaresh_pro_detail_img_pro);
        Picasso.get().load(proImage).fit().centerInside().into(img_sefaresh_pro_detail_img_pro);
        /*txt_sefaresh_pro_detail_id.setText(string_id);
        txt_sefaresh_pro_detail_proId.setText(string_proID);*/ //SetText id & ID
    }

    //@RequiresApi(api = Build.VERSION_CODES.O)
    public void setUpViewsEvents() {
        txt_goto_basket_title = (TextView) findViewById(R.id.txt_goto_basket_title);
        txt_goto_basket_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_count = edt_tanorestan_product_count.getText().toString();
                if (product_count.length() == 0) {
                    Toast.makeText(TanorestanProDetalesActivity.this, "تعداد را وارد کنید.", Toast.LENGTH_SHORT).show();
                } else {
                    TanorestanBasket.tanorestanBasketModelArrayList.add(
                            new TanorestanBasketModel(
                                    proName,
                                    proDesc,
                                    public_string_proPrice,
                                    product_count,
                                    proImage));

                    int tmp_int_price = Integer.parseInt(public_string_proPrice);
                    int tmp_int_product_count = Integer.parseInt(product_count);
                    Common.pricePlusByCountBehavior(tmp_int_price, tmp_int_product_count);

                    if (TanorestanBasket.tanorestanBasketModelArrayList != null) {
                        Toast.makeText(TanorestanProDetalesActivity.this, "به سبد افزوده شد", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(TanorestanProDetalesActivity.this, TanorestanBasket.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(TanorestanProDetalesActivity.this, "ارایه خالی است", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        scrl_view = (ScrollView) findViewById(R.id.scrl_view);
        //scrl_view.fullScroll(ScrollView.FOCUS_DOWN);
        //scrl_view.scrollTo(0, 400);
        basket = new TanorestanBasket();
        //mTanorestanBasketItemList = new ArrayList<TanorestanBasketModel>();
        tanorestanBasketAdapter = new TanorestanBasketAdapter();

        /*txt_sefaresh_pro_detail_id = (TextView) findViewById(R.id.txt_sefaresh_pro_detail_id);
        txt_sefaresh_pro_detail_proId = (TextView) findViewById(R.id.txt_sefaresh_pro_detail_proId);*/ //TextView id & ID
        edt_tanorestan_product_count = (EditText) findViewById(R.id.edt_tanorestan_product_count);
        txt_sefaresh_pro_detail_pro_name = (TextView) findViewById(R.id.txt_sefaresh_pro_detail_pro_name);
        txt_sefaresh_pro_detail_pro_desc = (TextView) findViewById(R.id.txt_sefaresh_pro_detail_pro_desc);
        txt_sefaresh_pro_detail_suplier = (TextView) findViewById(R.id.txt_sefaresh_pro_detail_suplier);
        img_sefaresh_pro_detail_img_pro = (ImageView) findViewById(R.id.img_sefaresh_pro_detail_img_pro);
        btn_go_back_to_sefareshgozary = (Button) findViewById(R.id.btn_go_back_to_sefareshgozary);
        btn_add_to_favorites = (ImageView) findViewById(R.id.btn_add_to_favorites);
        txt_sefaresh_pro_detail_pro_price = (TextView) findViewById(R.id.txt_sefaresh_pro_detail_pro_price);
        //edt_tanorestan_product_count.setFocusedByDefault(true);

        //final TanorestanBasket tb = new TanorestanBasket();
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

        /*edt_tanorestan_product_count.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    scrl_view.fullScroll(ScrollView.FOCUS_DOWN);
                }
            }
        });*/

        /*scrl_view.post(new Runnable() {
            @Override
            public void run() {
                scrl_view.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });*/

        btn_add_pro_itemto_sefaresh_basket = (ImageView) findViewById(R.id.btn_add_pro_itemto_sefaresh_basket);
        btn_add_pro_itemto_sefaresh_basket.setOnClickListener(new View.OnClickListener() {
            //@RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View v) {
                product_count = edt_tanorestan_product_count.getText().toString();
                if (product_count.length() == 0) {
                    Toast.makeText(TanorestanProDetalesActivity.this, "تعداد را وارد کنید.", Toast.LENGTH_SHORT).show();
                } else {
                    TanorestanBasket.tanorestanBasketModelArrayList.add(
                            new TanorestanBasketModel(
                                    proName,
                                    proDesc,
                                    public_string_proPrice,
                                    product_count,
                                    proImage));

                    int tmp_int_price = Integer.parseInt(public_string_proPrice);
                    int tmp_int_product_count = Integer.parseInt(product_count);

                    //TanorestanBasket.refPriceWhenAdd(public_string_proPrice);
                    //Common.pricePlusBehavior(tmp_int_price);
                    Common.pricePlusByCountBehavior(tmp_int_price, tmp_int_product_count);

                    if (TanorestanBasket.tanorestanBasketModelArrayList != null) {
                        Toast.makeText(TanorestanProDetalesActivity.this, "به سبد افزوده شد", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(TanorestanProDetalesActivity.this, TanorestanBasket.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(TanorestanProDetalesActivity.this, "ارایه خالی است", Toast.LENGTH_SHORT).show();
                    }
                    /*Intent intent = new Intent(TanorestanProDetalesActivity.this, TanorestanBasket.class);
                    intent.putExtra("pro_name", proName);
                    intent.putExtra("pro_desc", proDesc);
                    intent.putExtra("pro_price", public_string_proPrice);
                    intent.putExtra("pro_count", product_count);
                    intent.putExtra("pro_image", proImage);
                    startActivity(intent);
                    finish();*/
                }
                //tb.tanorestanBasketModelArrayList.add(new TanorestanBasketModel(proName, supplier, public_string_proPrice, product_count, proImage));
                //Toast.makeText(TanorestanProDetalesActivity.this, "به سبد افزوده شد", Toast.LENGTH_SHORT).show();
                /*TanorestanBasket tanorestanBasket = new TanorestanBasket();

                Log.i("name", proName);
                Log.i("desc", proDesc);
                Log.i("price", public_string_proPrice);
                Log.i("count", product_count);
                Log.i("image", proImage);*/
                //TanorestanBasket.getMyList().add(new TanorestanBasketModel(proName, proDesc, public_string_proPrice, product_count, proImage));
                /*ArrayList<TanorestanBasketModel> test = new ArrayList<TanorestanBasketModel>();
                test = TanorestanBasket.getMyList();
                Log.i("test_a",test.toString());
                String a = test.get(0).getCount();
                String b = test.get(0).getImage();
                String c = test.get(0).getName();
                String d = test.get(0).getPrice();
                String e = test.get(0).getSupplier();
                Log.i("a", a);
                Log.i("b", b);
                Log.i("c", c);
                Log.i("d", d);
                Log.i("e", e);*/
                /*if (TanorestanBasket.getMyList() != null) {
                    Toast.makeText(TanorestanProDetalesActivity.this, "به سبد افزوده شد", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TanorestanProDetalesActivity.this, "ارایه خالی است", Toast.LENGTH_SHORT).show();
                }*/
                //TanorestanBasket.tanorestanBasketModelArrayList.add(new TanorestanBasketModel(proName, proDesc, public_string_proPrice, product_count, proImage));
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