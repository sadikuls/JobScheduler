package connectivity.remote.com.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int JOBSCHEDULER_ID = 1001;
    Button start_job;
    Button end_job;

    JobScheduler mJobScheduler = null;
    JobInfo mJobInfo = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_job = findViewById(R.id.start_job);
        end_job = findViewById(R.id.end_job);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_job:{
                setmJobScheduler();
                startJobScheduler();
                break;
            }
            case R.id.end_job:{

                break;
            }
        }
    }

    //instantiate job scheduler

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setmJobScheduler(){
        ComponentName componentName = new ComponentName(this, JobSchedulerService.class);
        JobInfo.Builder builder = new JobInfo.Builder(JOBSCHEDULER_ID,componentName);
        builder.setPeriodic(2000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setPersisted(true);

        mJobInfo = builder.build();

        mJobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
    }

    //start job scheduler
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void startJobScheduler(){
        mJobScheduler.schedule(mJobInfo);
    }

}
