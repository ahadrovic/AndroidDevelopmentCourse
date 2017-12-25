package androidcourse.recipebook;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;


public class CustomAdapter extends ArrayAdapter<String> {
    // A basic Array Adapter adapt an ArrayList to the ListView
    // Because we need it not to display only string from the list but also another string and an image
    // We made our own custom adapter that extends all functionalities the built-in Array Adapter has


    List<String> recipeNames= new ArrayList<String>();
    List<String> recipeIngredients= new ArrayList<String>();
    List<String> recipeDescription = new ArrayList<String>();

    //image id will be a list of images we put in drawable, and we will be passing
    // the position to know which image to use

    private Integer[] imageid;
    private Activity context;

    //constructor for our Custom adapter
    public CustomAdapter(Activity context, List<String> recipeNames, List<String> recipeIngredients, List<String> recipeDescription, Integer[] imageid) {
        //we will be g the context, list element (xml) and 'main string' - title, to our base adapter (ArrayAdapter) constructor
        super(context, R.layout.recipe_list_item, recipeNames);

        this.context = context;
        this.recipeNames = recipeNames;
        this.recipeIngredients = recipeIngredients;
        this.recipeDescription= recipeDescription;
        this.imageid = imageid;

    }
    public void remove(int position){
        //removes the list items for the selected listview item
        recipeNames.remove(recipeNames.get(position));
        recipeIngredients.remove(recipeIngredients.get(position));
        recipeDescription.remove(recipeDescription.get(position));
    }

    //This is  main part of your adapter - it returns your custom View
    //This method gets a View that displays the data at the specified position in the data set
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //Because we won't be creating a View manually, we will inflate one from an XML layout file
        LayoutInflater inflater = context.getLayoutInflater();
        //We will be inflating it from our recipe_list_item layout file
        View listViewItem = inflater.inflate(R.layout.recipe_list_item, null, true);

        //Connecting our variables with views
        TextView nametv = (TextView) listViewItem.findViewById(R.id.recipe_name);
        TextView ingredientstv = (TextView) listViewItem.findViewById(R.id.ingredients);
        ImageView image = (ImageView) listViewItem.findViewById(R.id.recipe_image);

        Button deleteBtn = (Button)listViewItem.findViewById(R.id.delete_btn);

        //setting the textviews and imageviews to hold the data of the element that has
        //the specified position in our lists
        nametv.setText(recipeNames.get(position));
        ingredientstv.setText(recipeIngredients.get(position));

        //because we won't have any images for our new entries, we will set the image to default
        if (position>3) image.setImageResource(imageid[4]);
        else image.setImageResource(imageid[position]);

        //adding the actions for our buttons
        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //deleting the selected item
                remove(position);
                //notify the adapter that the list has changed
                notifyDataSetChanged();
            }
        });

        //returning the specified item (this will be done for all items)
        return  listViewItem;
    }
}
