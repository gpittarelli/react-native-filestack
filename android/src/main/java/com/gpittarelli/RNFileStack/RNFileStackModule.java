package com.gpittarelli.RNFileStack;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.filestack.android.FsActivity;
import com.filestack.android.FsConstants;
import com.filestack.Sources;
import com.filestack.Config;
import com.filestack.StorageOptions;
import android.content.Intent;
import android.app.Activity;
import java.util.ArrayList;

public class RNFileStackModule extends ReactContextBaseJavaModule {
  private final ReactApplicationContext reactContext;
	private final static int FILESTACK_RESULT = 0;

  public RNFileStackModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNFileStack";
  }

  @ReactMethod
  public void pick(String apiKey, String returnUrl, String policy, String signature, String storeLocation, String storeContainer) {
		// Create an intent to launch FsActivity
		Intent intent = new Intent(this.reactContext, FsActivity.class);

		// Create a config object with your account settings
		// Using security (policy and signature) is optional
		Config config = new Config(apiKey, returnUrl, policy, signature);
		intent.putExtra(FsConstants.EXTRA_CONFIG, config);

		// Setting storage options is also optional
		// We'll default to Filestack S3 if unset
		// The Filename and MIME type options are ignored and overridden
		StorageOptions storeOpts = new StorageOptions.Builder().location(storeLocation).container(storeContainer).build();
		intent.putExtra(FsConstants.EXTRA_STORE_OPTS, storeOpts);

		String[] mimeTypes = { "image/*" };
		intent.putExtra(FsConstants.EXTRA_MIME_TYPES, mimeTypes);

    Activity currentActivity = this.reactContext.getCurrentActivity();
		currentActivity.startActivityForResult(intent, FILESTACK_RESULT);
	}
}
