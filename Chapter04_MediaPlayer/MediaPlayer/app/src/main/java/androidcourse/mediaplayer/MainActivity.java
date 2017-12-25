package androidcourse.mediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    Button play,pause , rewind, fastForward , video;
    TextView songTitle, elapsedTimeTv, durationTv;
    SeekBar seekBar;
    MediaPlayer player;
    double elapsedTime,duration;
    Handler h;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning Buttons and TextViews from layout file to variables in our java file
        play= (Button) findViewById(R.id.play_button);
        pause= (Button) findViewById(R.id.pause_button);
        rewind=(Button) findViewById(R.id.rewind_button);
        fastForward= (Button) findViewById(R.id.forward_button);

        songTitle= (TextView) findViewById(R.id.song_title);
        elapsedTimeTv= (TextView) findViewById(R.id.current_time);
        durationTv= (TextView) findViewById(R.id.total_time);

        //Assigning our SeekBar view to a variable
        seekBar= (SeekBar) findViewById(R.id.seekBar);

        //when we enter the activity, we need to press play to start our music, so the pause button
        //must be disabled - nothing will happen when we click on it
        pause.setEnabled(false);
        //the seek bar should just show our songs progress, and the user will control the song flow
        //over the buttons, so we will disable clicking on it
        seekBar.setClickable(false);


        //we will use the MediaPlayer method to access and call our .mp3 file
        player=  MediaPlayer.create(this, R.raw.chosen_song);
        //getDuration method will return the duration of song in milliseconds
        duration=player.getDuration();
        seekBar.setMax((int)(duration));
        durationTv.setText(TimeUnit.MILLISECONDS.toMinutes((long) duration)+"m "+TimeUnit.MILLISECONDS.toSeconds((long) duration)+"s");




        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start method will begin playing our music
                player.start();

                //enable the pause button and disable the play button
                play.setEnabled(false);
                pause.setEnabled(true);

                //getCurrentPosition returns current position of song in milliseconds
                elapsedTime= player.getCurrentPosition();
                //convert milliseconds to a time string and set the text of elapsed time text view
                elapsedTimeTv.setText(TimeUnit.MILLISECONDS.toMinutes((long) elapsedTime)+"m "+TimeUnit.MILLISECONDS.toSeconds((long) elapsedTime)+"s");
               //update the progres on our seekbar
                seekBar.setProgress((int)(elapsedTime));

                //Create a handler to update position of SeekBar
                h= new Handler();
                //handler is a object used to communicate between 2 threads
                // it's mostly used when a background thread needs to update the UI
                // You can use a Handler to post some Runnable from your background thread to the UI thread
                 Runnable r= new Runnable() {
                    //When an object implementing interface Runnable is used
                    //starting the thread causes the object's run method to be called in
                    // separately executing thread - not to block the main one
                    @Override
                    public void run() {
                        elapsedTime= player.getCurrentPosition();
                        elapsedTimeTv.setText(TimeUnit.MILLISECONDS.toMinutes((long) elapsedTime)+"m "+TimeUnit.MILLISECONDS.toSeconds((long) elapsedTime)+"s");
                        seekBar.setProgress((int)(elapsedTime));
                        //delaying the thread for 50 seconds
                        h.postDelayed(this,50);

                    }
                };
                h.postDelayed(r,50);




            }

        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //stop the music with the pause() method
                player.pause();
                //enable the play button and disable the pause button
                play.setEnabled(true);
                pause.setEnabled(false);

            }

        });
        fastForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking if moving our elapsed time forward by one second will fit our songs duration
                if((int)elapsedTime+1000<= duration)
                {
                    //fast-forwarding the song by one second
                    elapsedTime+=1000;
                    //moving the song to a particular second with seekTo method
                    //the position must be integer
                    player.seekTo((int) elapsedTime);

                }
                else {}

            }

        });
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking if rewinding our sond by one second will exceed the begging of the song
                if((int)elapsedTime-1000 >= 0)
                {
                    //rewinding the song by one second
                    elapsedTime-=1000;
                    player.seekTo((int) elapsedTime);


                }
                else {}
            }

        });

        video=(Button) findViewById(R.id.button);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //moving to our video activity with intents
                Intent i= new Intent(MainActivity.this,VideoActivity.class);
                startActivity(i);

            }

        });




    }


}
