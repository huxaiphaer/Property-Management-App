package com.information;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import book.property.ReserveProperty;
import huzy.jdhau.jomayi.huzykamz.drawer.BuyLandOne;
import huzy.jdhau.jomayi.huzykamz.drawer.ModelClass;
import huzy.jdhau.jomayi.huzykamz.drawer.LandAdapter;
import huzy.jdhau.jomayi.huzykamz.drawer.R;

/**
 * Created by HUZY_KAMZ on 2/17/2016.
 */
public class BuyLandInformation extends AppCompatActivity {


    String property_code="";
    String District ="";
    String Area="";
    String Acres ="";
    String Price ="";
    LandAdapter adapter;
    String Information="";
    TextView pcode;
    private List<ModelClass> modelClassList;
    public static String KEY_PCODE="pcode";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_land_info);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Land Information");

        Intent inn = getIntent();
        if (null != inn) {

            District = inn.getStringExtra(BuyLandOne.KEY_DISTRICT_NAME);
            Area = inn.getStringExtra(BuyLandOne.KEY_AREA);
            Acres = inn.getStringExtra(BuyLandOne.KEY_ACRES);
            Price = inn.getStringExtra(BuyLandOne.KEY_PRICES);
            Information = inn.getStringExtra(BuyLandOne.KEY_INFORMATION);

            // Attach
             pcode = (TextView) findViewById(R.id.property_code_info);
            pcode.setText(property_code);

            TextView dist = (TextView) findViewById(R.id.district_info);
            dist.setText(District);

            TextView are = (TextView) findViewById(R.id.area_info);
            are.setText(Area);

            TextView Ac = (TextView) findViewById(R.id.acres_info);
            Ac.setText(Acres);

            TextView pri = (TextView) findViewById(R.id.price_info);
            pri.setText(Price);

            TextView info = (TextView) findViewById(R.id.information_property);
            info.setText(Information);
        }




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

    public void Book(View v)
    {
        ModelClass jhild  =  new ModelClass();
        Intent i = new Intent(BuyLandInformation.this, ReserveProperty.class);
        i.putExtra(KEY_PCODE,property_code);

        startActivity(i);
    }
}
