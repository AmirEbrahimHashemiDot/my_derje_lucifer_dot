package com.example.test.botom_nav_test.ui.home;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.test.botom_nav_test.Adapter.ExampleAdapter_Ryv;
import com.example.test.botom_nav_test.Adapter.MainHomeRevAdapter.MainHomeRevAdapter;
import com.example.test.botom_nav_test.GardeshGariSubActivity.GardeshGariListLocActivity;
import com.example.test.botom_nav_test.LoginSigninActivitys.AdminLoginActivity;
import com.example.test.botom_nav_test.MainActivity;
import com.example.test.botom_nav_test.MainMenuActivitys.AmzshQazaMahaliActivity;
import com.example.test.botom_nav_test.MainMenuActivitys.CartvisitActivity;
import com.example.test.botom_nav_test.MainMenuActivitys.HiperMarketActivity;
import com.example.test.botom_nav_test.MainMenuActivitys.JashnvareActivity;
import com.example.test.botom_nav_test.MainMenuActivitys.KaridMiveActivity;
import com.example.test.botom_nav_test.MainMenuActivitys.KaridMiveTazeActivity_newUI;
import com.example.test.botom_nav_test.MainMenuActivitys.KdmtKshvrziActivity;
import com.example.test.botom_nav_test.MainMenuActivitys.KhorNewsActivity;
import com.example.test.botom_nav_test.MainMenuActivitys.MahsolatDehkadeActivity;
import com.example.test.botom_nav_test.MainMenuActivitys.TabiatActivity;
import com.example.test.botom_nav_test.MainMenuActivitys.TelefonZaroryActivity;
import com.example.test.botom_nav_test.Model.ExampleItem_model;
import com.example.test.botom_nav_test.Model.MainHomeModel.MainHomeModel;
import com.example.test.botom_nav_test.R;
import com.example.test.botom_nav_test.MainMenuActivitys.ShoraDehyariActivity;
import com.example.test.botom_nav_test.SettingsSubActivitys.TamasDerjeActivity;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class HomeFragment extends Fragment implements MainHomeRevAdapter.OnClickHomeListener {

    private static final int REQUEST_CALL = 1;

    /*public LinearLayout btn_agahi_ha, btn_riz_kharidha,
            btn_sefaresh, btn_shora_va_dehyari, btn_list_alayeq,
            btn_ertebat_ba_derje, btn_admin_login, btn_berim_khor, btn_maharatha,
            btn_settings, btn_amaliat_pardakt, btn_havashenasi, ertebat_ba_derje_home, btn_radiabi,
            btn_kadamat_keshavarzi, btn_tabiat_rosta, btn_cart_visit, btn_telefon_zarory, btn_khor_news,
            btn_kadamat_amozesh_qaza_mahali, btn_mahsolat_dehkade;*/

    //public String header_logo_url = "http://derje.ir//Image/android_app/home_web_logo/new2_derje_logo_home.png";
    public String header_logo_url = "http://171.22.27.135//Image/android_app/home_web_logo/new2_derje_logo_home.png";
    //public String header_logo_url = "https://cdn.vox-cdn.com/thumbor/p01ezbiuDHgRFQ-htBCd7QxaYxo=/0x105:2012x1237/1600x900/cdn.vox-cdn.com/uploads/chorus_image/image/47070706/google2.0.0.jpg";
    //public String header_logo_url = "http://derje.ir//Image/android_app/home_web_logo/new2_derje_logo_home.png";

    public ImageView img_main_logo_viewer;
    public Context context;
    public List<MainHomeModel> homeModelList;
    public RecyclerView main_home_recyclerview;
    public MainHomeRevAdapter homeRevAdapter;
    public Button side_menu_phone_call_to_derje,
            side_menu_load_site, side_menu_mahsolat_dehkade, side_menu_gardesh_gari;
    public String derje_phone_num = "00982166490341";
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        img_main_logo_viewer = (ImageView) root.findViewById(R.id.img_main_logo_viewer);
        //get logo from server
        /*try {
            getDerjeLogo();
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("logo_tag",e.getMessage().toString());
        }*/
        //set animation for main derje logo
        /*try {
            YoYo.with(Techniques.Hinge)*//*Tada*//*
                    .duration(1000)
                    .repeat(5)
                    .playOn(root.findViewById(R.id.img_main_logo_viewer));
        } catch (Exception anim_e) {
            anim_e.printStackTrace();
            Log.i("anim_error", anim_e.getMessage().toString());
        }*/

        //load home button list.
        homeModelList = new ArrayList<>();
        homeModelList.add(new MainHomeModel("خرید میوه تازه", R.drawable.mive_taze));
        homeModelList.add(new MainHomeModel("جشنواره", R.drawable.jashn_vare));
        homeModelList.add(new MainHomeModel("محصولات دهکده", R.drawable.dehyari_icon));
        homeModelList.add(new MainHomeModel("شورا و دهیاری", R.drawable.shora_dehyari));
        homeModelList.add(new MainHomeModel("خور News", R.drawable.khor_news_icon));
        homeModelList.add(new MainHomeModel("طبیعت روستا", R.drawable.alayq));
        homeModelList.add(new MainHomeModel("بانک مشاغل", R.drawable.cart_be_cart));
        homeModelList.add(new MainHomeModel("تلفن های ضروری", R.drawable.ertebat));
        homeModelList.add(new MainHomeModel("خدمات روستایی", R.drawable.kadamat_keshavarzi));
        homeModelList.add(new MainHomeModel("آموزش غذا های محلی", R.drawable.qaza_mahali_icon));
        homeModelList.add(new MainHomeModel("پنل کاربری", R.drawable.account_icon));

        main_home_recyclerview = (RecyclerView) root.findViewById(R.id.main_home_recyclerview);
        homeRevAdapter = new MainHomeRevAdapter(getActivity(), homeModelList, this);
        main_home_recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        main_home_recyclerview.setAdapter(homeRevAdapter);

        //set main menu logo animation


        //define side menu buttons
        side_menu_phone_call_to_derje = (Button) root.findViewById(R.id.side_menu_phone_call_to_derje);
        side_menu_load_site = (Button) root.findViewById(R.id.side_menu_load_site);
        side_menu_mahsolat_dehkade = (Button) root.findViewById(R.id.side_menu_mahsolat_dehkade);
        side_menu_gardesh_gari = (Button) root.findViewById(R.id.side_menu_gardesh_gari);


        //site menu buttons event
        side_menu_phone_call_to_derje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    if (ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

                    } else {
                        String s = "tel:" + derje_phone_num;
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse(s));
                        startActivity(intent);
                    }

                } catch (Exception phone_error) {
                    phone_error.printStackTrace();
                    Log.i("pho_e_tag", phone_error.getMessage().toString());
                    Toast.makeText(getActivity(), "Error in place Call :(", Toast.LENGTH_SHORT).show();
                }
            }
        });

        side_menu_load_site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //intent.setData(Uri.parse("http://171.22.27.135/"));
                intent.setData(Uri.parse("http://www.derje.ir/"));
                startActivity(intent);

            }
        });

        side_menu_mahsolat_dehkade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MahsolatDehkadeActivity.class);
                startActivity(intent);
            }
        });

        side_menu_gardesh_gari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GardeshGariListLocActivity.class);
                startActivity(intent);
            }
        });


        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        //****************************************************************************

        /*btn_admin_login = (LinearLayout) root.findViewById(R.id.btn_admin_login);
        btn_admin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "login", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), AdminLoginActivity.class);
                startActivity(intent);
            }
        });*/  //hast

        //*****************************************************************************

        /*btn_link_to_site = (ImageView) root.findViewById(R.id.btn_link_to_site);
        btn_link_to_site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //intent.setData(Uri.parse("http://171.22.27.135/"));
                //intent.setData(Uri.parse("https://www.google.com/maps/place/35%C2%B054'49.1%22N+51%C2%B009'32.0%22E/@35.913646,51.158898,17z/data=!3m1!4b1!4m5!3m4!1s0x0:0x0!8m2!3d35.913646!4d51.158898"));
                intent.setData(Uri.parse("http://www.derje.ir/"));
                startActivity(intent);
            }
        });*/ //hast

        /*btn_agahi_ha = (LinearLayout) root.findViewById(R.id.btn_agahi_ha);
        btn_agahi_ha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AgahiActivity.class);
                startActivity(intent);
            }
        });*/

        /*btn_riz_kharidha = (LinearLayout) root.findViewById(R.id.btn_riz_kharidha);
        btn_riz_kharidha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RizkharidActivity.class);
                startActivity(intent);
            }
        });*/

        /*btn_sefaresh = (LinearLayout) root.findViewById(R.id.btn_sefaresh);
        btn_sefaresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getActivity(), KaridMiveActivity.class);
                Intent intent = new Intent(getActivity(), KaridMiveTazeActivity_newUI.class);
                startActivity(intent);
                //Toast.makeText(getActivity(), "به زودی :)", Toast.LENGTH_SHORT).show();
            }
        });*/ //hast

        /*btn_shora_va_dehyari = (LinearLayout) root.findViewById(R.id.btn_shora_va_dehyari);
        btn_shora_va_dehyari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShoraDehyariActivity.class);
                startActivity(intent);
            }
        });
        btn_shora_va_dehyari.setEnabled(true);*/ //hast

        /*btn_list_alayeq = (LinearLayout) root.findViewById(R.id.btn_list_alayeq);
        btn_list_alayeq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListAlayeqActivity.class);
                startActivity(intent);
            }
        });*/

        /*btn_berim_khor = (LinearLayout) root.findViewById(R.id.btn_berim_khor);
        btn_berim_khor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//*Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //intent.addCategory(Intent.CATEGORY_APP_MAPS);
                intent.setData(Uri.parse("https://www.google.com/maps/place/35%C2%B054'49.1%22N+51%C2%B009'32.0%22E/@35.913646,51.158898,17z/data=!3m1!4b1!4m5!3m4!1s0x0:0x0!8m2!3d35.913646!4d51.158898"));
                startActivity(intent);*//*

                Intent intent = new Intent(getActivity(), GardeshGariListLocActivity.class);
                startActivity(intent);
            }
        });*/ //hast

        /*btn_maharatha = (LinearLayout) root.findViewById(R.id.btn_maharatha);
        btn_maharatha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MaharatActivity.class);
                startActivity(intent);
            }
        });*/

        /*btn_settings = (LinearLayout) root.findViewById(R.id.btn_settings);
        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
            }
        });*/

        /*btn_amaliat_pardakt = (LinearLayout) root.findViewById(R.id.btn_amaliat_pardakt);
        btn_amaliat_pardakt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AmaliatPardaktActivity.class);
                startActivity(intent);
            }
        });*/

        /*btn_havashenasi = (LinearLayout) root.findViewById(R.id.btn_havashenasi);
        btn_havashenasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HavashenasiActivity.class);
                startActivity(intent);
            }
        });*/

        /*ertebat_ba_derje_home = (LinearLayout) root.findViewById(R.id.ertebat_ba_derje_home);
        ertebat_ba_derje_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TamasDerjeActivity.class);
                startActivity(intent);
            }
        });

        btn_tabiat_rosta = (LinearLayout) root.findViewById(R.id.btn_tabiat_rosta);
        btn_tabiat_rosta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TabiatActivity.class);
                startActivity(intent);
            }
        });

        *//*btn_radiabi = (LinearLayout) root.findViewById(R.id.btn_radiabi);
        btn_radiabi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HiperMarketActivity.class);
                startActivity(intent);
            }
        });*//*

        btn_kadamat_keshavarzi = (LinearLayout) root.findViewById(R.id.btn_kadamat_keshavarzi);
        btn_kadamat_keshavarzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), KdmtKshvrziActivity.class);
                startActivity(intent);
            }
        });

        btn_cart_visit = (LinearLayout) root.findViewById(R.id.btn_cart_visit);
        btn_cart_visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CartvisitActivity.class);
                startActivity(intent);
            }
        });

        btn_telefon_zarory = (LinearLayout) root.findViewById(R.id.btn_telefon_zarory);
        btn_telefon_zarory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TelefonZaroryActivity.class);
                startActivity(intent);
            }
        });

        btn_khor_news = (LinearLayout) root.findViewById(R.id.btn_khor_news);
        btn_khor_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), KhorNewsActivity.class);
                startActivity(intent);
            }
        });

        btn_kadamat_amozesh_qaza_mahali = (LinearLayout) root.findViewById(R.id.btn_kadamat_amozesh_qaza_mahali);
        btn_kadamat_amozesh_qaza_mahali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AmzshQazaMahaliActivity.class);
                startActivity(intent);
            }
        });

        btn_mahsolat_dehkade = (LinearLayout) root.findViewById(R.id.btn_mahsolat_dehkade);
        btn_mahsolat_dehkade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MahsolatDehkadeActivity.class);
                startActivity(intent);
            }
        });*/ //hast

        return root;
    }

    private void getDerjeLogo() {
        try {
            Toast.makeText(getActivity(), "start loading logo", Toast.LENGTH_SHORT).show();
            Picasso.get().load(header_logo_url).fit().centerInside().into(img_main_logo_viewer);
                    /*if (mExampleList.size() != 0) {
                        dialog_load.cancel();
                        dialog_load.dismiss();
                    } else {
                        Log.i("cant_load", "cant_load");
                    }*/
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //makePhoneCall();

                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

                } else {
                    String s = "tel:" + derje_phone_num;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    startActivity(intent);
                }

            } else {
                Toast.makeText(getActivity(), "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onHomeClick(int position) {
        Log.d(TAG, "onHomeClick: clicked." + position);
        //Toast.makeText(getActivity(), "Position : " + position, Toast.LENGTH_SHORT).show();

        /*
        * switch (position) {
            case 0:
                Intent intent_0 = new Intent(getActivity(), KaridMiveTazeActivity_newUI.class);
                startActivity(intent_0);
                //Toast.makeText(getActivity(), "خرید میوه تازه", Toast.LENGTH_SHORT).show();
                break;

            case 1:
                Intent intent_1 = new Intent(getActivity(), JashnvareActivity.class);
                startActivity(intent_1);
                //Toast.makeText(getActivity(), "جشنواره", Toast.LENGTH_SHORT).show();
                break;

            case 2:
                Intent intent_2 = new Intent(getActivity(), ShoraDehyariActivity.class);
                startActivity(intent_2);
                //Toast.makeText(getActivity(), "شورا و دهیاری", Toast.LENGTH_SHORT).show();
                break;

            case 3:
                Intent intent_3 = new Intent(getActivity(), KhorNewsActivity.class);
                startActivity(intent_3);
                //Toast.makeText(getActivity(), "خور News", Toast.LENGTH_SHORT).show();
                break;

            case 4:
                Intent intent_4 = new Intent(getActivity(), TabiatActivity.class);
                startActivity(intent_4);
                //Toast.makeText(getActivity(), "طبیعت روستا", Toast.LENGTH_SHORT).show();
                break;

            case 5:
                Intent intent_5 = new Intent(getActivity(), CartvisitActivity.class);
                startActivity(intent_5);
                //Toast.makeText(getActivity(), "بانک مشاغل", Toast.LENGTH_SHORT).show();
                break;

            case 6:
                Intent intent_6 = new Intent(getActivity(), TelefonZaroryActivity.class);
                startActivity(intent_6);
                //Toast.makeText(getActivity(), "تلفن های ضروری", Toast.LENGTH_SHORT).show();
                break;

            case 7:
                Intent intent_7 = new Intent(getActivity(), KdmtKshvrziActivity.class);
                startActivity(intent_7);
                //Toast.makeText(getActivity(), "خدمات روستایی", Toast.LENGTH_SHORT).show();
                break;

            case 8:
                Intent intent_8 = new Intent(getActivity(), AmzshQazaMahaliActivity.class);
                startActivity(intent_8);
                //Toast.makeText(getActivity(), "آموزش غذاهای محلی", Toast.LENGTH_SHORT).show();
                break;

            case 9:
                Intent intent_9 = new Intent(getActivity(), AdminLoginActivity.class);
                startActivity(intent_9);
                //Toast.makeText(getActivity(), "پنل کاربری", Toast.LENGTH_SHORT).show();
                break;
        }
        * */

        switch (position) {
            case 0:
                Intent intent_0 = new Intent(getActivity(), KaridMiveTazeActivity_newUI.class);
                startActivity(intent_0);
                //Toast.makeText(getActivity(), "خرید میوه تازه", Toast.LENGTH_SHORT).show();
                break;

            case 1:
                Intent intent_1 = new Intent(getActivity(), JashnvareActivity.class);
                startActivity(intent_1);
                //Toast.makeText(getActivity(), "جشنواره", Toast.LENGTH_SHORT).show();
                break;

            case 2:
                Intent intent_2 = new Intent(getActivity(), MahsolatDehkadeActivity.class);
                startActivity(intent_2);
                //Toast.makeText(getActivity(), "شورا و دهیاری", Toast.LENGTH_SHORT).show();
                break;

            case 3:
                Intent intent_3 = new Intent(getActivity(), ShoraDehyariActivity.class);
                startActivity(intent_3);
                //Toast.makeText(getActivity(), "خور News", Toast.LENGTH_SHORT).show();
                break;

            case 4:
                Intent intent_4 = new Intent(getActivity(), KhorNewsActivity.class);
                startActivity(intent_4);
                //Toast.makeText(getActivity(), "طبیعت روستا", Toast.LENGTH_SHORT).show();
                break;

            case 5:
                Intent intent_5 = new Intent(getActivity(), TabiatActivity.class);
                startActivity(intent_5);
                //Toast.makeText(getActivity(), "بانک مشاغل", Toast.LENGTH_SHORT).show();
                break;

            case 6:
                Intent intent_6 = new Intent(getActivity(), CartvisitActivity.class);
                startActivity(intent_6);
                //Toast.makeText(getActivity(), "تلفن های ضروری", Toast.LENGTH_SHORT).show();
                break;

            case 7:
                Intent intent_7 = new Intent(getActivity(), TelefonZaroryActivity.class);
                startActivity(intent_7);
                //Toast.makeText(getActivity(), "خدمات روستایی", Toast.LENGTH_SHORT).show();
                break;

            case 8:
                Intent intent_8 = new Intent(getActivity(), KdmtKshvrziActivity.class);
                startActivity(intent_8);
                //Toast.makeText(getActivity(), "آموزش غذاهای محلی", Toast.LENGTH_SHORT).show();
                break;

            case 9:
                Intent intent_9 = new Intent(getActivity(), AmzshQazaMahaliActivity.class);
                startActivity(intent_9);
                //Toast.makeText(getActivity(), "پنل کاربری", Toast.LENGTH_SHORT).show();
                break;

            case 10:
                Intent intent_10 = new Intent(getActivity(), AdminLoginActivity.class);
                startActivity(intent_10);
                //Toast.makeText(getActivity(), "پنل کاربری", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}