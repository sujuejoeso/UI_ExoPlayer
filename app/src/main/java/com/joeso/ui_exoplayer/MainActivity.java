package com.joeso.ui_exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class MainActivity extends AppCompatActivity {
    private SimpleExoPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get PlayerView from Layout
        PlayerView playerView=findViewById(R.id.player_view);
        //Uri of the Video
        Uri videoUrl=Uri.parse("https://www.radiantmediaplayer.com/media/bbb-360p.mp4");

        //create a SimpleExoPlayer
        SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(this);
        //bind the player to a playerview in the layout
        playerView.setPlayer(player);

        //Create DataSource for load the video
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "ExoPlayerTesting"));
        //MediaSource that wrap the video
        MediaSource videoSource = new ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(videoUrl);
        //Get the player ready
        player.prepare(videoSource);
        player.setPlayWhenReady(true);
        //player.setRepeatMode(Player.REPEAT_MODE_ONE);

    }
}
