package androidcourse.traveldiary;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    private LinearLayoutManager layoutManager;
    private CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting up the toolbar that will replace the actionBar
        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
        //Set the Toolbar to act as the ActionBar
        setSupportActionBar(topToolBar);
        setTitle(null);
        topToolBar.setLogo(R.drawable.logo2);
        topToolBar.setLogoDescription(getResources().getString(R.string.description));

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.travel_list);

        List<Destination> destinations = new ArrayList<Destination>();
        destinations.add(new Destination("Cairo", R.drawable.cairo));
        destinations.add(new Destination("Istanbul", R.drawable.istanbul));
        destinations.add(new Destination("Moscow", R.drawable.moscow));
        destinations.add(new Destination("Sydney", R.drawable.sydney));

        // two essential components of the recyclerView are the layout manager and adapter
        // layout manager positions items in RecyclerView and determines when to reuse item views
        // that are no longer visible to the user
        layoutManager = new LinearLayoutManager(MainActivity.this);
        customAdapter = new CustomAdapter(MainActivity.this, destinations);

        //setting the layout manager and custom adapter for our recyclerView
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customAdapter);

    }

    // Inflate the menu and add items to the action bar if it is present.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.travel_menu, menu);
        return true;
    }
    // Handling action bar item clicks here
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //getting the clicked item id and comparing it to defined actions ids
        int id = item.getItemId();
        if(id == R.id.action_refresh){
            Toast.makeText(MainActivity.this, "Clicked on Refresh", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.action_info){
            Toast.makeText(MainActivity.this, "Clicked on Help", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this, "Clicked on Settings", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }



}
