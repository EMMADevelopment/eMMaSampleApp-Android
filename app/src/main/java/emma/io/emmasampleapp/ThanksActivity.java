package emma.io.emmasampleapp;

import android.app.Activity;
import android.os.Bundle;

import io.emma.android.EMMA;

/**
 * Created by adrian on 16/12/15.
 */
public class ThanksActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thanks_layout);

        EMMA.getInstance().trackEvent("c8ba0668ab5c55a709ea75da15883f3e");
    }
}
