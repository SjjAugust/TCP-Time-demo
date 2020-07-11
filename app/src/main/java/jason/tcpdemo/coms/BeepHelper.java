package jason.tcpdemo.coms;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import java.io.IOException;

import jason.tcpdemo.R;

public class BeepHelper {
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private static final String TAG = "BeepHelper";
    private Uri notification;
    private Ringtone ringtone;

    public BeepHelper(Context context){
        Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + context.getPackageName() + "/" + R.raw.beep);
        try {
            mediaPlayer.setDataSource(context, uri);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void beep(){
        mediaPlayer.start();
    }
}
