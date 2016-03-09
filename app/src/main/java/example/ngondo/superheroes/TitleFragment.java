package example.ngondo.superheroes;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.FragmentTransaction;

/**
 * Created by ngondo on 3/4/16.
 */
public class TitleFragment extends ListFragment {
    boolean mDualPane;
    int mCurCheckPosition = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Binding the data together i.e names with the stories
        ArrayAdapter<String> connectArrayToListView = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_activated_1, SuperheroInfo.NAMES);

        setListAdapter(connectArrayToListView);

        View detailsFrame = getActivity().findViewById(R.id.details);
        //give a value if it's landscape or portrait mode
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if(savedInstanceState != null){
            mCurCheckPosition = savedInstanceState.getInt("curChoice",0);
        }

        if(mDualPane){
            getListView().getChoiceMode();
            showDetails(mCurCheckPosition);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("curChoice", mCurCheckPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }
    /*
    * Proper hero data to be displayed linked with the indices of the arrays
    * */
    void showDetails(int index){
        mCurCheckPosition = index;
        //check if we are on horizontal or vertical
        if(mDualPane){
            getListView().setItemChecked(index, true);

            DetailsFragment details = (DetailsFragment) getFragmentManager().findFragmentById(
                    R.id.details
            );
            if(details == null || details.getShowIndex() != index){
                details = DetailsFragment.newInstance(index);

                //Begin fragment transaction
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.details, details);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }
        else{
            Intent i = new Intent();
            i.setClass(getActivity(), DetailsActivity.class);
            i.putExtra("index",index);
            startActivity(i);
        }
    }
}
