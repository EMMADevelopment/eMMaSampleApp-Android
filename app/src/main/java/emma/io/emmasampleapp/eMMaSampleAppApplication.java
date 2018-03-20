package emma.io.emmasampleapp;

import android.app.Application;

import com.emma.android.eMMa;
import com.crashlytics.android.Crashlytics;

import io.emma.android.EMMA;
import io.fabric.sdk.android.Fabric;

/**
 * Created by jaume on 25/11/15.
 */
public class eMMaSampleAppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        //enable debug
        EMMA.Configuration configuration = new EMMA.Configuration.Builder(this)
                .setQueueTime(25)
                .setDebugActive(true)
                .build();

        //Initialization
        EMMA.getInstance().startSession(configuration);

        //Starting push system
        EMMA.getInstance().startPushSystem( MainActivity.class, R.drawable.logo, false);

    }
}
