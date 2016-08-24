package rent.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.information.BuyHouseInformation;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import adapters.RentHouseAdapters;
import huzy.jdhau.jomayi.huzykamz.drawer.ModelClass;
import huzy.jdhau.jomayi.huzykamz.drawer.HttpManager;
import huzy.jdhau.jomayi.huzykamz.drawer.R;
import parser.json.RentHouseJSON;

/**
 * Created by HUZY_KAMZ on 2/14/2016.
 */
public class RentHouseTwo extends AppCompatActivity {

    @SuppressWarnings("unused")
    private static final String PHOTOS_BASE_URL =
            "http://192.168.43.104/PropertyAgents/Rent/RentHouseTwoPics/";

    public static String KEY_BUYLAND_CODE="property_code";
    public static String KEY_DISTRICT_NAME="District";
    public static String KEY_AREA="Area";
    public static String KEY_FLOORS="floors";
    public static String KEY_PRICES="Price";
    public static String KEY_INFORMATION="Information";


    ProgressBar pb;
    List<MyTask> tasks;
    GridView lv;
    List<ModelClass> modelClassList;
    EditText Sch;
    RentHouseAdapters adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy);
        Infor();
        Sch = (EditText) findViewById(R.id.Search);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Rent  House ");
        pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.setVisibility(View.INVISIBLE);
        tasks = new ArrayList<>();
        Fetch();




    }

    public void Infor() {

        lv = (GridView) findViewById(R.id.list);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ModelClass jhild = (ModelClass) adapter.getItem(position);


                Intent in = new Intent(getApplicationContext(), BuyHouseInformation.class);
                in.putExtra(KEY_DISTRICT_NAME, jhild.getDistrict());
                in.putExtra(KEY_FLOORS, jhild.getRooms());
                in.putExtra(KEY_AREA, jhild.getArea());
                in.putExtra(KEY_BUYLAND_CODE, jhild.getRentno());
                in.putExtra(KEY_PRICES, jhild.getPrice());
                in.putExtra(KEY_INFORMATION, jhild.getInformation());

                startActivity(in);
            }
        });
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
                        requestData("http://192.168.43.104/PropertyAgents/Rent/RentHouseTwo/fecth.php");
                    } else {

                    }

                }catch(NullPointerException e){
                    e.printStackTrace();
                    Toast.makeText(RentHouseTwo.this, "Check your Connectivity....", Toast.LENGTH_LONG).show();
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
        adapter = new RentHouseAdapters(this, R.layout.item_house, modelClassList);
        lv = (GridView) findViewById(R.id.list);
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
                modelClassList = RentHouseJSON.parseFeed(content);

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
            catch (NullPointerException e){

                Toast.makeText(RentHouseTwo.this,"Theres a problem ",Toast.LENGTH_LONG).show();
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
                Toast.makeText(RentHouseTwo.this, "Data is  not available", Toast.LENGTH_LONG).show();
                return;
            }

            modelClassList = result;
            updateDisplay();

        }

    }

}