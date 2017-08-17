package com.project.dmitry.dicechancer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Layout control items
    EditText baseValueEditText;
    EditText targetValueEditText;
    Button calculateButton;
    Button incrementBaseNumberButton;
    Button decrementBaseNumberButton;
    Button incrementTargetNumberButton;
    Button decrementTargetNumberButton;
    TableLayout resultTable;

    //Variables for calculation
    int baseNumber;
    int targetNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculateButton = (Button) findViewById(R.id.button_calculate);
        incrementBaseNumberButton = (Button) findViewById(R.id.button_increment_base_number);
        decrementBaseNumberButton = (Button) findViewById(R.id.button_decrement_base_number);
        incrementTargetNumberButton = (Button) findViewById(R.id.button_increment_target_number);
        decrementTargetNumberButton = (Button) findViewById(R.id.button_decrement_target_number);

        baseValueEditText = (EditText) findViewById(R.id.base_number_value);
        targetValueEditText = (EditText) findViewById(R.id.target_number_value);

        baseNumber = 0;
        targetNumber = 0;

        //Not enouth user friendly
        //baseValueEditText.setText(String.valueOf(baseNumber));
        //targetValueEditText.setText(String.valueOf(targetNumber));


        //Button listners
        calculateButton.setOnClickListener(this);
        incrementBaseNumberButton.setOnClickListener(this);
        decrementBaseNumberButton.setOnClickListener(this);
        incrementTargetNumberButton.setOnClickListener(this);
        decrementTargetNumberButton.setOnClickListener(this);

        //result layout initialization
        resultTable = (TableLayout) findViewById(R.id.result_table);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == incrementBaseNumberButton.getId()) {
            baseNumber = validate(baseNumber, true);
            baseValueEditText.setText(String.valueOf(baseNumber));
        }
        else if (v.getId() == decrementBaseNumberButton.getId())
        {
            baseNumber = validate(baseNumber,false);
            baseValueEditText.setText(String.valueOf(baseNumber));
        }
        else if (v.getId() == incrementTargetNumberButton.getId())
        {
            targetNumber = validate(targetNumber,true);
            targetValueEditText.setText(String.valueOf(targetNumber));
        }

        else if (v.getId() == decrementTargetNumberButton.getId())
        {
            targetNumber = validate(targetNumber,false);
            targetValueEditText.setText(String.valueOf(targetNumber));
        }
    }

    //increment and decrement method
    public int validate(int number, boolean operation) {

        if (operation) {
            if (number < 99)
                number++;
        }
        else {
            if (number > 0)
                number--;
        }

        return number;
    }

    private View getCellAtPos(TableLayout table, int position) {
        TableRow row = (TableRow) table.getChildAt(position / 6);
        return row.getChildAt(position % 6);
    }

    public void updateResults(){

    }
}
