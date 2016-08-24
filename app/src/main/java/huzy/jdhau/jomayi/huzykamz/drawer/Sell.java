package huzy.jdhau.jomayi.huzykamz.drawer;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Address;
import android.net.Uri;
import android.net.http.RequestQueue;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;

/**
 * Created by HUZY_KAMZ on 1/26/2016.
 */
public class Sell extends AppCompatActivity {


    String SERVER_ADDRESS ="http://192.168.43.104/PropertyAgents/SavingImage/SavePicture.php";
    private static final String REGISTER_URL ="http://192.168.43.104/PropertyAgents/Sell/volleyRegister.php";
    public static final String KEY_NAME= "Name";
    public static final String KEY_EMAIL= "Email";
    public static final String KEY_PHONE= "Phone";
    public static final String KEY_ADDRESS= "Address";
    public static final String KEY_DESCRIPTION= "Description";
    public static final String KEY_PROPERTY_TYPE= "PropertyType";
    public static final String KEY_GENDER= "Gender";


    Spinner gender,propertyType;
    ImageView imageToUpload;

    EditText address, name, email,phone, description;
    private static final int RESULT_LOAD_IMAGE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell);



        getSupportActionBar().setDisplayShowHomeEnabled(true);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Sell Property");

        imageToUpload = (ImageView) findViewById(R.id.upload_image);
        address =(EditText) findViewById(R.id.address_sell);
        name = (EditText) findViewById(R.id.name_sell);
        email =(EditText) findViewById(R.id.email_sell);
        phone =(EditText) findViewById(R.id.phoneNumber_sell);
        description =(EditText) findViewById(R.id.description_sell);
        gender = (Spinner) findViewById(R.id.spinner_gender);
        propertyType = (Spinner) findViewById(R.id.spinner_propertyType);

        String Gender_Data [] ={"Female","Male"};
        String Property_Data [] ={"Apartments","Houses","Land"};


        ArrayAdapter<String> gender_Adap = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,Gender_Data);
        ArrayAdapter<String> property_Adap = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,Property_Data);
        gender.setAdapter(gender_Adap);
        propertyType.setAdapter(property_Adap);



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
        final String name_ = name.getText().toString().trim();
        final String email_ = email.getText().toString().trim();
        final String phone_ = phone.getText().toString().trim();
        final String address_ = address.getText().toString().trim();
        final String description_ = description.getText().toString().trim();
        final String gender_ = gender.getSelectedItem().toString();
        final String propertyType_ = propertyType.getSelectedItem().toString();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Toast.makeText(Sell.this,s,Toast.LENGTH_SHORT);
                Toast.makeText(Sell.this,"Saved...",Toast.LENGTH_SHORT);


            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(Sell.this, volleyError.toString(),Toast.LENGTH_LONG).show();

            }
        }){
     protected Map<String,String> getParams()
     {
         Map<String,String> params = new HashMap<String,String>();
         params.put(KEY_NAME,name_);
         params.put(KEY_ADDRESS,address_);
         params.put(KEY_EMAIL,email_);
         params.put(KEY_PHONE,phone_);
         params.put(KEY_DESCRIPTION,description_);
         params.put(KEY_GENDER,gender_);
         params.put(KEY_PROPERTY_TYPE,propertyType_);
         return params;


     }
        };


        Volley.newRequestQueue(this).add(stringRequest);



    }
    // uploading pictures and sending info

    public void SendInformation(View v) {




             registerUser();
        Upload();

        Snackbar.make(v, "Information Sent..", Snackbar.LENGTH_LONG)
                .setAction("Stuid", null).show();




    }

    public void Upload(){

try {

    String Add = email.getText().toString();
    Bitmap image = ((BitmapDrawable) imageToUpload.getDrawable()).getBitmap();
    new UploadImage(Add, image).execute();

}
catch (NullPointerException e){
    Toast.makeText(getApplicationContext(),"Please upolad the property picture",Toast.LENGTH_LONG).show();
}

    }

    public void OnUploadImage(View v) {
        Intent galleryintenet = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryintenet, RESULT_LOAD_IMAGE);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            imageToUpload.setImageURI(selectedImage);
        }
    }


    private class UploadImage extends AsyncTask<Void, Void, Void> {


        String name;
        Bitmap image;

        public UploadImage(String name, Bitmap image) {
            this.name = name;
            this.image = image;
        }

        @Override
        protected Void doInBackground(Void... params) {


            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            image.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            String encodedImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);

            ArrayList<NameValuePair> dataTosend = new ArrayList<>();
            dataTosend.add(new BasicNameValuePair("image", encodedImage));
            dataTosend.add(new BasicNameValuePair("name", name));
            HttpParams httpRequestparams = getHttpParams();
            HttpClient client = new DefaultHttpClient(httpRequestparams);
            HttpPost post = new HttpPost(SERVER_ADDRESS);
            try{

                post.setEntity(new UrlEncodedFormEntity(dataTosend));
                client.execute(post);

        }
            catch (Exception e){
               e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(),"Information uploaded",Toast.LENGTH_SHORT).show();
        }

        private HttpParams getHttpParams()
        {
            HttpParams httpRequestparams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestparams, 1000 * 30);
            HttpConnectionParams.setSoTimeout(httpRequestparams, 1000 * 30);

            return  httpRequestparams;

        }
    }
}









