package huzy.jdhau.jomayi.huzykamz.drawer;

import android.content.Intent;
import android.net.Uri;
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

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HUZY_KAMZ on 1/22/2016.
 */
public class Suggestions extends AppCompatActivity {

    EditText suggestion;
    private static final String REGISTER_URL ="http://192.168.43.104/PropertyAgents/Suggestions/volleyRegister.php";
    public static final String KEY_SUGGESTIONS= "Suggestions";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suggestions);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Suggestions");


        suggestion = (EditText) findViewById(R.id.suggestion);
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
    public void registerUser(){
        final String suggestions_ = suggestion.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Toast.makeText(Suggestions.this, s, Toast.LENGTH_SHORT);



            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(Suggestions.this, volleyError.toString(),Toast.LENGTH_LONG).show();

            }
        }){
            protected Map<String,String> getParams()
            {
                Map<String,String> params = new HashMap<String,String>();
                params.put(KEY_SUGGESTIONS,suggestions_);

                return params;


            }
        };


        Volley.newRequestQueue(this).add(stringRequest);



    }
    public void Suggest(View v){
        registerUser();
        Snackbar.make(v, "Suggestion Sent..", Snackbar.LENGTH_LONG)
                .setAction("", null).show();

    }
}
