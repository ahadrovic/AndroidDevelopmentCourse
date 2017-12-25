package androidcourse.recipebook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class MainActivity extends AppCompatActivity {
    ListView recipes_list;
    //  Instancing an integer array holding the id of the images we added in the drawable folder
    // We will be getting a position to know which image to use
    Integer imageid[] = {
            R.drawable.chickencasserole,
            R.drawable.tomatosoup,
            R.drawable.veggiepasta,
            R.drawable.cranberrysalad,
            R.drawable.defaultimage,
    };

    List<String> recipeNames= new ArrayList<String>();
    List<String> recipeIngredients= new ArrayList<String>();
    List<String> recipeDescription= new ArrayList<String>();
    TextView input;
    CustomAdapter listadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipes_list=(ListView) findViewById(R.id.recipe_listview);

        Button newbtn = (Button) findViewById(R.id.add_recipe);
        Button searchbtn = (Button) findViewById(R.id.search_btn);
        input=(TextView) findViewById(R.id.search_input);

        //populating out lists
        recipeNames.add("Chicken Casserole");
        recipeIngredients.add("Chicken, Parsley, Sour Cream ");
        recipeDescription.add("Brown the bacon and put on the plate with the chicken. " +
                "Add the carrot, celery, bouquet garni, chicken stock and wine to the" +
                " chicken and season well. Cover and transfer to a preheated oven at 170ºC " +
                " for 30-40 mins.");

        recipeNames.add("Tomato Soup");
        recipeIngredients.add("Tomato,lentil,onion ");
        recipeDescription.add("Recipe number 2 - add description here");

        recipeNames.add("Veggie Pasta");
        recipeIngredients.add("Pasta, tomatos, celery");
        recipeDescription.add("Recipe number 3 - add description here");

        recipeNames.add("Cranberry Salad");
        recipeIngredients.add("Cranberry, green salad, nuts");
        recipeDescription.add("Recipe number 4 - add description here");

        //making a custom list addapter and passing context and items to display to its constructor
        listadapter = new CustomAdapter(this, recipeNames, recipeIngredients,recipeDescription, imageid);
        recipes_list.setAdapter(listadapter);

        //when we click on an item
        recipes_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Here, we are sending the data to our detail activity
                //Declaring Intent
                Intent intent = new Intent(MainActivity.this, RecipeDetails.class);
                //Putting extra data in intent
                intent.putExtra("title",recipeNames.get(i));
                intent.putExtra("ingredients", recipeIngredients.get(i));
                intent.putExtra("description",recipeDescription.get(i));
                intent.putExtra("image",imageid[i]);
                startActivity(intent);
            }
        });
        newbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Redirecting to the add recipe activity
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                //We use startActivityForResult instead of startActivity because the add Activity
                //needs to return some data (user input) to the main Activity
                //this provides a pipeline for sending data back to the main Activity using setResult
                startActivityForResult(intent,1);



            }
        });
        searchbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //filtering a recipe with the name that the user typed
                for (int i = 0; i < recipeNames.size(); i++) {
                    if (recipeNames.get(i).contains(input.getText().toString()))
                    {
                        //copy the intent from the recipe_list onClickListener
                        Intent intent = new Intent(MainActivity.this, RecipeDetails.class);
                        //Putting extra data in intent
                        intent.putExtra("title",recipeNames.get(i));
                        intent.putExtra("ingredients", recipeIngredients.get(i));
                        intent.putExtra("description",recipeDescription.get(i));
                        intent.putExtra("image",imageid[i]);
                        startActivity(intent);
                        break;

                    }
                }


            }
        });

    }
    //To access the returned data from the add activity we need to override the onActivityResult
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            //1 is the request code we set in startActivityForResult
            case (1) : {
                if (resultCode == Activity.RESULT_OK) {
                    // Extract the data returned from the child Activity.

                    String returnName = data.getStringExtra("Recipe name");
                    String returnIng = data.getStringExtra("Recipe ingredients");
                    String returnRecipe = data.getStringExtra("Recipe desc");

                    recipeNames.add(returnName);
                    recipeIngredients.add(returnIng);
                    recipeDescription.add(returnRecipe);

                    //notify the adapter that the recipe list has changed
                    listadapter.notifyDataSetChanged();

                }
                break;
            }
        }
    }
}
