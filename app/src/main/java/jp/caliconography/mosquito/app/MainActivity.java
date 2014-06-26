package jp.caliconography.mosquito.app;

import android.media.AudioManager;
import android.media.AudioTrack;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements Runnable {

        public static final double EIGHTH_NOTE = 0.125;
        public static final double FORTH_NOTE = 0.25;
        public static final double HALF_NOTE = 0.5;
        public static final double WHOLE_NOTE = 1.0;

        // Sound生成クラス
        private DigitalSoundGenerator soundGenerator;
        // Sound再生クラス
        private AudioTrack audioTrack;
        // 譜面データ
        private List<SoundDto> soundList = new ArrayList<SoundDto>();


        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            rootView.findViewById(R.id.btn_play).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // start sound
                    Thread th = new Thread(PlaceholderFragment.this);
                    th.start();
                }
            });
            return rootView;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // SoundGeneratorクラスをサンプルレート44100で作成
            soundGenerator = new DigitalSoundGenerator(44100, 44100);

            // 再生用AudioTrackは、同じサンプルレートで初期化したものを利用する
            audioTrack = soundGenerator.getAudioTrack();

            // スコアデータを作成
            initScoreData();

        }

        /**
         * 譜面データを作成
         */
        private void initScoreData() {
            // 譜面データ作成
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, WHOLE_NOTE), WHOLE_NOTE));
            soundList.add(new SoundDto(generateEmptySound(soundGenerator, EIGHTH_NOTE), EIGHTH_NOTE));

            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, WHOLE_NOTE), WHOLE_NOTE));
            soundList.add(new SoundDto(generateEmptySound(soundGenerator, EIGHTH_NOTE), EIGHTH_NOTE));

            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_G, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_C, WHOLE_NOTE), WHOLE_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_D, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, WHOLE_NOTE), WHOLE_NOTE));
            soundList.add(new SoundDto(generateEmptySound(soundGenerator, FORTH_NOTE), FORTH_NOTE));

            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, WHOLE_NOTE), WHOLE_NOTE));
            soundList.add(new SoundDto(generateEmptySound(soundGenerator, FORTH_NOTE), FORTH_NOTE));

            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, WHOLE_NOTE), WHOLE_NOTE));

            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_D, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_D, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_D, WHOLE_NOTE), WHOLE_NOTE));

            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_G, WHOLE_NOTE), WHOLE_NOTE));
            soundList.add(new SoundDto(generateEmptySound(soundGenerator, HALF_NOTE), HALF_NOTE));


            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, WHOLE_NOTE), WHOLE_NOTE));
            soundList.add(new SoundDto(generateEmptySound(soundGenerator, EIGHTH_NOTE), EIGHTH_NOTE));

            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, WHOLE_NOTE), WHOLE_NOTE));
            soundList.add(new SoundDto(generateEmptySound(soundGenerator, EIGHTH_NOTE), EIGHTH_NOTE));

            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_G, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_C, WHOLE_NOTE), WHOLE_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_D, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, 3), 3));
            soundList.add(new SoundDto(generateEmptySound(soundGenerator, FORTH_NOTE), FORTH_NOTE));

            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, WHOLE_NOTE), WHOLE_NOTE));
            soundList.add(new SoundDto(generateEmptySound(soundGenerator, EIGHTH_NOTE), EIGHTH_NOTE));

            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, EIGHTH_NOTE), EIGHTH_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, EIGHTH_NOTE), EIGHTH_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, WHOLE_NOTE), WHOLE_NOTE));

            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_G, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_G, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_D, HALF_NOTE), HALF_NOTE));
            soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_C, WHOLE_NOTE), WHOLE_NOTE));
        }

        @Override
        public void onPause() {
            super.onPause();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();

            // 再生中だったら停止してリリース
            if(audioTrack.getPlayState() == AudioTrack.PLAYSTATE_PLAYING) {
                audioTrack.stop();
                audioTrack.release();
            }
        }

        @Override
        public void onResume() {
            super.onResume();
        }

        /**
         * ８ビットのピコピコ音を生成する.
         * @param gen Generator
         * @param freq 周波数(音階)
         * @param length 音の長さ
         * @return 音データ
         */
        public byte[] generateSound(DigitalSoundGenerator gen, double freq, double length) {
            return gen.getSound(freq, length);
        }

        /**
         * 無音データを作成する
         * @param gen Generator
         * @param length 無音データの長さ
         * @return 無音データ
         */
        public byte[] generateEmptySound(DigitalSoundGenerator gen, double length) {
            return gen.getEmptySound(length);
        }

        @Override
        public void run() {

            // 再生中なら一旦止める
            if(audioTrack.getPlayState() == AudioTrack.PLAYSTATE_PLAYING) {
                audioTrack.stop();
                audioTrack.reloadStaticData();
            }
            // 再生開始
            audioTrack.play();

            // スコアデータを書き込む
            for(SoundDto dto : soundList) {
                audioTrack.write(dto.getSound(), 0, dto.getSound().length);
            }
            // 再生停止
            audioTrack.stop();
        }
    }


}
