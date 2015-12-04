package sglazer.sglazerearthquake;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by student1 on 10/29/2015.
 */
public class EarthquakePagerAdapter extends PagerAdapter {
    private Features [] features;
    private Context context;

    public EarthquakePagerAdapter(Features [] features, Context context){
        this.features=features;
        this.context=context;
    }
    @Override
    public int getCount() {
        return features.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view== object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater= LayoutInflater.from(container.getContext());
        View view= inflater.inflate(R.layout.earthquake_pager_item, null);
        TextView place= (TextView) view.findViewById(R.id.place);
        TextView mag= (TextView) view.findViewById(R.id.mag);

        Features feature= features[position];
        Properties properties= feature.getProperties();
        place.setText(properties.getPlace());
        mag.setText(String.valueOf(properties.getMag()));
       container.addView(view);
        return view;
    }
}
