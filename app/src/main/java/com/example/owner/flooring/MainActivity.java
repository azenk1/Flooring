package com.example.owner.flooring;
/**
 * Author: Al Zenk
 * Date:03/06/2017
 * Course: CIS 3334
 * Purpose: Application to calculate flooring needs. Exercise in passing data between activities.
 * Class Purpose: MainActivity tasked with obtaining data from the user.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    //Declare Class data members.
    EditText widthET;
    EditText lengthET;
    Button showResultButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Initialize data members
        widthET = (EditText)findViewById(R.id.widthEditText);
        lengthET = (EditText)findViewById(R.id.lengthEditText);
        showResultButton = (Button)findViewById(R.id.showResultButton);
    }

    /**
     * onClick method for show result button. Width and length are passed to calculateFootage
     * method to obtain a value for the amount of flooring needed.
     * @param view
     */
    public void showResult(View view)
    {

        //Retrieve values from EditText components and parse to double data to allow decimal input.
        double width = Double.parseDouble(widthET.getText().toString());
        double length = Double.parseDouble(lengthET.getText().toString());

        //Call to calculate footage amount method to calculate amount of flooring needed.
        double flooringAmount = calculateFootage(width, length);

        //Create intent to interface with second activity(displays flooring needs).
        Intent activityIntent = new Intent(this,Main2Activity.class);

        //Put extras. Here, width, length, flooringAmount.
        activityIntent.putExtra("Width", width);
        activityIntent.putExtra("Length", length);
        activityIntent.putExtra("Footage", flooringAmount);

        //Start the second Activity
        startActivity(activityIntent);

    }


    /**
     * Method to calculate flooring needs.
     * @param width - Passed by showResult method. Used to calculate square footage.
     * @param length - Passed by showResult method. Used to calculate square footage.
     * @return - Calculated square footage is returned to showResult.
     */
    public double calculateFootage(double width, double length)
    {
        double footage = width * length;
        return footage;
    }
}
