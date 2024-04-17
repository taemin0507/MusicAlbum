package com.example.musicalbum;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AudioImage extends AppCompatActivity {
    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        MediaPlayer mp = new MediaPlayer();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_image); //노래 재생 화면 출력
        setTitle("노래 재생");

        Intent it = getIntent();
        String tag = it.getStringExtra("it_tag"); //tag 값을 받아온다.

        // title, 노래 image, 가사의 객체를 받아온다.
        TextView title = findViewById(R.id.title);
        ImageView song_image = findViewById(R.id.song_image);
        TextView lyrics = findViewById(R.id.lyrics);
        Resources res = getResources();

        int stringId;
        String mkKey;

        //title을 가져온다.
        stringId = res.getIdentifier("title" + tag, "string", getPackageName());
        mkKey = res.getString(stringId);
        title.setText(mkKey);

        //이미지를 가져온다./ tag 값을 불러와 strings.xml의 song_image1, song_image2, song_image3를 불러온다.
        stringId = res.getIdentifier("song_image" + tag, "string", getPackageName());
        mkKey = res.getString(stringId);
        int imageId = res.getIdentifier(mkKey, "drawable", getPackageName());
        song_image.setImageResource(imageId);

        //가사를 불러온다.
        stringId = res.getIdentifier("lyrics" + tag, "string", getPackageName());
        mkKey = res.getString(stringId);
        lyrics.setText(mkKey);

        //Audio 재생
        stringId = res.getIdentifier("audio" + tag, "string", getPackageName());
        mkKey = res.getString(stringId);
        int audioId = res.getIdentifier(mkKey, "raw", getPackageName());
        mp = MediaPlayer.create(this, audioId);
        mp.setLooping(false);
        mp.start();
    } //end of onCreate
}
