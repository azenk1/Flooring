package com.example.owner.flooring;

/**
 * Author: Al Zenk
 * Date:03/06/2017
 * Course: CIS 3334
 * Purpose: Application to calculate flooring needs. Exercise in passing data between activities.
 * Class Purpose: Main2Activity is tasked with retrieving the data passed via a Bundle. This data
 * is then used to provide the user with feedback on their inputs and the amount of flooring they
 * will need. Overridden toString() method provides an efficient means to formatting the data into
 * easy to read output.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    //Declare Class data members.
    TextView flooringTV;
    TextView toStringTV;
    double length;
    double width;
    double footage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //initialize TextViews
        flooringTV = (TextView)findViewById(R.id.flooringNeededTV);
        toStringTV = (TextView)findViewById(R.id.toStringTV);

        //Create Bundle to access extras
        Bundle extras = getIntent().getExtras();
        width = extras.getDouble("Width");
        length = extras.getDouble("Length");
        footage = extras.getDouble("Footage");

        //Set text with appropriate information via the toString method written below.
        toStringTV.setText(toString());
    }

    /**
     * Overridden toString to display dimensions related to flooring
     * @return - Returns String with length, width, and footage values in human readable format.
     */
    @Override
    public String toString()
    {
        String textViewText = "Width is " + width + " and length is " + length
                +" and flooring needed is " + footage;

        return textViewText;
    }
}
