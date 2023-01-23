package ddwu.mobile.week05.outputtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    SoundPool soundPool;
    int sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
//        sound = soundPool.load(this, R.raw.dingdong, 1); // 로딩시간이 play시간보다 더 길 수 있음 -> oncreate메소드에
    }

    public void onClick(View v) {

//        soundPool.play(sound, 1, 1, 0, 0, 1);
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); //왜 진동 안울리지..?
//        vibrator.vibrate(500);
        vibrator.vibrate(new long[] {100, 50, 200, 50}, 0);
//        vibrator.cancel();

    }
}