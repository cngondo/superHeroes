package example.ngondo.superheroes;

import android.app.Fragment;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by ngondo on 3/5/16.
 */
public class DetailsFragment extends Fragment {

    public static DetailsFragment newInstance(int index){
        DetailsFragment f = new DetailsFragment();

        Bundle args = new Bundle();
        args.putInt("index", index);

        f.setArguments(args);

        return f;
    }

    public int getShowIndex(){
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //The scroll view that'll be holding the text
        ScrollView scrollView = new ScrollView(getActivity());

        TextView text = new TextView(getActivity());
        //Dynamically adding padding to our activity
        int padding = (int)TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                4,
                getActivity().getResources().getDisplayMetrics()
        );
        text.setPadding(padding, padding, padding, padding);
        scrollView.addView(text);
        //putting information in the text view
        text.setText(SuperheroInfo.HISTORY[getShowIndex()]);

        return scrollView;
    }
}
