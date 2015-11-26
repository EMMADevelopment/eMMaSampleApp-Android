
# eMMa Sample App

## Running The Sample

This is an Android Studio project build with gradle.

You can simply build an run and ask your expert service to see the metrics. But if you want to use with your own data and touch yourself you will need:

- Add your eMMa Session Key in Application Class.
- Configure GCM in Google Developer Console
- Add Project ID and API Key in your app configuration inside eMMa Dashboard

## Integrating eMMa Library

### Add the library to your classpath

Usually on modern Android Studio projects the lib path is located on */app/libs/* folder. But check with your *build.gradle* file the appropriate location of this file.

### Add Google Play Services
If you have not configured Google Play Services yet on your project. Open build.gradle file and add:

	dependencies {
        compile 'com.google.android.gms:play-services:8.3.0'
    }

### Add permisions to AndroidManifest.xml

	<!-- eMMa Required Permissions -->
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="com.google.android.c2dm.permission.RECEIVE" />
    
	<!-- If you plan to use Android Advertising ID -->
	<meta-data android:name="com.google.android.gms.version" android:value="@integer/google_play_services_version" />
	

### Start session on your Application class

eMMa needs to be started within onCreate method on your application class. If you don't have any application class yet you must create a class extending application.

	import android.app.Application;

	public class eMMaSampleAppApplication extends Application {
    	@Override
    	public void onCreate() {
        	super.onCreate();
        }
	}
	
And you have to set the name on application tag inside AndroidManifest.xml

	<application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/AppTheme"
        android:name="eMMaSampleAppApplication">
        
From this point you can start the session with your session key. In this case: *emmasampleappJ2KIPmSms*

	public class eMMaSampleAppApplication extends Application {
    	@Override
    	public void onCreate() {
        	super.onCreate();
        	
        	//eMMa Initialization
        	eMMa.starteMMaSession(this, "emmasampleappJ2KIPmSms");
    	}
	}
	
## Start Tracking

### Enable install referer

To track Android installs with accuracy you must add this receiver within *\<application />* tag

	<receiver android:name="com.emma.android.eMMaReferralReceiver" android:exported="true">
		<intent-filter>
			<action android:name="com.android.vending.INSTALL_REFERRER"/>
		</intent-filter>
	</receiver>
	
## Using Push Notifications

### Set required push permission

You must add following permissions to AndroidManifest.xml to work with push. Replace *emma.io.emmasampleapp* with your package name

	<!-- eMMa Push Permissions -->
    <permission android:name="emma.io.emmasampleapp.permission.C2D_MESSAGE" android:protectionLevel="signature" />
    <uses-permission android:name="emma.io.emmasampleapp.permission.C2D_MESSAGE" />
    <uses-permission android:name="com.google.android.c2dm.permission.RECEIVE" />
    <uses-permission android:name="android.permission.GET_ACCOUNTS" />
    <uses-permission android:name="android.permission.VIBRATE" />
    <uses-permission android:name="android.permission.WAKE_LOCK" />
    
### Configure receiver service

	<service android:name="com.emma.android.eMMaGCMReceiver" />
	<receiver android:name="com.emma.android.GCMBroadcastReceiver" android:permission="com.google.android.c2dm.permission.SEND">
		<intent-filter>
			<action android:name="com.google.android.c2dm.intent.REGISTRATION"/>
			<action android:name="com.google.android.c2dm.intent.RECEIVE"/>
			<category android:name="emma.io.emmasampleapp" />
		</intent-filter>
	</receiver>
	
### Start push system

Next to *starteMMaSession* method on your Application class you can start push system

	public class eMMaSampleAppApplication extends Application {
    	@Override
    	public void onCreate() {
        	super.onCreate();
        	
        	//eMMa Initialization
        	eMMa.starteMMaSession(this, "emmasampleappJ2KIPmSms");
        	
			//Start Push System
			eMMa.startPushSystem(this, MainActivity.class,R.drawable.icon,true);
    	}
	}