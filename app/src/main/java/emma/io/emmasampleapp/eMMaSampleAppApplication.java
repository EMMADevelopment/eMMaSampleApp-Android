package emma.io.emmasampleapp;

import android.app.Application;

import com.emma.android.eMMa;

/**
 * Created by jaume on 25/11/15.
 */
public class eMMaSampleAppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //enable debug
        eMMa.setDebuggerOutput(true);

        //eMMa Initialization
        eMMa.starteMMaSession(this, "emmasampleappJ2KIPmSms");

        //Starting push system
        eMMa.startPushSystem(this, MainActivity.class,R.drawable.logo, false);

    }
}
