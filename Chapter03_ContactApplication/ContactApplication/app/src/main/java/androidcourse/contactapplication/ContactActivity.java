package androidcourse.contactapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {
    TextView displayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        //We will receive the data from the activity that has started this one using the getIntent() method
        Intent intent = getIntent();
        //Our extra data is represented as strings, so we use the intent.getStringExtra method
        String name= intent.getStringExtra("contactName");
        String phone= intent.getStringExtra("contactPhone");
        String email= intent.getStringExtra("contactPhone");
        String website= intent.getStringExtra("contactPhone");

        displayName =(TextView) findViewById(R.id.name_display);
        displayName.setText(name);

        //Here we will set the contact name textview in the xml file
    }
}
