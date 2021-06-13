package com.example.test.botom_nav_test.TestingAPI;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


public class SoranApi {

    public String url = "http://172.20.10.2/api/Person/LogIn?userName=1&password=1";

    public class AsyncExample extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        protected void onResume() {
            // TODO Auto-generated method stub
            super.onResume();

            new AsyncCaller().execute();

        }

        public class AsyncCaller extends AsyncTask<Void, Void, Void> {
            ProgressDialog pdLoading = new ProgressDialog(AsyncExample.this);

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                //this method will be running on UI thread
                pdLoading.setMessage("\tLoading...");
                pdLoading.show();
            }

            @Override
            protected Void doInBackground(Void... params) {
                //this method will be running on background thread so don't update UI frome here
                //do your long running http tasks here,you dont want to pass argument and u can access the parent class' variable url over here
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                super.onPostExecute(result);

                //this method will be running on UI thread

                pdLoading.dismiss();
            }
        }
    }
}