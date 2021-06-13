package com.example.test.botom_nav_test.MainMenuActivitys;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.test.botom_nav_test.Adapter.FavProAdapter;
import com.example.test.botom_nav_test.Model.FavProModel;
import com.example.test.botom_nav_test.R;

import java.util.ArrayList;

public class ListAlayeqActivity extends AppCompatActivity {
    /*public ArrayList<Integer> alaqe_List;
        public ArrayAdapter<Integer> alaqe_IDsAdapter;*/ //Old ListView

    public static boolean state;
    public static int proID, id;
    public static ListView list_alayeq;
    public static FavProModel favProModel;
    public static FavProAdapter favProAdapter;
    public static ArrayList<FavProModel> favArrayList = new ArrayList<FavProModel>();
    //public static AlertDialog.Builder removeOrNotDialog;
    public static Context context;
    public static int founedID;
    public String proName, supplier, proImage;
    int proPrice;
    int hash_id;
    Button btn_goto_homeactivity;
    ImageView imgview_custom_fav_item_layout;

    //public static Dialog removeOrNotDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_alayeq);
        setUpViewsEvents();

        try {
            getFavIntent();
            try {
                favArrayList.add(new FavProModel(proName, supplier, proID, proImage, proPrice));
                favProAdapter = new FavProAdapter(ListAlayeqActivity.this, R.layout.custom_fav_item_layout, favArrayList);
                list_alayeq.setAdapter(favProAdapter);
                favProAdapter.notifyDataSetChanged();
                Toast.makeText(context, "intent true", Toast.LENGTH_SHORT).show();
                Log.i("intent_state","intent true");
            } catch (Exception e) {
                Log.i("catch_error","error in second catch");
                e.printStackTrace();
            }
        } catch (Exception e) {
            Log.i("intent_state","intent false");
            e.printStackTrace();
        }

        favProAdapter = new FavProAdapter(ListAlayeqActivity.this, R.layout.custom_fav_item_layout, favArrayList);
        list_alayeq.setAdapter(favProAdapter);

        /*alaqe_List = new ArrayList<Integer>(ListAlayeqActivity.setSelectedArrayListFav());
        alaqe_IDsAdapter = new ArrayAdapter<Integer>(ListAlayeqActivity.this, android.R.layout.simple_list_item_1, alaqe_List);
        list_alayeq.setAdapter(alaqe_IDsAdapter);*/ // Old ListView


    }

    public static void removeItemByPosition(int pos) {
        //list_alayeq.removeViewAt(FavProAdapter.removeItemPosition);
        /*removeOrNotDialog = new AlertDialog.Builder(ListAlayeqActivity.this)
                .setTitle("Remove Favorite")
                .setMessage("are you sure?")
                .setIcon(android.R.drawable.ic_delete);
        removeOrNotDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Yes | remove", Toast.LENGTH_SHORT).show();
                favArrayList.remove(FavProAdapter.removeItemPosition);
                favProAdapter.notifyDataSetChanged();
                dialog.cancel();
                dialog.dismiss();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "No | keep", Toast.LENGTH_SHORT).show();
                dialog.cancel();
                dialog.dismiss();
            }
        });*/
        favArrayList.remove(pos);
        favProAdapter.notifyDataSetChanged();
    }

    /*private static void c () {
        boolean contains;

        for (int i = 0; i < favArrayList.size(); i++) {

            FavProModel favProModel = new FavProModel("", "", proID);
            favProModel.getFavproID();
            if (favArrayList.contains(favProModel)) {
                Log.i("voj","dasht");
            }

        }

    }*/
    /*public FavProModel findFavID() {
        for (int i = 0; i < favArrayList.size(); i++) {
            founedID = favProModel.getFavproID();
        }
        return FavProModel.favproID
    }*/
    /*private static void checkFavByID() {
        Integer toCheckValue = proID;
        for (Integer element : favArrayList.equals()) {
            if (element.equals(toCheckValue)) {
                state = true;
                return;
            } else {
                state = false;
                return;
            }
        }
    }*/

    private void getFavIntent() {
        proID = getIntent().getExtras().getInt("proID");
        id = getIntent().getExtras().getInt("id");
        proName = getIntent().getExtras().getString("proName");
        supplier = getIntent().getExtras().getString("supplier");
        proPrice = getIntent().getExtras().getInt("proPrice");
        proImage = getIntent().getExtras().getString("proImage");
    }

    private void setUpViewsEvents() {
        imgview_custom_fav_item_layout = (ImageView) findViewById(R.id.imgview_custom_fav_item_layout);
        btn_goto_homeactivity = (Button) findViewById(R.id.btn_goto_homeactivity);
        btn_goto_homeactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(ListAlayeqActivity.this, MainActivity.class);
                startActivity(intent);
                finish();*/
                onBackPressed();
            }
        });
        list_alayeq = (ListView) findViewById(R.id.list_alayeq);
    }
    /*public static boolean addFavID(Integer ID) {
        all_selected_faverit.add(ID);
        Log.i("selected_items_fav",all_selected_faverit.toString());
        return true;
    }
    public static boolean removeFavID (Integer ID) {
        all_selected_faverit.remove(ID);
        Log.i("selected_items_fav",all_selected_faverit.toString());
        return false;
    }
    public static boolean showFavID (Integer ID) {
        //Log.i("LOG_selected_items_fav",all_selected_faverit.toString());
        return true;
    }
    public static ArrayList<Integer> setSelectedArrayListFav () {
        Log.i("setSelectedArrayList",all_selected_faverit.toString());
        return all_selected_faverit;
    }*/
}
