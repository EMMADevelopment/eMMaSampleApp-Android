package emma.io.emmasampleapp;

import android.app.Application;

import com.emma.android.eMMa;
import com.crashlytics.android.Crashlytics;
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
        eMMa.setDebuggerOutput(true);

        //eMMa Initialization
        eMMa.starteMMaSession(this, "emmasampleappJ2KIPmSms");

        //Starting push system
        eMMa.startPushSystem(this, MainActivity.class,R.drawable.logo, false);

    }
}
