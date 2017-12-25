package androidcourse.traveldiary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

//To use a RecyclerView with CardView items that we defined, we have to create a custom Adapter
// to create views for items and binds items info to item view
//It will extend the built-in RecyclerView Adapter
//A ViewHolder describes an item view and metadata about its place within the RecyclerView

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {

    //Declaring a list of destinations and info about current application environment
    List<Destination> destinations;
    Context context;

    //Custom Adapter constructor
    public CustomAdapter(Context context, List<Destination> destinations) {
        this.destinations = destinations;
        this.context = context;
    }

    //Overriding the RecyclerView.Adapter method that returns the dataset size
    @Override
    public int getItemCount()
    {
        return this.destinations.size();
    }


    //this is where we inflate the item layout and create ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating a view and defining a new view holder for it

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,null);
        ViewHolder recyclerViewHolder = new ViewHolder(layoutView);
        return recyclerViewHolder;
    }

    //Overriding the method used to bind the dataset to the layout View widgets
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(destinations.get(position).getName());
        holder.image.setImageResource(destinations.get(position).getImage());
    }


}


