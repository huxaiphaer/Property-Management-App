package buy.sell.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import huzy.jdhau.jomayi.huzykamz.drawer.R;
import rent.main.RentApartmentsOne;
import rent.main.RentApartmentsTwo;
import rent.main.RentHouseOne;
import rent.main.RentHouseTwo;


/**
 * Created by HUZY_KAMZ on 2/14/2016.
 */
public class RentMain extends AppCompatActivity {

    Spinner propertyTypee,range,roomsApartments ,roomsHouses;
    Button Search;
    TextView rangetxt,roomsApartments_txt, roomsHouse_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rentmain);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Rent property");

        propertyTypee = (Spinner) findViewById(R.id.spinner_list_property_rent);
        range = (Spinner) findViewById(R.id.spinner_list_acre_ranges_rent);
        roomsApartments =(Spinner) findViewById(R.id.spinner_rooms_apartments_rent);
        roomsHouses =(Spinner) findViewById(R.id.spinner_rooms_houses_rent);
        Search = (Button) findViewById(R.id.search_property_rent);
        rangetxt =(TextView) findViewById(R.id.no_of_ranges_txt_rent);
        roomsApartments_txt =(TextView) findViewById (R.id.no_of_apartments_txt_rent);
        roomsHouse_txt =(TextView) findViewById(R.id.no_of_rooms_house_txt_rent);


        String [] PropertyTypeList ={"Apartments","Houses"};

        String [] ApartmentsRoomsList ={"2 rooms","3 and more"};
        String [] HousesList ={"3 rooms","4 rooms and more"};


        ArrayAdapter<String> PropertyListAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,PropertyTypeList);
        propertyTypee.setAdapter(PropertyListAdapter);



        ArrayAdapter<String> roomsApartmentAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,ApartmentsRoomsList);
        roomsApartments.setAdapter(roomsApartmentAdapter);

        ArrayAdapter<String> roomsHousesAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,HousesList);
        roomsHouses.setAdapter(roomsHousesAdapter);



        propertyTypee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        roomsApartments.setEnabled(true);
                        roomsApartments_txt.setVisibility(View.VISIBLE);
                        roomsHouse_txt.setVisibility(View.INVISIBLE);
                        roomsHouses.setEnabled(false);
                        rangetxt.setVisibility(View.INVISIBLE);
                        range.setVisibility(View.INVISIBLE);

                        Search.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(RentMain.this, RentApartmentsOne.class);
                                startActivity(i);
                            }
                        });
                         roomsApartments.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                             @Override
                             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                 switch (position){
                                     case 0:

                                         Search.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 Intent i = new Intent(RentMain.this, RentApartmentsOne.class);
                                                 startActivity(i);
                                             }
                                         });
                                         break;
                                     case 1:

                                         Search.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 Intent i = new Intent(RentMain.this, RentApartmentsTwo.class);
                                                 startActivity(i);
                                             }
                                         });
                                         break;
                                 }
                             }

                             @Override
                             public void onNothingSelected(AdapterView<?> parent) {

                             }
                         });


                        break;

                    case 1:
                        roomsApartments_txt.setVisibility(View.INVISIBLE);
                        roomsApartments.setEnabled(false);
                        roomsHouse_txt.setVisibility(View.VISIBLE);
                        roomsHouses.setEnabled(true);
                        rangetxt.setVisibility(View.INVISIBLE);
                        range.setVisibility(View.INVISIBLE);
                        Search.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(RentMain.this, RentHouseOne.class);
                                startActivity(i);
                            }
                        });

                          roomsHouses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
          switch (position){
              case 0:
                  Search.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          Intent i = new Intent(RentMain.this, RentHouseOne.class);
                          startActivity(i);
                      }
                  });

                  break;
              case 1:

                  Search.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          Intent i = new Intent(RentMain.this, RentHouseTwo.class);
                          startActivity(i);
                      }
                  });
                  break;

          }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});
                        break;


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                Toast.makeText(RentMain.this, "Nothing is Selected", Toast.LENGTH_LONG).show();

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
}
