# Audio

* You can make somethings after the music complete

````java
// fields
private MediaPlayer mediaPlayer;

    // inside onCreate or wherever you want
    mediaPlayer = MediaPlayer.create( getApplicationContext(), R.raw.my_audio );
    mediaPlayer.setOnCompletionListener( mp->{
    int duration = mp.getDuration();
    String durationStr = String.valueOf(duration / 1000);

    Toast.makeText(this, ("Duration " + durationStr + " seconds"), Toast.LENGTH_LONG).show();
});
````

* Audio playing is a resource heavy activity so don't forget to release the sources you took

````java
@Override
protected void onDestroy() {
    if( mediaPlayer != null && mediaPlayer.isPlaying() ){
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }
    
    super.onDestroy();
}
````