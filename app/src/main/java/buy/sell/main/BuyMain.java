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

import huzy.jdhau.jomayi.huzykamz.drawer.BuyLandOne;
import huzy.jdhau.jomayi.huzykamz.drawer.BuyApartmentsOne;
import huzy.jdhau.jomayi.huzykamz.drawer.BuyApartmentsThree;
import huzy.jdhau.jomayi.huzykamz.drawer.BuyApartmentsTwo;
import huzy.jdhau.jomayi.huzykamz.drawer.BuyHouseOne;
import huzy.jdhau.jomayi.huzykamz.drawer.BuyHouseThree;
import huzy.jdhau.jomayi.huzykamz.drawer.BuyHouseTwo;
import huzy.jdhau.jomayi.huzykamz.drawer.BuyLandThree;
import huzy.jdhau.jomayi.huzykamz.drawer.BuyLandTwo;
import huzy.jdhau.jomayi.huzykamz.drawer.R;

/**
 * Created by HUZY_KAMZ on 2/14/2016.
 */
public class BuyMain extends AppCompatActivity {

    Spinner propertyType,range,roomsApartments ,roomsHouses;
    Button Search;
    TextView rangetxt,roomsApartments_txt, roomsHouse_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buymain);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("BuyLandOne Property");

        propertyType = (Spinner) findViewById(R.id.spinner_list_property);
        range = (Spinner) findViewById(R.id.spinner_list_acre_ranges);
        roomsApartments = (Spinner) findViewById(R.id.spinner_rooms_apartments);
        roomsHouses = (Spinner) findViewById(R.id.spinner_rooms_houses);
        Search = (Button) findViewById(R.id.search_property);
        rangetxt = (TextView) findViewById(R.id.no_of_ranges_txt);
        roomsApartments_txt = (TextView) findViewById(R.id.no_of_apartments_txt);
        roomsHouse_txt = (TextView) findViewById(R.id.no_of_rooms_house_txt);


        String[] PropertyTypeList = {"Land", "Apartments", "Houses"};
        String[] RangesList = {"0 -900m (squared)", "901m-1800m(squared) Land Size", "1801m (squared) & more"};
        String[] ApartmentsRoomsList = {"1 floors", "2 floors", "3 and more"};
        String[] HousesList = {"3 rooms", "4 rooms", "5 and more"};


        ArrayAdapter<String> PropertyListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, PropertyTypeList);
        propertyType.setAdapter(PropertyListAdapter);

        ArrayAdapter<String> rangeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, RangesList);
        range.setAdapter(rangeAdapter);

        ArrayAdapter<String> roomsApartmentAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ApartmentsRoomsList);
        roomsApartments.setAdapter(roomsApartmentAdapter);

        ArrayAdapter<String> roomsHousesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, HousesList);
        roomsHouses.setAdapter(roomsHousesAdapter);





        propertyType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        roomsApartments.setEnabled(false);
                        roomsHouses.setEnabled(false);
                        roomsApartments_txt.setVisibility(View.INVISIBLE);
                        roomsHouse_txt.setVisibility(View.INVISIBLE);
                        range.setEnabled(true);
                        rangetxt.setVisibility(View.VISIBLE);

                        Search.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(BuyMain.this, BuyLandOne.class);
                                startActivity(i);
                                Toast.makeText(BuyMain.this, "BuyLandOne property ranging 0-30 acres", Toast.LENGTH_LONG).show();
                            }
                        });


                        range.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position0, long id) {


/*
                                if(propertyType.getSelectedItem().equals("Land")&& position0==0)
                                {

                                    Search.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(BuyMain.this, BuyLandOne.class);
                                            startActivity(i);
                                            Toast.makeText(BuyMain.this, "BuyLandOne property ranging 0-30 acres", Toast.LENGTH_LONG).show();
                                        }
                                    });
                                }

                                else if (propertyType.getSelectedItem().equals("Land")&& position0==1){
                                    Search.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(BuyMain.this, BuyLandTwo.class);
                                            startActivity(i);
                                            Toast.makeText(BuyMain.this, "BuyLandOne property ranging 30-60 acres", Toast.LENGTH_LONG).show();


                                        }
                                    });

                                }

                                else if (propertyType.getSelectedItem().equals("Land")&& position0==2){
                                    Search.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(BuyMain.this, BuyLandThree.class);
                                            startActivity(i);
                                            Toast.makeText(BuyMain.this, "BuyLandOne property ranging 60-more acres", Toast.LENGTH_LONG).show();

                                        }
                                    });


                                }
*/

                              switch (position0){

                                  case 0:
                                      Search.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(BuyMain.this, BuyLandOne.class);
                                              startActivity(i);
                                              Toast.makeText(BuyMain.this, "BuyLandOne property ranging 0-30 acres", Toast.LENGTH_LONG).show();
                                          }
                                      });

                                      break;
                                  case 1:
                                      Search.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(BuyMain.this, BuyLandTwo.class);
                                              startActivity(i);
                                              Toast.makeText(BuyMain.this, "BuyLandOne property ranging 30-60 acres", Toast.LENGTH_LONG).show();


                                          }
                                      });
                                      break;

                                  case 2:
                                      Search.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(BuyMain.this, BuyLandThree.class);
                                              startActivity(i);
                                              Toast.makeText(BuyMain.this, "BuyLandOne property ranging 60-more acres", Toast.LENGTH_LONG).show();

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

                    case  1:
                        roomsApartments_txt.setVisibility(View.VISIBLE);
                        roomsApartments.setEnabled(true);
                        roomsHouse_txt.setVisibility(View.INVISIBLE);
                        roomsHouses.setEnabled(false);
                        range.setEnabled(false);
                        rangetxt.setVisibility(View.INVISIBLE);
                        Search.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(BuyMain.this, BuyApartmentsOne.class);
                                startActivity(i);
                                Toast.makeText(BuyMain.this, "Floor One", Toast.LENGTH_LONG).show();

                            }
                        });

                        roomsApartments.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position1, long id) {

/*
                                if (propertyType.getSelectedItem().equals("Apartments") && position1==0){
                                    Search.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(BuyMain.this, BuyApartmentsOne.class);
                                            startActivity(i);
                                            Toast.makeText(BuyMain.this, "BuyLandOne Apartments Floor One", Toast.LENGTH_LONG).show();

                                        }
                                    });



                                }

                                else if (propertyType.getSelectedItem().equals("Apartments") && position1==1){
                                    Search.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(BuyMain.this, BuyApartmentsTwo.class);
                                            startActivity(i);
                                            Toast.makeText(BuyMain.this, "BuyLandOne Apartments Floor two", Toast.LENGTH_LONG).show();


                                        }
                                    });

                                }

                                else if(propertyType.getSelectedItem().equals("Apartments") && position1==2){
                                    Search.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(BuyMain.this, BuyApartmentsThree.class);
                                            startActivity(i);
                                            Toast.makeText(BuyMain.this, "BuyLandOne Apartments Floor 3 and more", Toast.LENGTH_LONG).show();


                                        }
                                    });
                                }
                                */


                                switch (position1)
                                {
                                    case 0:
                                        Search.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent i = new Intent(BuyMain.this, BuyApartmentsOne.class);
                                                startActivity(i);
                                                Toast.makeText(BuyMain.this, "Floor One", Toast.LENGTH_LONG).show();

                                            }
                                        });

                                        break;
                                    case 1:
                                        Search.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent i = new Intent(BuyMain.this, BuyApartmentsTwo.class);
                                                startActivity(i);
                                                Toast.makeText(BuyMain.this, "Floor two", Toast.LENGTH_LONG).show();


                                            }
                                        });
                                        break;

                                    case 2:
                                        Search.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent i = new Intent(BuyMain.this, BuyApartmentsThree.class);
                                                startActivity(i);
                                                Toast.makeText(BuyMain.this, "Floor 3 and more", Toast.LENGTH_LONG).show();


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

                    case 2:


                        roomsHouse_txt.setVisibility(View.VISIBLE);
                        roomsHouses.setEnabled(true);
                        range.setEnabled(false);
                        rangetxt.setVisibility(View.INVISIBLE);
                        roomsApartments_txt.setVisibility(View.INVISIBLE);
                        roomsApartments.setEnabled(false);
                        Search.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(BuyMain.this, BuyHouseOne.class);
                                startActivity(i);
                                Toast.makeText(BuyMain.this, " 3 room", Toast.LENGTH_LONG).show();
                            }
                        });

                        roomsHouses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position2, long id) {
/*
                                if (propertyType.getSelectedItem().equals("Houses")&& position2==0)
                                {

                                    Search.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Toast.makeText(BuyMain.this, " 3 room", Toast.LENGTH_LONG).show();
                                        }
                                    });


                                }


                                else if (propertyType.getSelectedItem().equals("Houses") && position2==1)
                                {
                                    Search.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Toast.makeText(BuyMain.this, " 4 room", Toast.LENGTH_LONG).show();
                                        }
                                    });
                                }

                                else if(propertyType.getSelectedItem().equals("Houses") && position2==2){
                                    Search.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Toast.makeText(BuyMain.this, " 5 rooms and more", Toast.LENGTH_LONG).show();
                                        }
                                    });

                                }
                               */
                               switch (position2){

                                    case 0:
                                        Search.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent i = new Intent(BuyMain.this, BuyHouseOne.class);
                                                startActivity(i);
                                                Toast.makeText(BuyMain.this, " 3 room", Toast.LENGTH_LONG).show();
                                            }
                                        });

                                        break;
                                    case 1:
                                        Search.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent i = new Intent(BuyMain.this, BuyHouseTwo.class);
                                                startActivity(i);
                                                Toast.makeText(BuyMain.this, " 4 room", Toast.LENGTH_LONG).show();
                                            }
                                        });
                                        break;

                                    case 2:
                                        Search.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent i = new Intent(BuyMain.this, BuyHouseThree.class);
                                                startActivity(i);
                                                Toast.makeText(BuyMain.this, " 5 rooms and more", Toast.LENGTH_LONG).show();
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

                Toast.makeText(BuyMain.this,"Nothing is Selected",Toast.LENGTH_LONG).show();

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
