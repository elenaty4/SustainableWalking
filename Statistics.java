package com.example.crdangelo.uc_hackathon_walking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.view.View;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



//Spinner Stuff

        Spinner dropdown = findViewById(R.id.StatSpinner);

        String[] items = new String[]{"None", "Dodge Ram 1500","Ford Expedition","Jeep Wrangler","Ford F-150","Toyota Sequoia",
                "GMC Envoy","BMW X5","Ford Escape","Mercedes-Benz S-Class","Lexus LS430","Honda Odyssey","Volvo V50",
                "Audi S4","Cadillac CTS","Pontiac Grand Prix","Mazda6 I","Honda CR-V","Subaru Outback","Chrysler Sebring",
                "Porsche Boxster","PT Cruiser","Ford Taurus","Nissan Altima","Honda Accord","Hyundai Elantra",
                "Mini Cooper","Toyota Corolla","Scion xA","Toyota Prius","Honda Insight"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);



        dropdown.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {


              TextView mpg = findViewById(R.id.mpg_changing);

              TextView gasPrice = findViewById(R.id.gasPrice_changing);


              String spinnerItem = parent.getItemAtPosition(pos).toString();


              if (spinnerItem.equalsIgnoreCase("None")){
                  mpg.setText("0");
                  gasPrice.setText("0");
              } else if (spinnerItem.equalsIgnoreCase("Dodge Ram 1500")){
                  mpg.setText("11");
                  gasPrice.setText(".27");
              } else if (spinnerItem.equalsIgnoreCase("Ford Expedition")){
                  mpg.setText("12");
                  gasPrice.setText(".25");
              } else if (spinnerItem.equalsIgnoreCase("Jeep Wrangler")){
                  mpg.setText("14");
                  gasPrice.setText(".21");
              } else if (spinnerItem.equalsIgnoreCase("Ford F-150")){
                  mpg.setText("14");
                  gasPrice.setText(".21");
              } else if (spinnerItem.equalsIgnoreCase("Toyota Sequoia")){
                  mpg.setText("15");
                  gasPrice.setText(".20");
              } else if (spinnerItem.equalsIgnoreCase("GMC Envoy")){
                  mpg.setText("15");
                  gasPrice.setText(".20");
              } else if (spinnerItem.equalsIgnoreCase("BMW X5")){
                  mpg.setText("17");
                  gasPrice.setText(".17");
              } else if (spinnerItem.equalsIgnoreCase("Ford Escape")){
                  mpg.setText("18");
                  gasPrice.setText(".16");
              } else if (spinnerItem.equalsIgnoreCase("Mercedes-Benz S-Class")){
                  mpg.setText("18");
                  gasPrice.setText(".16");
              } else if (spinnerItem.equalsIgnoreCase("Lexus LS430")){
                  mpg.setText("19");
                  gasPrice.setText(".16");
              } else if (spinnerItem.equalsIgnoreCase("Honda Odyssey")){
                  mpg.setText("19");
                  gasPrice.setText(".16");
              } else if (spinnerItem.equalsIgnoreCase("Volvo V50")){
                  mpg.setText("20");
                  gasPrice.setText(".15");
              } else if (spinnerItem.equalsIgnoreCase("Audi S4")){
                  mpg.setText("20");
                  gasPrice.setText(".15");
              } else if (spinnerItem.equalsIgnoreCase("Cadillac CTS")){
                  mpg.setText("20");
                  gasPrice.setText(".15");
              } else if (spinnerItem.equalsIgnoreCase("Pontiac Grand Prix")){
                  mpg.setText("20");
                  gasPrice.setText(".15");
              } else if (spinnerItem.equalsIgnoreCase("Mazda6 I")){
                  mpg.setText("20");
                  gasPrice.setText(".15");
              } else if (spinnerItem.equalsIgnoreCase("Honda CR-V")){
                  mpg.setText("21");
                  gasPrice.setText(".14");
              } else if (spinnerItem.equalsIgnoreCase("Subaru Outback")){
                  mpg.setText("21");
                  gasPrice.setText(".14");
              } else if (spinnerItem.equalsIgnoreCase("Chrysler Sebring")){
                  mpg.setText("21");
                  gasPrice.setText(".14");
              } else if (spinnerItem.equalsIgnoreCase("Porsche Boxster")){
                  mpg.setText("22");
                  gasPrice.setText(".13");
              } else if (spinnerItem.equalsIgnoreCase("PT Cruiser")){
                  mpg.setText("22");
                  gasPrice.setText(".13");
              } else if (spinnerItem.equalsIgnoreCase("Ford Taurus")){
                  mpg.setText("22");
                  gasPrice.setText(".13");
              } else if (spinnerItem.equalsIgnoreCase("Nissan Altima")){
                  mpg.setText("23");
                  gasPrice.setText(".13");
              } else if (spinnerItem.equalsIgnoreCase("Honda Accord")){
                  mpg.setText("24");
                  gasPrice.setText(".12");
              } else if (spinnerItem.equalsIgnoreCase("Hyundai Elantra")){
                  mpg.setText("24");
                  gasPrice.setText(".12");
              } else if (spinnerItem.equalsIgnoreCase("Mini Cooper")){
                  mpg.setText("25");
                  gasPrice.setText(".12");
              } else if (spinnerItem.equalsIgnoreCase("Toyota Corolla")){
                  mpg.setText("29");
                  gasPrice.setText(".10");
              } else if (spinnerItem.equalsIgnoreCase("Scion xA")){
                  mpg.setText("30");
                  gasPrice.setText(".10");
              } else if (spinnerItem.equalsIgnoreCase("Toyota Prius")){
                  mpg.setText("44");
                  gasPrice.setText(".07");
              } else if (spinnerItem.equalsIgnoreCase("Honda Insight")){
                  mpg.setText("44");
                  gasPrice.setText(".06");
              }


                // An item was selected. You can retrieve the selected item using
                // parent.getItemAtPosition(pos)
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback

            };

            });

    }

    public void continueOnClick(View v){

    }


}
