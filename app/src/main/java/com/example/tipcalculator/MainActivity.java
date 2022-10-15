package com.example.tipcalculator;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import java.lang.Math;



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    private static final String TAG = "";
    EditText etAmount;
    TextView tvPercent;
    SeekBar sbPercent;
    TextView tvTip;
    TextView tvTotal;
    TextView PerPerson;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    RadioGroup radioGroup;
    RadioButton radioButton;
    private int numPerson = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmount = findViewById(R.id.et_amount);
        tvPercent = findViewById(R.id.tv_percent);
        sbPercent = findViewById(R.id.sb_percent);
        tvTip = findViewById(R.id.tv_tip);
        tvTotal = findViewById(R.id.tv_total);
        PerPerson = findViewById(R.id.perPerson);
        spinner = findViewById(R.id.NumbOfP);
        radioGroup = findViewById(R.id.radioGroup);



        adapter = ArrayAdapter.createFromResource(this, R.array.spinner_list, android.R.layout.simple_spinner_item);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
            spinner.setAdapter(adapter);
        }

        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(this);
        }

        if (savedInstanceState != null) {
            tvPercent.setText(savedInstanceState.getString("Percent"));
            tvTip.setText(savedInstanceState.getString("Amount"));
            tvTotal.setText(savedInstanceState.getString("Total"));
            PerPerson.setText(savedInstanceState.getString("Person"));

        }

        sbPercent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int percent = progress;
                tvPercent.setText(String.valueOf(percent) + "%");
                calculate(1);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        etAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                calculate(1);

            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onInstanceStateOpen");
        outState.putString("Percent", tvPercent.getText().toString());
        outState.putString("Amount", tvTip.getText().toString());
        outState.putString("Total", tvTotal.getText().toString());
        outState.putString("Person", PerPerson.getText().toString());
        Log.d(TAG, "OnInstanceStateClose");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "inside of onStart");

        Log.d(TAG, "end of onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "inside of onResume");
        Log.d(TAG, "end of onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "inside of onRestart");

        Log.d(TAG, "end of onRestart");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "inside of onPause");

        Log.d(TAG, "end of onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "inside of onStop");

        Log.d(TAG, "end of onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "inside of onDestroy");

        Log.d(TAG, "end of onDestroy");
    }

    private void calculate(int num_person) {
        Log.d(TAG, "OpenCalc");
        if (etAmount.length() == 0) {
            etAmount.requestFocus();
            etAmount.setError("Enter a Amount");
        } else {
            double amount = Double.parseDouble(etAmount.getText().toString());
            int percent = sbPercent.getProgress();
            double tip = amount * percent / 100;
            double total = amount + tip;
            double perPerson = total / num_person;
            tvTip.setText(String.format("%.2f", tip));
            tvTotal.setText(String.format("%.2f", total));
            PerPerson.setText(String.format("%.2f", perPerson));
            Log.d(TAG, "CloseCalc");


        }

    }
    private void calculate1(int num_person) {
        Log.d(TAG, "OpenCalc1");
        if (etAmount.length() == 0) {
            etAmount.requestFocus();
            etAmount.setError("Enter a Amount");
        } else {
            double amount = Double.parseDouble(etAmount.getText().toString());
            int percent = sbPercent.getProgress();
            double tip = amount * percent / 100;
            tip = Math.round(tip);
            double total = amount + tip;
            double perPerson = total / num_person;
            tvTip.setText(String.format("%.2f", tip));
            tvTotal.setText(String.format("%.2f", total));
            PerPerson.setText(String.format("%.2f", perPerson));
            Log.d(TAG, "CloseCalc1");


        }





    }

    private void calculate2(int num_person) {
        if (etAmount.length() == 0) {
            etAmount.requestFocus();
            etAmount.setError("Enter a Amount");
        } else {
            double amount = Double.parseDouble(etAmount.getText().toString());
            int percent = sbPercent.getProgress();
            double tip = amount * percent / 100;
            double total = amount + tip;
            total = Math.round(total);
            double perPerson = total / num_person;
            tvTip.setText(String.format("%.2f", tip));
            tvTotal.setText(String.format("%.2f", total));
            PerPerson.setText(String.format("%.2f", perPerson));


        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "inside onCreateOptionsMenu");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (item.getItemId()) {
        case R.id.Share:
            String P1,P2,P3,P4,P5;
            P1 = "Amount to pay: ";

        }





        if (id == R.id.Share) {
            Log.d(TAG, "action settings selected");
            android.content.Intent intent = new android.content.Intent();
            intent.setAction(android.content.Intent.ACTION_SEND);
            intent.putExtra(android.content.Intent.EXTRA_TEXT, "The Bill Amount " +
                    etAmount.getText() + " Tip " + tvTip.getText() +
                    " Total Price " + tvTotal.getText() + " Split by " +  PerPerson.getText() + " Number of person " + (int) numPerson );

            intent.setType("text/plain");
            android.content.Intent chooser = android.content.Intent.createChooser(intent, "Share with");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(chooser);
            }
            return true;
        } else if (id == R.id.Info) {

            Log.d(TAG, "action alert selected");
            AlertDialog.Builder calc = new AlertDialog.Builder(MainActivity.this);
            calc.setTitle("IMFORMATION");
            calc.setMessage("The total amount has been split based on number of people.");
            calc.setCancelable(true);
            AlertDialog X = calc.create();
            X.show();


            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String x = adapterView.getItemAtPosition(i).toString();
        numPerson = Integer.parseInt(x);
        if (x.equals("1")) {
            calculate(1);
        } else if (x.equals("2")) {
            calculate(2);
        } else if (x.equals("3")) {
            calculate(3);
        } else if (x.equals("4")) {
            calculate(4);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
            calculate(1);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioButton radioButton = (RadioButton) radioGroup.findViewById(i);
        if (radioButton != null) {
            int check = radioButton.getId();
            switch (check) {
                case R.id.none:
                    calculate(numPerson);
                    break;

                case R.id.Tip:;
                    calculate1(numPerson);
                    break;
                case R.id.total:
                    calculate2(numPerson);

            }
        }
    }
}

