package zhevaha.com.sunshine;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity{

    private final String MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String message = getIntent().getStringExtra(MESSAGE);

        TextView messageView = (TextView) findViewById(R.id.message);
        messageView.setText(message);
    }
}
