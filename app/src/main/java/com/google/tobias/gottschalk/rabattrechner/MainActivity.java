package com.google.tobias.gottschalk.rabattrechner;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerlist, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);



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

    public void onClick(View v){

        RabattRechner rabattRechner = new RabattRechner();

        Context context = getApplicationContext();
        CharSequence text = "Bitte nur 2 von 3 Feldern ausfüllen";


        EditText grundwertEditText = (EditText)findViewById(R.id.txt_grundwert);
        EditText prozentsatzEditText = (EditText)findViewById(R.id.txt_prozet);
        EditText prozentwertEditText = (EditText)findViewById(R.id.txt_ergebnis);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

       // double grundwert = Double.parseDouble(grundwertEditText.getText().toString());
        double grundwert;
        double prozentsatz;
       // double prozentwert = Double.parseDouble(prozentwertEditText.getText().toString());
        Double temp;

        switch(v.getId()){

            case R.id.btn_ok: /** Start a new Activity MyCards.java */
                if(grundwertEditText.length()>0 && prozentsatzEditText.length()>0 && prozentwertEditText.length()>0){
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                if(grundwertEditText.length()>0 && prozentsatzEditText.length()>0 && prozentwertEditText.length()==0){



                   // grundwert = Double.parseDouble(grundwertEditText.getText().toString());

                    temp = rabattRechner.berechneProzentwert(Double.parseDouble(
                            grundwertEditText.getText().toString()),
                            Double.parseDouble(prozentsatzEditText.getText().toString()));


                    prozentwertEditText.setText(temp.toString());

                }




                break;

            case R.id.btn_exit: /** AlerDialog when click on Exit */
                System.exit(0);
                break;

            case R.id.btn_clear:
                if(grundwertEditText.getText().length()!=0){
                    grundwertEditText.getText().clear();
                }

                if(prozentsatzEditText.getText().length()!=0){
                    prozentsatzEditText.getText().clear();
                }

                if (prozentwertEditText.getText().length()!=0){
                    prozentwertEditText.getText().clear();
                }

                break;
        }
    }
}
