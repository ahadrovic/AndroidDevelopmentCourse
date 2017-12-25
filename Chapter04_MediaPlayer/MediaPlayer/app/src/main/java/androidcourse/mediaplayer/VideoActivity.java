package androidcourse.mediaplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    VideoView video;
    MediaController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        video= (VideoView) findViewById(R.id.videoView);
        //If a MediaController  object doesn't exist, create one

        if (controller == null) {
            controller = new MediaController(this);
            //videoview will act as anchor for the mediacontroller
            controller.setAnchorView(video);
        }

        // set the media controller for video, and then setting out video uri and starting it
        video.setMediaController(controller);
        video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.chosen_video));
        video.start();

        video.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            //the code that should be run when the video is stopped because of an error
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                //Toast is a message that will pop on the screen, and the time length of it can be short or long- the last parameter
                Toast.makeText(getApplicationContext(), "Oops, something went wrong!", Toast.LENGTH_LONG).show();
                return false;
            }
        });
        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            //the code that should be run when the video is completed
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getApplicationContext(), "The tutorial has been completed!", Toast.LENGTH_LONG).show();
            }
        });

    }
}
