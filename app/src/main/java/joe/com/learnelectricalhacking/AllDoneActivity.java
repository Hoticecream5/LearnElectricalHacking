package joe.com.learnelectricalhacking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;

public class AllDoneActivity extends AppCompatActivity {
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_done);

        //ads
        MobileAds.initialize(this);

        AdLoader adLoader = new AdLoader.Builder(this,"ad-id")
                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {

                        UnifiedNativeAdView unifiedNativeAdView = (UnifiedNativeAdView) getLayoutInflater().inflate(R.layout.native_ad_layout,null);
                        mapUnifiedNativeAdToLayout(unifiedNativeAd,unifiedNativeAdView);

                        FrameLayout nativeAdLayout = findViewById(R.id.native_ad);
                        nativeAdLayout.removeAllViews();
                        nativeAdLayout.addView(unifiedNativeAdView);
                    }
                })
                .build();
        adLoader.loadAd(new AdRequest.Builder().build());
        //ads finish

        nextBtn = findViewById(R.id.connecting_button);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextButtonClicked();
            }
        });
    }

    public void nextButtonClicked(){
        Intent intent = new Intent(this,ConnectingActivity.class);
        startActivity(intent);
    }

    public void mapUnifiedNativeAdToLayout(UnifiedNativeAd adFromGoogle, UnifiedNativeAdView myAdView){
        MediaView mediaView = findViewById(R.id.ad_media);
        myAdView.setMediaView(mediaView);

        myAdView.setHeadlineView(myAdView.findViewById(R.id.ad_headline));
        myAdView.setBodyView(myAdView.findViewById(R.id.ad_body));
        myAdView.setCallToActionView(myAdView.findViewById(R.id.ad_call_to_action));
        myAdView.setIconView(myAdView.findViewById(R.id.ad_icon));
        myAdView.setPriceView(myAdView.findViewById(R.id.ad_price));
        myAdView.setStarRatingView(myAdView.findViewById(R.id.ad_rating));
        myAdView.setStoreView(myAdView.findViewById(R.id.ad_store));
        myAdView.setAdvertiserView(myAdView.findViewById(R.id.ad_advertiser));

        ((TextView)myAdView.getHeadlineView()).setText(adFromGoogle.getHeadline());

        if(adFromGoogle.getBody() == null){
            myAdView.getBodyView().setVisibility(View.GONE);
        }
        else{
            ((TextView)myAdView.getBodyView()).setText(adFromGoogle.getBody());
        }
        if(adFromGoogle.getCallToAction() == null){
            myAdView.getCallToActionView().setVisibility(View.GONE);
        }
        else{
            ((TextView)myAdView.getCallToActionView()).setText(adFromGoogle.getCallToAction());
        }
        if(adFromGoogle.getIcon() == null){
            myAdView.getIconView().setVisibility(View.GONE);
        }
        else{
            ((ImageView)myAdView.getIconView()).setImageDrawable(adFromGoogle.getIcon().getDrawable());
        }
        if(adFromGoogle.getPrice() == null){
            myAdView.getPriceView().setVisibility(View.GONE);
        }
        else{
            ((TextView)myAdView.getPriceView()).setText(adFromGoogle.getPrice());
        }
        if(adFromGoogle.getStarRating() == null){
            myAdView.getStarRatingView().setVisibility(View.GONE);
        }
        else{
            ((RatingBar) myAdView.getStarRatingView()).setRating(adFromGoogle.getStarRating().floatValue());
        }
        if(adFromGoogle.getStore() == null){
            myAdView.getStoreView().setVisibility(View.GONE);
        }
        else{
            ((TextView)myAdView.getStoreView()).setText(adFromGoogle.getStore());
        }
        if(adFromGoogle.getAdvertiser() == null){
            myAdView.getAdvertiserView().setVisibility(View.GONE);
        }
        else{
            ((TextView)myAdView.getAdvertiserView()).setText(adFromGoogle.getAdvertiser());
        }

        myAdView.setNativeAd(adFromGoogle);


    }

}
