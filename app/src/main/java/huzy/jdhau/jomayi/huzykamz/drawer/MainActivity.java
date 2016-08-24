package huzy.jdhau.jomayi.huzykamz.drawer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import buy.sell.main.BuyMain;
import buy.sell.main.RentMain;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Spinner propertyType,range,roomsApartments ,roomsHouses;
    Button Search;
    TextView rangetxt,roomsApartments_txt, roomsHouse_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_two);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




        //new


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
        String[] ApartmentsRoomsList = {"1 floor", "2 floors", "3 floors and more"};
        String[] HousesList = {"3 rooms", "4 rooms", "5 rooms and more"};


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
                                Intent i = new Intent(MainActivity.this, BuyLandOne.class);
                                startActivity(i);
                                Toast.makeText(MainActivity.this, "BuyLandOne property ranging 0-30 acres", Toast.LENGTH_LONG).show();
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
                                                Intent i = new Intent(MainActivity.this, BuyLandOne.class);
                                                startActivity(i);
                                                Toast.makeText(MainActivity.this, "BuyLandOne property ranging 0-30 acres", Toast.LENGTH_LONG).show();
                                            }
                                        });

                                        break;
                                    case 1:
                                        Search.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent i = new Intent(MainActivity.this, BuyLandTwo.class);
                                                startActivity(i);
                                                Toast.makeText(MainActivity.this, "BuyLandOne property ranging 30-60 land size", Toast.LENGTH_LONG).show();


                                            }
                                        });
                                        break;

                                    case 2:
                                        Search.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent i = new Intent(MainActivity.this, BuyLandThree.class);
                                                startActivity(i);
                                                Toast.makeText(MainActivity.this, "BuyLandOne property ranging 60-more land size", Toast.LENGTH_LONG).show();

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
                                Intent i = new Intent(MainActivity.this, BuyApartmentsOne.class);
                                startActivity(i);
                                Toast.makeText(MainActivity.this, "Floor One", Toast.LENGTH_LONG).show();

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
                                                Intent i = new Intent(MainActivity.this, BuyApartmentsOne.class);
                                                startActivity(i);
                                                Toast.makeText(MainActivity.this, "Floor One", Toast.LENGTH_LONG).show();

                                            }
                                        });

                                        break;
                                    case 1:
                                        Search.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent i = new Intent(MainActivity.this, BuyApartmentsTwo.class);
                                                startActivity(i);
                                                Toast.makeText(MainActivity.this, "Floor two", Toast.LENGTH_LONG).show();


                                            }
                                        });
                                        break;

                                    case 2:
                                        Search.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent i = new Intent(MainActivity.this, BuyApartmentsThree.class);
                                                startActivity(i);
                                                Toast.makeText(MainActivity.this, "Floor 3 and more", Toast.LENGTH_LONG).show();


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
                                Intent i = new Intent(MainActivity.this, BuyHouseOne.class);
                                startActivity(i);
                                Toast.makeText(MainActivity.this, " 3 room", Toast.LENGTH_LONG).show();
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
                                                Intent i = new Intent(MainActivity.this, BuyHouseOne.class);
                                                startActivity(i);
                                                Toast.makeText(MainActivity.this, " 3 room", Toast.LENGTH_LONG).show();
                                            }
                                        });

                                        break;
                                    case 1:
                                        Search.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent i = new Intent(MainActivity.this, BuyHouseTwo.class);
                                                startActivity(i);
                                                Toast.makeText(MainActivity.this, " 4 room", Toast.LENGTH_LONG).show();
                                            }
                                        });
                                        break;

                                    case 2:
                                        Search.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent i = new Intent(MainActivity.this, BuyHouseThree.class);
                                                startActivity(i);
                                                Toast.makeText(MainActivity.this, " 5 rooms and more", Toast.LENGTH_LONG).show();
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

                Toast.makeText(MainActivity.this,"Nothing is Selected",Toast.LENGTH_LONG).show();

            }
        });









        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent i;

        if (id == R.id.buy_nav) {
            // Handle the camera action
            i = new Intent(MainActivity.this,BuyMain.class);
            startActivity(i);
        } else if (id == R.id.sell_nav) {
            i = new Intent(MainActivity.this,Sell.class);
            startActivity(i);

        } else if (id == R.id.rent_nav) {
            i = new Intent(MainActivity.this, RentMain.class);
            startActivity(i);

        }  else if (id == R.id.contact_us_nav) {
            i = new Intent(MainActivity.this, ContactUs.class);
            startActivity(i);

        } else if (id == R.id.settings_nav) {
            i = new Intent(MainActivity.this,Settings.class);
            startActivity(i);

        }else if (id == R.id.suggestions_nav) {
            i = new Intent(MainActivity.this,Suggestions.class);
            startActivity(i);

        }
        /*
        else if (id == R.id.share_nav) {


        }

        else if (id == R.id.rate_app_nav) {
Share();
        }

*/
        else if (id == R.id.about_nav) {
            i = new Intent(MainActivity.this,About.class);
            startActivity(i);

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void Share() {
        try {
            Intent intent = new Intent("https://play.google.com/store/apps/details?id=halal.example.huzy_kamz.halalproject&hl=en.Ughalal App");
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
            startActivityForResult(intent, 0);    //Barcode Scanner to scan for us
        } catch (ActivityNotFoundException anfe) {

            showDialog(MainActivity.this, "Rate Me", "If this app is useful to you, would you mind taking a moment to rate it? It won\'t take more than a minute. Thanks for your support ", "Yes", "No").show();
        }

    }

    private static AlertDialog showDialog(final Activity act, CharSequence title, CharSequence message, CharSequence buttonYes, CharSequence buttonNo) {
        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);
        downloadDialog.setTitle(title);
        downloadDialog.setMessage(message);
        downloadDialog.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Uri uri = Uri.parse("market://search?q=pname:" + "halal.example.huzy_kamz.halalproject");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    act.startActivity(intent);
                } catch (ActivityNotFoundException anfe) {

                }
            }
        });
        downloadDialog.setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return downloadDialog.show();


    }

}
