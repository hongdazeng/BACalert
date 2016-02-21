package com.hongdazeng.bacalert;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final double[] setWeight = {150};
        final BACcalc newCal = new BACcalc();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final TextView genderDisplay = (TextView) findViewById(R.id.textViewGender);
        final TextView weightDisplay = (TextView) findViewById(R.id.textViewWeight);
        final TextView BACdisplay = (TextView) findViewById(R.id.textViewBAC);
        final TextView BACwarn = (TextView) findViewById(R.id.textViewBACWarn);

        Button incWeight = (Button) findViewById(R.id.buttonIncreaseWeight);
        Button decWeight = (Button) findViewById(R.id.buttonDecreaseWeight);
        Button setMale = (Button) findViewById(R.id.buttonSetMale);
        Button setFemale = (Button) findViewById(R.id.buttonSetFemale);

        Button addBeer = (Button) findViewById(R.id.buttonAddBeer);
        Button addWine = (Button) findViewById(R.id.buttonAddWine);
        Button addLiquor = (Button) findViewById(R.id.buttonAddLiquor);

        Button resetButton = (Button) findViewById(R.id.buttonReset);
        final DecimalFormat formatter = new DecimalFormat("#0.000");


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Created by Hongda, Jack, and Ben at" +
                        " HackIllinois 2016", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        incWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWeight[0]++;
                newCal.setWeight((int) setWeight[0]);
                weightDisplay.setText("" + setWeight[0] + " pounds");
                String response = "" + formatter.format(newCal.getBAC());
                BACdisplay.setText(response);
            }
        });

        decWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWeight[0]--;
                newCal.setWeight((int) setWeight[0]);
                weightDisplay.setText("" + setWeight[0] + " pounds");
                String response = "" + formatter.format(newCal.getBAC());
                BACdisplay.setText(response);
            }
        });

        setMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newCal.setMale();
                genderDisplay.setText("Male");
                String response = "" + formatter.format(newCal.getBAC());
                BACdisplay.setText(response);
            }
        });

        setFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newCal.setFemale();
                genderDisplay.setText("Female");
                String response = "" + formatter.format(newCal.getBAC());
                BACdisplay.setText(response);
            }
        });

        setFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newCal.setFemale();
                genderDisplay.setText("Female");
                String response = "" + (int) newCal.getBAC();
                BACdisplay.setText(response);
            }
        });

        addBeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newCal.addDrinks();
                String response = "" + formatter.format(newCal.getBAC());
                if (newCal.getBAC() >= 0.01) {
                    BACwarn.setText("Your BAC is rising!");
                }
                if (newCal.getBAC() >= 0.04) {
                    BACwarn.setText("You should not drive.");
                }
                if (newCal.getBAC() >= 0.1) {
                    BACwarn.setText("You should get help.");
                }
                BACdisplay.setText(response);
            }
        });

        addLiquor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newCal.addDrinks();
                String response = "" + formatter.format(newCal.getBAC());
                if (newCal.getBAC() >= 0.01) {
                    BACwarn.setText("Your BAC is rising!");
                }
                if (newCal.getBAC() >= 0.04) {
                    BACwarn.setText("You should not drive.");
                }
                if (newCal.getBAC() >= 0.1) {
                    BACwarn.setText("You should get help.");
                }
                BACdisplay.setText(response);
            }
        });

        addWine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newCal.addDrinks();
                String response = "" + formatter.format(newCal.getBAC());
                if (newCal.getBAC() >= 0.01) {
                    BACwarn.setText("Your BAC is rising!");
                }
                if (newCal.getBAC() >= 0.04) {
                    BACwarn.setText("You should not drive.");
                }
                if (newCal.getBAC() >= 0.1) {
                    BACwarn.setText("You should get help.");
                }
                BACdisplay.setText(response);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
