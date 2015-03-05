package com.myapps.steve_000.converter;
// Geny motion
//lynda.com
//pluralsight.com
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText userInput;
    RadioButton radio_celsius;
    RadioButton radio_fahrenheit;
    Button onCalcButton;
    TextView view_answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiseVariables();

        addOnCalculateButton();
        addOnRadioButtonClicked();
    }

    private void initialiseVariables() {
        radio_celsius = (RadioButton) findViewById(R.id.radio_celsius);
        radio_fahrenheit = (RadioButton) findViewById(R.id.radio_fahrenheit);
        onCalcButton = (Button) findViewById(R.id.calc_btn);
        userInput = (EditText) findViewById(R.id.user_input);
        view_answer = (TextView) findViewById(R.id.label_ans);
    }

    private void addOnRadioButtonClicked() {


    }


    private void addOnCalculateButton() {
        onCalcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ans = 0.00;
                double userInputAsDouble;

                String userInputAsString = userInput.getText().toString();


                if (radio_celsius.isChecked()) {
                    try {
                        userInputAsDouble = Double.parseDouble(userInput.getText().toString());
                        ans = calcFahrenheitToCelsius(userInputAsDouble);

                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Enter a valid value to convert", Toast.LENGTH_LONG).show();
                    }
                    //Toast.makeText(getApplicationContext(), "celsius clicked", Toast.LENGTH_LONG).show();


                } else if (radio_fahrenheit.isChecked()) {
                    try {
                        userInputAsDouble = Double.parseDouble(userInput.getText().toString());
                        ans = calcCelsiusToFahrenheit(userInputAsDouble);

                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Enter a valid value to convert", Toast.LENGTH_LONG).show();
                    }
                    //Toast.makeText(getApplicationContext(), "fahrenheit clicked", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getApplicationContext(), "select a conversion option", Toast.LENGTH_LONG).show();
                }


                String ansAsString = String.valueOf(ans);

                view_answer.setText(ansAsString);


            }
        });

    }

    private double calcFahrenheitToCelsius(Double fahrenheitValue){

        return (((fahrenheitValue * 9) / 5) + 32);
    }

    private double calcCelsiusToFahrenheit(Double celsiusValue){

        return (((celsiusValue - 32) * 5) / 9);
    }

    private EditText getUserInput(){
        return this.userInput;
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
