package aceapp.ace.com.aceapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static float touchMotionOfButtonDown, touchMotionOfButtonUp;
    LinearLayout slidingArrowLayout;
    Button slidingLoginButton;
    TextView slidingArrow0, slidingArrow1, slidingArrow2, slidingArrow3, slidingArrow4, slidingArrow5, slidingArrow6, slidingArrow7, slidingArrow8, slidingArrow9;
    TextView unitPosition, tensPosition, hundredPosition, thousandPosition;
    Animation moveLeftToRight;
    int unitDigit = 1, tensDigit = 8, hundredDigit = 6, thousandDigit = 1;
    CircularProgressBar circularProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
        initializeAnimation();
        initializeCounter();


        new CountDownTimer(11000, 1) {

            @Override
            public void onTick(long millisUntilFinished) {
                circularProgressBar.setTitle("" + (millisUntilFinished / 1000));
                circularProgressBar.setSubTitle("your time is running");
                circularProgressBar.setProgress(100 - (int) (millisUntilFinished / 1000) * 10);
            }

            @Override
            public void onFinish() {
                circularProgressBar.setSubTitle("your time is over");
            }
        }.start();

        slidingLoginButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        touchMotionOfButtonDown = event.getX();
                        return true;
                    case MotionEvent.ACTION_UP:
                        touchMotionOfButtonUp = event.getX();
                        if ((touchMotionOfButtonUp - touchMotionOfButtonDown) > touchMotionOfButtonDown) {
                            Toast.makeText(getBaseContext(), "Swiped", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, SlidingLayoutActivity.class);
                            startActivity(intent);
                        }
                        return true;
                }
                return false;
            }
        });

    }

    private void initializeCounter() {
        for (int i = 0; i < unitDigit; i++) {
            Thread thread = new Thread() {
                int j = 0;

                @Override
                public void run() {
                    try {
                        while (j < unitDigit) {
                            sleep(100);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    unitPosition.setText(String.valueOf(j++));
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            thread.start();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < tensDigit; i++) {
                    Thread thread2 = new Thread() {
                        int j = 0;

                        @Override
                        public void run() {
                            try {
                                while (j < tensDigit) {
                                    sleep(100);
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            tensPosition.setText(String.valueOf(j++));
                                        }
                                    });
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    thread2.start();
                }
            }
        }, unitDigit * 100);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < hundredDigit; i++) {
                    Thread thread3 = new Thread() {
                        int j = 0;

                        @Override
                        public void run() {
                            try {
                                while (j < hundredDigit) {
                                    sleep(100);
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            hundredPosition.setText(String.valueOf(j++));
                                        }
                                    });
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    thread3.start();
                }
            }
        }, (unitDigit + tensDigit) * 100);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < thousandDigit; i++) {
                    Thread thread4 = new Thread() {
                        int j = 0;

                        @Override
                        public void run() {
                            try {
                                while (j < thousandDigit) {
                                    sleep(100);
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            thousandPosition.setText(String.valueOf(j++));
                                        }
                                    });
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    thread4.start();
                }
            }
        }, (unitDigit + tensDigit + hundredDigit) * 100);


    }

    private void initializeView() {
        slidingArrowLayout = (LinearLayout) findViewById(R.id.sliding_arrow);
        slidingLoginButton = (Button) findViewById(R.id.sliding_login_button);
        slidingArrow0 = (TextView) slidingArrowLayout.findViewById(R.id.sliding_arrow0);
        slidingArrow1 = (TextView) slidingArrowLayout.findViewById(R.id.sliding_arrow1);
        slidingArrow2 = (TextView) slidingArrowLayout.findViewById(R.id.sliding_arrow2);
        slidingArrow3 = (TextView) slidingArrowLayout.findViewById(R.id.sliding_arrow3);
        slidingArrow4 = (TextView) slidingArrowLayout.findViewById(R.id.sliding_arrow4);
        slidingArrow5 = (TextView) slidingArrowLayout.findViewById(R.id.sliding_arrow5);
        slidingArrow6 = (TextView) slidingArrowLayout.findViewById(R.id.sliding_arrow6);
        slidingArrow7 = (TextView) slidingArrowLayout.findViewById(R.id.sliding_arrow7);
        slidingArrow8 = (TextView) slidingArrowLayout.findViewById(R.id.sliding_arrow8);
        slidingArrow9 = (TextView) slidingArrowLayout.findViewById(R.id.sliding_arrow9);
        unitPosition = (TextView) findViewById(R.id.unit_position);
        tensPosition = (TextView) findViewById(R.id.tens_position);
        hundredPosition = (TextView) findViewById(R.id.hundred_position);
        thousandPosition = (TextView) findViewById(R.id.thousand_position);
        circularProgressBar = (CircularProgressBar) findViewById(R.id.circular_progress_bar);
    }

    private void initializeAnimation() {
        moveLeftToRight = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_PARENT, 0.1f, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0);
        moveLeftToRight.setDuration(500);
        moveLeftToRight.setRepeatCount(-1);
        moveLeftToRight.setInterpolator(new LinearInterpolator());
        moveLeftToRight.setFillAfter(true);
        slidingArrow0.startAnimation(moveLeftToRight);
        slidingArrow1.startAnimation(moveLeftToRight);
        slidingArrow2.startAnimation(moveLeftToRight);
        slidingArrow3.startAnimation(moveLeftToRight);
        slidingArrow4.startAnimation(moveLeftToRight);
        slidingArrow5.startAnimation(moveLeftToRight);
        slidingArrow6.startAnimation(moveLeftToRight);
        slidingArrow7.startAnimation(moveLeftToRight);
        slidingArrow8.startAnimation(moveLeftToRight);
        slidingArrow9.startAnimation(moveLeftToRight);
    }

}
