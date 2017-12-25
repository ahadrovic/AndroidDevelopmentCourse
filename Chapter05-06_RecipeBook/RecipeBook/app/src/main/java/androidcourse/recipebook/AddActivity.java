package androidcourse.recipebook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    TextView recipe_input,name_input, ingredients_input;
    Button submit_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name_input= (TextView) findViewById(R.id.name_input);
        recipe_input= (TextView) findViewById(R.id.recipe_input);
        ingredients_input= (TextView) findViewById(R.id.ingredients_input);
        submit_btn= (Button) findViewById(R.id.submit_btn);

        //when we click on submit -> remember the input and take us to main activity
        submit_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //sending back data to main Activity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("Recipe name",name_input.getText().toString());
                resultIntent.putExtra("Recipe ingredients",ingredients_input.getText().toString());
                resultIntent.putExtra("Recipe desc",recipe_input.getText().toString());
                setResult(Activity.RESULT_OK, resultIntent);
                //going back to main activity
                finish();
            }
        });
    }
}
