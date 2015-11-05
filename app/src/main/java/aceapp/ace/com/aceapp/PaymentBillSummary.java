package aceapp.ace.com.aceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentBillSummary extends AppCompatActivity {

    static float touchMotionOfButtonDown, touchMotionOfButtonUp;
    LinearLayout slidingArrowLayout;
    Button slidingLoginButton;
    Animation moveLeftToRight;
    TextView slidingArrow0, slidingArrow1, slidingArrow2, slidingArrow3, slidingArrow4, slidingArrow5, slidingArrow6, slidingArrow7, slidingArrow8, slidingArrow9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_bill_summary);
        initializeView();
        initializeAnimation();
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
//                            Intent intent = new Intent(SlidingLayoutActivity.this, PaymentBillSummary.class);
//                            startActivity(intent);
                        }
                        return true;
                }
                return false;
            }
        });
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
    }

}
