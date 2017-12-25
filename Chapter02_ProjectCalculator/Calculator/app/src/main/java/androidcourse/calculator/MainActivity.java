package androidcourse.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declaring two variables to hold the numbers to be operated on
    //Both of them are type double, so they can hold the numbers with decimals
    double ValueOne;
    double ValueTwo;

    //Declaring TextView variables for our input and output field
    TextView inputString;
    TextView outputString;
    //this char will hold the operation that is currently clicked on in our app
    char currentOperation;


    //Here we override onCreate method which is the method of Activity class. It is called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning TextView from layout file to TextView variable in out .java file
        //inputTv and outputTv are our IDs, that we assigned to our TextViews in activity_main.xml
        inputString = (TextView) findViewById(R.id.inputTv);
        outputString = (TextView) findViewById(R.id.outputTv);
        //Assigning the button variables, starting from our number buttons, and then operations
        Button zero = (Button) findViewById(R.id.num0);
        Button one = (Button) findViewById(R.id.num1);
        Button two = (Button) findViewById(R.id.num2);
        Button three = (Button) findViewById(R.id.num3);
        Button four = (Button) findViewById(R.id.num4);
        Button five = (Button) findViewById(R.id.num5);
        Button six= (Button) findViewById(R.id.num6);
        Button seven = (Button) findViewById(R.id.num7);
        Button eight = (Button) findViewById(R.id.num8);
        Button nine = (Button) findViewById(R.id.num9);

        Button addition =(Button) findViewById(R.id.plusBtn);
        Button subtraction=(Button) findViewById(R.id.minusBtn);
        Button multiplication =(Button) findViewById(R.id.mulBtn);
        Button division =(Button) findViewById(R.id.divBtn);

        Button clear =(Button) findViewById(R.id.clrBtn);
        Button floatingPoint =(Button) findViewById(R.id.pointBtn);
        Button result = (Button) findViewById(R.id.eqBtn);

        //Here we are creating click listeners.
        //Suitable On click methods will be called when we click on one of the buttons
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If we click on number 0 out input field will display 0
                //We are concating 0 with our inputString in case we have more than one digit in our number, or a floating point.
                //The same logic is implemented for every num button
                inputString.setText(inputString.getText()+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputString.setText(inputString.getText()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputString.setText(inputString.getText()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputString.setText(inputString.getText()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputString.setText(inputString.getText()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputString.setText(inputString.getText()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputString.setText(inputString.getText()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputString.setText(inputString.getText()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputString.setText(inputString.getText()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputString.setText(inputString.getText()+"9");
            }
        });
        floatingPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputString.setText(inputString.getText()+".");
            }
        });
        //To clean our input field, we are entering a empty string into it
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputString.setText("");
                outputString.setText("");
            }
        });
        //Here we are setting the listeners for the operation buttons
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if we click on + button, we have to check if there is a number in the input field
                if(inputString.getText()!="")
                {
                    //we are getting the string from the input field, and converting it to type double
                    ValueOne = Double.parseDouble(inputString.getText().toString());
                    //setting the operation we clicked on as current operation
                    currentOperation='+';
                    //clearing the input field by setting its text to an empty string, so we can enter the second number
                    inputString.setText("");
                }
            }
        });
        //The same logic is implemented for every other operation button
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputString.getText()!="")
                {
                    ValueOne = Double.parseDouble(inputString.getText().toString());
                    currentOperation='-';
                    inputString.setText("");
                }

            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputString.getText()!="")
                {
                    ValueOne = Double.parseDouble(inputString.getText().toString());
                    currentOperation='*';
                    inputString.setText(" ");
                }

            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputString.getText()!="")
                {
                    ValueOne = Double.parseDouble(inputString.getText().toString());
                    currentOperation='/';
                    inputString.setText(" ");
                }

            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If we click on the = button, we will be checking if the input field contains something that we can assign to the second value
                if(inputString.getText()!="")
                {
                    double resultValue=0;
                    //getting the string from the input field, and converting it to type double
                    ValueTwo = Double.parseDouble(inputString.getText().toString());
                    //depending on the current operation we are calculating the result value
                    if(currentOperation=='+')
                    {
                        resultValue=ValueOne+ValueTwo;
                    }
                    else if(currentOperation=='-')
                    {
                        resultValue=ValueOne-ValueTwo;
                    }
                    else if(currentOperation=='*')
                    {
                        resultValue=ValueOne*ValueTwo;
                    }
                    else if(currentOperation=='/')
                    {
                        resultValue=ValueOne/ValueTwo;
                    }
                    //here we are setting the output string to
                    outputString.setText(resultValue+"");
                    inputString.setText("");

                }

            }
        });


    }


}
