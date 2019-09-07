package com.parth.navigationviews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parth.navigationviews.models.User;


public class ViewProfileFragment extends Fragment {

    private static final String TAG = ViewProfileFragment.class.getSimpleName();

    private User mUser;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if(bundle != null){
            mUser = bundle.getParcelable(getString(R.string.intent_user));
            Log.d(TAG, "onCreate: got incoming bundle: " + mUser.getName());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_profile, container, false);
        Log.d(TAG, "onCreateView: started.");


        return view;
    }
}
