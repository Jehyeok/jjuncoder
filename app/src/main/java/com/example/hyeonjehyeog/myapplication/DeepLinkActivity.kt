package com.example.hyeonjehyeog.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.deeplinkdispatch.DeepLinkHandler

@DeepLinkHandler(AppDeepLinkModule::class)
class DeepLinkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_link)

        // DeepLinkDelegate, LibraryDeepLinkModuleLoader and AppDeepLinkModuleLoader
        // are generated at compile-time.
        val deepLinkDelegate = DeepLinkDelegate(AppDeepLinkModuleLoader())
        // Delegate the deep link handling to DeepLinkDispatch.
        // It will start the correct Activity based on the incoming Intent URI
        deepLinkDelegate.dispatchFrom(this)
        // Finish this Activity since the correct one has been just started
        finish()
    }
}
