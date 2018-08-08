package connectivity.remote.com.jobscheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start_job;
    Button end_job;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_job = findViewById(R.id.start_job);
        end_job = findViewById(R.id.end_job);

    }
}
