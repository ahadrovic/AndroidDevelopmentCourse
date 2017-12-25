package androidcourse.recipebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RecipeDetails extends AppCompatActivity {
    TextView title,ingredients,recipe;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        title = (TextView) findViewById(R.id.details_title);
        ingredients = (TextView) findViewById(R.id.details_ingredients);
        recipe= (TextView) findViewById(R.id.details_recipe);
        image = (ImageView) findViewById(R.id.details_image);

        //retrieving the data from intents and setting it to our views
        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        ingredients.setText(intent.getStringExtra("ingredients"));
        recipe.setText(intent.getStringExtra("description"));
        image.setImageResource(intent.getIntExtra("image",1));


    }
}
