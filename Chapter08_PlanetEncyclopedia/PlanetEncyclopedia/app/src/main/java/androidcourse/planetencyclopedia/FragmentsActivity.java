package androidcourse.planetencyclopedia;


import android.app.FragmentManager;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentsActivity extends AppCompatActivity {

    //Buttons for switching the fragments
    Button firstFragment, secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        firstFragment = (Button) findViewById(R.id.firstFragment);
        secondFragment = (Button) findViewById(R.id.secondFragment);

        // Load the fragments when we click on their buttons
        firstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //We will implement the loadFragment action below
                load(new FirstFragment());
            }
        });
        secondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load(new SecondFragment());
            }
        });

    }

    private void load(Fragment fragment) {
        // create a FragmentManager that will start transactions and replace the right fragment,
        // which we passed into the method
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // we will load the fragements into our frame layout that acts as a containter
        fragmentTransaction.replace(R.id.frameLayout, fragment );
        //save what we've done
        fragmentTransaction.commit();
    }
}
