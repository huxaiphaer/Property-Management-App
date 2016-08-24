package huzy.jdhau.jomayi.huzykamz.drawer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HUZY_KAMZ on 1/26/2016.
 */
public class Rent extends AppCompatActivity {
    @SuppressWarnings("unused")
    private static final String PHOTOS_BASE_URL =
            "http://10.0.2.2/huzy_images/";

    TextView output;
    ProgressBar pb;
    List<MyTask> tasks;

    List<ModelClass> modelClassList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Property for rent");
        pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.setVisibility(View.INVISIBLE);
        tasks = new ArrayList<>();
        Fetch();


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                break;


        }
        return super.onOptionsItemSelected(item);
    }
    public void Fetch(){

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    if (isOnline()) {
                        requestData("http://10.0.2.2/PropertyAgents/Rent/rent_fetch.php");
                    } else {

                    }

                }catch(NullPointerException e){
                    e.printStackTrace();
                    Toast.makeText(Rent.this, "Check your Connectivity....", Toast.LENGTH_LONG).show();
                }
            }
        };
        timerThread.start();
    }





    private void requestData(String uri) {
        MyTask task = new MyTask();
        task.execute(uri);
    }

    protected void updateDisplay() {
        //Use LandAdapter to display data
        LandAdapter adapter = new LandAdapter(this, R.layout.item_flower, modelClassList);
        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);
    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

    private class MyTask extends AsyncTask<String, String, List<ModelClass>> {

        @Override
        protected void onPreExecute() {
            if (tasks.size() == 0) {
                pb.setVisibility(View.VISIBLE);
            }
            tasks.add(this);
        }

        @Override
        protected List<ModelClass> doInBackground(String... params) {
            try {

                String content = HttpManager.getData(params[0], "feeduser", "feedpassword");
                modelClassList = LandJSONParser.parseFeed(content);

                for (ModelClass modelClass : modelClassList) {
                    try {
                        String imageUrl = PHOTOS_BASE_URL + modelClass.getPhoto();
                        InputStream in = (InputStream) new URL(imageUrl).getContent();
                        Bitmap bitmap = BitmapFactory.decodeStream(in);
                        modelClass.setBitmap(bitmap);
                        in.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }
            catch (NullPointerException e)

            {
                Toast.makeText(Rent.this, "Check your Connection...",Toast.LENGTH_LONG).show();
            }
            return modelClassList;
        }

        @Override
        protected void onPostExecute(List<ModelClass> result) {

            tasks.remove(this);
            if (tasks.size() == 0) {
                pb.setVisibility(View.INVISIBLE);
            }

            if (result == null) {
                Toast.makeText(Rent.this, "Data is  not available", Toast.LENGTH_LONG).show();
                return;
            }

            modelClassList = result;
            updateDisplay();

        }

    }

}
