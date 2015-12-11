package sglazer.sglazerearthquake;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by student1 on 10/22/2015.
 */
public class EarthquakeViewHolder extends RecyclerView.ViewHolder{

    private TextView place;
    private TextView mag;
    public EarthquakeViewHolder(View itemView) {
        super(itemView);
        place = (TextView) itemView.findViewById(R.id.place);
        mag= (TextView) itemView.findViewById(R.id.mag);
    }
    public void bind(Features features){
    place.setText(features.getProperties().getPlace());
        mag.setText(String.valueOf(features.getProperties().getMag()));
    }
}
