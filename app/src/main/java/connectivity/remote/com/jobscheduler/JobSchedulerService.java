package connectivity.remote.com.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class JobSchedulerService extends JobService{

    BackgoundTask backgoundTask = null;
    @Override
    public boolean onStartJob(final JobParameters jobParameters) {

        backgoundTask = new BackgoundTask()
        {
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(JobSchedulerService.this, s, Toast.LENGTH_SHORT).show();
                jobFinished(jobParameters,false);
            }
        };

        backgoundTask.execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        backgoundTask.cancel(true);
        return true;
    }
}
