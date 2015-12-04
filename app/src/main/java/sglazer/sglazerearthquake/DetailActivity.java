package sglazer.sglazerearthquake;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by student1 on 10/29/2015.
 */
public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstantState){
        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_detail);
        ViewPager viewPager= (ViewPager) findViewById(R.id.viewPager);
        Features [] features= (Features[]) getIntent().getSerializableExtra("EARTHQUAKES");
        EarthquakePagerAdapter adapter= new EarthquakePagerAdapter(features,this.getBaseContext());
        viewPager.setAdapter(adapter);
        int position= getIntent().getIntExtra("POSITION",0);

        viewPager.setCurrentItem(position);
    }
}
