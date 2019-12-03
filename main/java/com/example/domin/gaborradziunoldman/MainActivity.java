package com.example.domin.gaborradziunoldman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etpesel, etcukier, etskurczowe, etrozkurczowe, etnazwaleku, etdawkaleku;
    String pesel, cukier, skurczowe, rozkurczowe, nazwaleku, dawkaleku;

    String email, data, godzina, to, sub, mess;

    Button send, save;
    List<String> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(new Date());
        godzina = new SimpleDateFormat("hh:mm aa", Locale.getDefault()).format(new Date());

        etpesel = (EditText)findViewById(R.id.epesel);
        etcukier = (EditText)findViewById(R.id.ecukier);
        etskurczowe = (EditText)findViewById(R.id.eskurczowe);
        etrozkurczowe = (EditText)findViewById(R.id.erozkurczowe);
        etnazwaleku = (EditText)findViewById(R.id.enazwaleku);
        etdawkaleku = (EditText)findViewById(R.id.edawkaleku);



        send = (Button)findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pesel = etpesel.getText().toString();
                cukier = etcukier.getText().toString();
                skurczowe = etskurczowe.getText().toString();
                rozkurczowe = etrozkurczowe.getText().toString();
                nazwaleku = etnazwaleku.getText().toString();
                dawkaleku = etdawkaleku.getText().toString();
                if(pesel.length() == 11)
                {
                    if(cukier.length() > 1) {

                        if(skurczowe.length() > 1) {

                            if (rozkurczowe.length() > 1) {

                                if (nazwaleku.length() != 0)
                                {
                                    if (dawkaleku.length() != 0) {

                                        if (email == "Dr Gabor") {
                                            to = "dominikagabor190@gmail.com";
                                        }

                                        if (email == "Dr Radziun") {
                                            to = "agnieszkaradziun@gmail.com";
                                        }

                                        sub = "Wiadomość od pacjenta: " + pesel;

                                        mess = "Pacjent o numerze pesel: " + pesel + " w dniu: " + data + " o godzinie: " +
                                                godzina + " deklaruje wartość cukru: " + cukier + " mg/dL " + ", ciśnienie: " + skurczowe + "/" +
                                                rozkurczowe + " mmHg" + ". Ponadto zażyte zostały taki lek jak: " + nazwaleku + " o dawce: " +
                                                dawkaleku + " mg.";

                                        Intent intent = new Intent(Intent.ACTION_SEND);
                                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                                        intent.putExtra(Intent.EXTRA_SUBJECT, sub);
                                        intent.putExtra(Intent.EXTRA_TEXT, mess);

                                        intent.setType("message/rfc822");

                                        startActivity(Intent.createChooser(intent, "Select Email app"));
                                    }

                                    else { Toast.makeText(getApplicationContext(), "Wpisz dawkę leku", Toast.LENGTH_SHORT).show(); } }
                                    else { Toast.makeText(getApplicationContext(), "Wpisz nazwę leku", Toast.LENGTH_SHORT).show(); } }
                            else { Toast.makeText(getApplicationContext(), "Wpisz odpowiednią wartość ciśnienia rozkurczowego", Toast.LENGTH_SHORT).show();} }
                        else { Toast.makeText(getApplicationContext(), "Wpisz odpowiednią wartość ciśnienia skurczowego", Toast.LENGTH_SHORT).show();} }
                    else { Toast.makeText(getApplicationContext(), "Wpisz odpowiednią wartość cukru", Toast.LENGTH_SHORT).show(); } }
                else { Toast.makeText(getApplicationContext(), "Wpisz prawidłowy pesel", Toast.LENGTH_SHORT).show(); }
            }
        });

        // obsługa Spinner'a
        final Spinner spinner = (Spinner) findViewById(R.id.id_spinner);

        list = new ArrayList<String>();
        list.add("Dr Gabor");
        list.add("Dr Radziun");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int id, long position) {
                Toast.makeText(MainActivity.this, "Wybrano " + adapterView.getItemAtPosition(id).toString(), Toast.LENGTH_SHORT).show();
                email = adapterView.getItemAtPosition(id).toString();

                switch ((int) position) {
                    case 0:
                        break;
                    case 1:
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





    }

}













