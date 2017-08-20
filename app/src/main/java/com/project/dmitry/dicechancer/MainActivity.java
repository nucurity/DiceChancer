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

import java.text.DecimalFormat;

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
    ProbabilityEngine pengine;

    DecimalFormat persentFormat1 = new DecimalFormat("#.0");
    DecimalFormat persentFormat2 = new DecimalFormat("#");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pengine = new ProbabilityEngine();

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
            baseNumber = Integer.valueOf(baseValueEditText.getText().toString());
            baseNumber = validate(baseNumber, true);
            baseValueEditText.setText(String.valueOf(baseNumber));
        } else if (v.getId() == decrementBaseNumberButton.getId()) {
            baseNumber = Integer.valueOf(baseValueEditText.getText().toString());
            baseNumber = validate(baseNumber, false);
            baseValueEditText.setText(String.valueOf(baseNumber));
        } else if (v.getId() == incrementTargetNumberButton.getId()) {
            targetNumber = Integer.valueOf(targetValueEditText.getText().toString());
            targetNumber = validate(targetNumber, true);
            targetValueEditText.setText(String.valueOf(targetNumber));
        } else if (v.getId() == decrementTargetNumberButton.getId()) {
            targetNumber = Integer.valueOf(targetValueEditText.getText().toString());
            targetNumber = validate(targetNumber, false);
            targetValueEditText.setText(String.valueOf(targetNumber));
        } else if (v.getId() == calculateButton.getId()) {
            if (!baseValueEditText.getText().toString().equals("")){
                baseNumber = Integer.valueOf(baseValueEditText.getText().toString());
            }
            if (!targetValueEditText.getText().toString().equals("")){
                targetNumber = Integer.valueOf(targetValueEditText.getText().toString());
            }
            int resultNumber = targetNumber - baseNumber;
            updateResults(resultNumber);

        }
    }

    //increment and decrement method
    public int validate(int number, boolean operation) {

        if (operation) {
            if (number < 99)
                number++;
        } else {
            if (number > 0)
                number--;
        }

        return number;
    }

    private View getCellAtPos(TableLayout table, int position) {
        TableRow row = (TableRow) table.getChildAt(position / 6);
        return row.getChildAt(position % 6);
    }

    public void updateResults(int result) {
        double[] normalResult = pengine.fillNormal(result);
        //new double[5];
        //normalResult =
//        TextView cell = (TextView) getCellAtPos(resultTable,7);
//        cell.setText(""+normalResult[0]);
        for (int i = 0; i < 5; i++) {
            TextView cell = (TextView) getCellAtPos(resultTable, i + 7);


            if (normalResult[i] == 0 || normalResult[i] == 100)
                cell.setText(persentFormat2.format(normalResult[i]) + "%");
            else
                cell.setText(persentFormat1.format(normalResult[i]) + "%");

        }

    }
}
