package androidcourse.contactapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView name,lastname,email,phone,website;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning TextView from layout file to editText variable in out .java file
        name= (TextView) findViewById(R.id.name_input);
        lastname = (TextView) findViewById(R.id.lastname_input);
        email= (TextView) findViewById(R.id.email_input);
        phone = (TextView) findViewById(R.id.phone_input);
        website = (TextView) findViewById(R.id.website_input);

        //Assigning the button variable to the Save Button we declared in the xml file
        save= (Button) findViewById(R.id.save_button);

        // Here we are creating on click listener for the save button
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If we click on the Save Contact button, we should be able to move to a new activity
                //A new activity represent a new screen displaying our saved contact
                //To display the contact, we need to foward the entered data onto the new activity
                //For this, we are using intents. They can be used to start an activity, service, or deliver a messafe
                Intent i= new Intent(MainActivity.this,ContactActivity.class);
                String fullName= name.toString() +" "+lastname.toString();
                getIntent().putExtra("contactName",fullName);
                getIntent().putExtra("contactPhone",phone.toString());
                getIntent().putExtra("contactEmail",email.toString());
                getIntent().putExtra("contactWebsite",website.toString());
                startActivity(i);


            }
        });



    }
}
