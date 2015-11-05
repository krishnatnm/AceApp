package aceapp.ace.com.aceapp;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SlidingLayoutActivity extends FragmentActivity implements OnMapReadyCallback {

    private SlidingUpPanelLayout mLayout;
    static float touchMotionOfButtonDown, touchMotionOfButtonUp;
    LinearLayout slidingArrowLayout;
    Button slidingLoginButton;
    Animation moveLeftToRight;
    TextView slidingArrow0, slidingArrow1, slidingArrow2, slidingArrow3, slidingArrow4, slidingArrow5, slidingArrow6, slidingArrow7, slidingArrow8, slidingArrow9;
    SupportMapFragment supportMapFragment;
    protected LocationManager locationManager;
    LatLng sydney;
    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding_layout_activity);
        initializeView();
        initializeAnimation();
        supportMapFragment.getMapAsync(SlidingLayoutActivity.this);
        if (googleMap == null) {
            googleMap = ((SupportMapFragment) getSupportFragmentManager().
                    findFragmentById(R.id.map)).getMap();
            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        }
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                sydney = new LatLng(location.getLatitude(), location.getLongitude());
                googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                Log.d("location", location.getLatitude() + " " + location.getLongitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
//        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

        mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        mLayout.setAnchorPoint(0.7f);
        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        mLayout.setPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
            }

            @Override
            public void onPanelExpanded(View panel) {

            }

            @Override
            public void onPanelCollapsed(View panel) {

            }

            @Override
            public void onPanelAnchored(View panel) {

            }

            @Override
            public void onPanelHidden(View panel) {

            }
        });
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
                            Intent intent = new Intent(SlidingLayoutActivity.this, PaymentBillSummary.class);
                            startActivity(intent);
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
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
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

    @Override
    public void onMapReady(GoogleMap googleMap) {
//        sydney = new LatLng(-34, 151);
//        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
