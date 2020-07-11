package com.Jnu.myadmobtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG: String = "로그"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,"MainActivity - onCreate() called")
        MobileAds.initialize(this) {}


        val adRequest = AdRequest.Builder().build()
        // 광고를 로드한다.
        banner.loadAd(adRequest)

        banner.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.d(TAG,"MainActivity - onAdLoaded() called")
            }

            override fun onAdFailedToLoad(errorCode : Int) {
                // Code to be executed when an ad request fails.
                Log.d(TAG,"MainActivity - onAdFailedToLoad() called")
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.d(TAG,"MainActivity - onAdOpened() called")
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Log.d(TAG,"MainActivity - onAdClicked() called")
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.d(TAG,"MainActivity - onAdLeftApplication() called")
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Log.d(TAG,"MainActivity - onAdClosed() called")
            }
        }
    }
}