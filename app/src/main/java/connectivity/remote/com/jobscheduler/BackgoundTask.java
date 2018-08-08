package connectivity.remote.com.jobscheduler;

import android.os.AsyncTask;

public class BackgoundTask extends AsyncTask<Void,Void,String>{
    @Override
    protected String doInBackground(Void... voids) {
        return "Job is running...";
    }
}
