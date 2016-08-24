package book.property;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.information.BuyLandInformation;

import java.util.HashMap;
import java.util.Map;

import huzy.jdhau.jomayi.huzykamz.drawer.R;

/**
 * Created by HUZY_KAMZ on 2/21/2016.
 */
public class ReserveProperty extends AppCompatActivity {


    private static final String REGISTER_URL ="http://192.168.43.104/PropertyAgents/Reservation/volleyRegister.php";
    public static final String KEY_PCODE= "Pcode";
    public static final String KEY_NAME= "Name";
    public static final String KEY_PNUM= "Pnum";
    public static final String KEY_ADDRESS= "Address";
    public static final String KEY_AD= "ArrivalDate";

    EditText pcode, name, pnum,address, ad;
    String buycode="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Reserve Property");


        pcode =(EditText) findViewById(R.id.pcode);
        name =(EditText) findViewById(R.id.book_name);
        pnum =(EditText) findViewById(R.id.book_pnum);
        address =(EditText) findViewById(R.id.book_address);
        ad = (EditText) findViewById(R.id.book_date);

        Intent inn = getIntent();
        if (null != inn) {
            buycode = inn.getStringExtra(BuyLandInformation.KEY_PCODE);

            EditText i = (EditText) findViewById(R.id.pcode);
            i.setText(buycode);

        }



    }

    public void registerUser(){
        final String pcode_ = pcode.getText().toString().trim();
        final String name_ = name.getText().toString().trim();
        final String pnum_ = pnum.getText().toString().trim();
        final String address_ = address.getText().toString().trim();
        final String ad_ = ad.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Toast.makeText(ReserveProperty.this, s, Toast.LENGTH_SHORT);



            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(ReserveProperty.this, volleyError.toString(),Toast.LENGTH_LONG).show();

            }
        }){
            protected Map<String,String> getParams()
            {
                Map<String,String> params = new HashMap<String,String>();
                params.put(KEY_NAME,name_);
                params.put(KEY_PCODE,pcode_);
                params.put(KEY_PNUM,pnum_);
                params.put(KEY_ADDRESS,address_);
                params.put(KEY_AD,ad_);

                return params;


            }
        };


        Volley.newRequestQueue(this).add(stringRequest);



    }
    public void Suggest(View v){
        registerUser();
        Snackbar.make(v, "Suggestion Sent..", Snackbar.LENGTH_LONG)
                .setAction("Stuid", null).show();

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

    public void Send(View v)
    {
        Snackbar.make(v, "Information Sent..", Snackbar.LENGTH_LONG)
                .setAction("", null).show();
registerUser();
    }



}
