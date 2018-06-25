package com.example.brons.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

import me.grantland.widget.AutofitTextView;

public class calc extends AppCompatActivity {

    convertToInt convertToInt = new convertToInt();
    convertToString convertToString = new convertToString();

    protected Character[] numeralList = {' ','I','V','X','L','C','D','M',' ',' '};
    protected Integer[] numeralValueList = {0,1,2,3,4,5,6,7,8,9};
    protected Integer[] calcButtonList = {R.id.button0,R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9,};

    AutofitTextView autofitTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        autofitTextView = (AutofitTextView) findViewById(R.id.textDisplayInput);

    }

    public void addValue(View view) {
        String textInput = ((TextView)findViewById(R.id.textDisplayInput)).getText()+"";
        for (int i = 0; i < 10; i++) {
            if (view.getId() == calcButtonList[i] && (!textInput.equals(" "))) {
                ((TextView)findViewById(R.id.textDisplayInput)).append(((TextView)findViewById(view.getId())).getText());
            }
        }
    }

    public void statusChange (View view) {
        String input = ((TextView)findViewById(R.id.textStatus)).getText()+"";

        if (view.getId() == R.id.buttonSwap) {
            // switches the state of calculator between both converting states
            if (input.equals("Roman Numeral to Decimal")) {
                // if already converting roman numerals, switches to converting decimals
                ((TextView)findViewById(R.id.textStatus)).setText("Decimal to Roman Numeral");
                for (int i = 0; i < 10; i++) {
                    Button button = (Button) findViewById(calcButtonList[i]);
                    button.setText(numeralValueList[i].toString());
                    if (button.getVisibility() == View.GONE && !" ".equals(numeralValueList[i].toString())) {
                        button.setVisibility(View.VISIBLE);
                    }
                }

                ((TextView)findViewById(R.id.textDisplayInput)).setText("");
                ((TextView)findViewById(R.id.textDisplayOutput)).setText("");
            }
            else {
                // if already converting decimals, switches to converting roman numerals
                ((TextView)findViewById(R.id.textStatus)).setText("Roman Numeral to Decimal");
                for (int i = 0; i < 10; i++) {
                    Button button = (Button) findViewById(calcButtonList[i]);
                    button.setText(numeralList[i].toString());
                    if (numeralValueList[i].toString().equals(" ")) {
                        button.setVisibility(View.GONE);
                    }
                }
                ((TextView)findViewById(R.id.textDisplayInput)).setText("");
                ((TextView)findViewById(R.id.textDisplayOutput)).setText("");
            }

        }

    }

    public void inputClear (View view) {
        ((TextView)findViewById(R.id.textDisplayInput)).setText("");
        ((TextView)findViewById(R.id.textDisplayOutput)).setText("");
    }

    public void inputDel (View view) {
        String textInput = ((TextView)findViewById(R.id.textDisplayInput)).getText()+"";
        if (textInput.length() != 0) {
            // can't delete nothing so conditional ensures an OutOfBoundsException is avoided
            ((TextView)findViewById(R.id.textDisplayInput)).setText(textInput.substring(0,textInput.length()-1));
            ((TextView)findViewById(R.id.textDisplayOutput)).setText("");
        }

    }

    public void inputEquals (View view) {
        String textInput = ((TextView)findViewById(R.id.textDisplayInput)).getText()+"";
        int textInputInt = Integer.parseInt(((TextView)findViewById(R.id.textDisplayInput)).getText().toString());

        if ((((TextView)findViewById(R.id.textStatus)).getText()+"").equals("Decimal to Roman Numeral")) {
            if (convertToString.checkRoman(textInput)) {
                // Checks if the integer inputted is valid
                convertToString convertToStringDisplay = new convertToString(textInputInt);
                ((TextView)findViewById(R.id.textDisplayOutput)).setText(convertToStringDisplay.convertedToNumeral().toString());
            }
        }

        else if ((((TextView)findViewById(R.id.textStatus)).getText()+"").equals("Roman Numeral to Decimal")) {
            if (convertToInt.checkRoman(textInputInt)) {
                // Checks if the numeral inputted is valid
                convertToInt convertToIntDisplay = new convertToInt(textInput);
                ((TextView)findViewById(R.id.textDisplayOutput)).setText(convertToIntDisplay.convertedToInt().toString());
            }
        }

    }

}
