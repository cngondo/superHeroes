package example.ngondo.superheroes;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
