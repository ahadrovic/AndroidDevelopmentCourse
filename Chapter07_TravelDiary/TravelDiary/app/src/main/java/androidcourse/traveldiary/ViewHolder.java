package androidcourse.traveldiary;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;




public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    //ViewHolder is an implementation that stores Views for a larger area
    //You can look at it as a sort of helper class and cache mechanism


    //These are our ViewHolder Items (destination name and image)
    TextView name;
    ImageView image;

    //a boolean field that will tell us if the text view is currently visible
    Boolean visibleText;
    //layout that holds the text
    RelativeLayout layout;

    //View Holder Constructor
    public ViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        //connecting to the views
        name = (TextView)itemView.findViewById(R.id.country_name);
        image = (ImageView)itemView.findViewById(R.id.country_photo);
        visibleText=false;
        layout = (RelativeLayout) itemView.findViewById(R.id.holder);
    }
    // RecyclerView doesn’t come with an onItemClick interface like ListView, so you have to implement one in the adapter or viewholder
    @Override
    public void onClick(View view) {

        if (!visibleText) {
            showText(layout);
            name.setVisibility(View.VISIBLE);

        } else {

            hideText(layout);
            name.setVisibility(View.INVISIBLE);

        }
    }
    //showing the text with a circular reveal animation
    private void showText(RelativeLayout view)
    {
        //maximum value that the circle is going to expand to
        int maximum = Math.max(view.getWidth(), view.getHeight());
        // x and y positions of the view
        int x = view.getRight() ;
        int y = view.getBottom();
        //ViewAnimationUtils defines common utilities for working with View's animations
        //It will return an Animator which can animate a clipping circle
        Animator reveal = ViewAnimationUtils.createCircularReveal(view, x, y, 0, maximum);
        //showing the destination name
        visibleText = true;
        reveal.start();
    }
    //hiding the text with a circular reveal animation
    public void hideText(final RelativeLayout view)
    {
        // value that the circle is going to start shrinking from
        int beginning = view.getWidth();
        //x and y positions of the view
        int x = view.getRight();
        int y = view.getBottom() ;
        Animator hide = ViewAnimationUtils.createCircularReveal(view,x, y, beginning, 0);
        hide.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

            }
        });
        //hiding the destination name
        visibleText = false;
        hide.start();
    }
}
