package com.example.tutorial_10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Splash extends AppCompatActivity {
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash );
        welcome = findViewById(R.id.welcome);
        int unicode = 0x1F64F;
        String emoji = getEmojiByUnicode(unicode);
        String text = "Welcome! ";
        welcome.setText(text + emoji);

        ImageView splash = findViewById(R.id.Splash_id);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        splash.startAnimation(animation);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));

    }
}