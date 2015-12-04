package sglazer.sglazerearthquake;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by student1 on 11/19/2015.
 */
public class EarthquakeAsyncTask extends AsyncTask<Long, String, String> {

    //asynchronous - not at the same time
    //AsyncTask is an abstract class, which will be discussed in 2 weeks
    public Features features[];
    private RecyclerView recyclerView;
    private EarthquakeAdapter adapter;

    public EarthquakeAsyncTask(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    //the methods below were created using code override
    //the return and parameter types were generated based the the classes parameters in the header
    //this is like the run method of a thread
    @Override
    protected String doInBackground(Long... params) {
        URL url;
        try {
            url = new URL(
                    "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/significant_month.geojson");
            URLConnection connection = url.openConnection();
            InputStream in = connection.getInputStream();
            byte b[] = new byte[4096];
            // num bytes returned
            int n = -1;
            StringBuilder json = new StringBuilder();
            while ((n = in.read(b)) != -1) {
                json.append(new String(b, 0, n));

            }
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            Earthquake earthquake = gson.fromJson(new InputStreamReader(in), Earthquake.class);
            features = earthquake.getFeatures();
            adapter = new EarthquakeAdapter(earthquake.getFeatures());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

        //this is what to do when the Async task is done
        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);
            //need to create a constructor to have access to the textView in MainActivity
            //there are other ways to access the main thread variables
            recyclerView.setAdapter(adapter);
        }

}
