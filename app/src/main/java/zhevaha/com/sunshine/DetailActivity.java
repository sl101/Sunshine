package zhevaha.com.sunshine;

import android.app.Activity;
import android.util.Log;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

//    private final String MESSAGE = "message";

    private static final String LOG_TAG = DetailActivity.class.getSimpleName();
    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    private String mForecastStr;
private  TextView messageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

         messageView = (TextView) findViewById(R.id.message);

//        Intent intent = getIntent();
//        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
//            mForecastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
//        messageView.setText(mForecastStr);
//        }
//        String message = getIntent().getStringExtra(Intent.EXTRA_TEXT);
//        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
//        TextView messageView = (TextView) findViewById(R.id.message);
//        messageView.setText(message);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
//            getMenuInflater().inflate(R.menu.main, menu);
    getMenuInflater().inflate(R.menu.detail, menu);

    // Retrieve the share menu item
    MenuItem menuItem = menu.findItem(R.id.action_share);

    // Get the provider and hold onto it to set/change the share intent.
    ShareActionProvider mShareActionProvider =
            (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

    // Attach an intent to this ShareActionProvider.  You can update this at any time,
    // like when the user selects a new piece of data they might like to share.
    if (mShareActionProvider != null ) {
        mShareActionProvider.setShareIntent(createShareForecastIntent());
    } else {
        Log.d(LOG_TAG, "Share Action Provider is null?");
    }
            return true;
}

    private Intent createShareForecastIntent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
//        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,
                mForecastStr + FORECAST_SHARE_HASHTAG);
        return shareIntent;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
                    Intent intent = getIntent();
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            mForecastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
        messageView.setText(mForecastStr);
        }
        }

        return super.onOptionsItemSelected(item);
    }
}
