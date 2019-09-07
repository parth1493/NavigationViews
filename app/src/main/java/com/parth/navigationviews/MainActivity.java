package com.parth.navigationviews;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.parth.navigationviews.models.User;
import com.parth.navigationviews.utils.PreferenceKeys;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"on Create started");

        firstTimeLogin();
        init();
    }

    private void init() {
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_content_frame,homeFragment,getString(R.string.tag_fragment_home));
        fragmentTransaction.addToBackStack(getString(R.string.tag_fragment_home));
        fragmentTransaction.commit();
    }

    private void firstTimeLogin() {

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstTimeLogin = sharedPreferences.getBoolean(PreferenceKeys.FIRST_TIME_LOGIN,true);

        if(isFirstTimeLogin) {
            Log.d(TAG,"First time login");
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage(getString(R.string.first_time_user_message));
            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.d(TAG,"OK clicked");
                    SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
                    sharedPreferencesEditor.putBoolean(PreferenceKeys.FIRST_TIME_LOGIN,false);
                    sharedPreferencesEditor.commit();
                    dialog.dismiss();
                }
            });
            alertDialogBuilder.setIcon(R.drawable.tabian_dating);
            alertDialogBuilder.setTitle(" ");
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    @Override
    public void inflateViewProfileFragment(User user) {
        ViewProfileFragment fragment = new ViewProfileFragment();

        Bundle args = new Bundle();
        args.putParcelable(getString(R.string.intent_user), user);
        fragment.setArguments(args);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_content_frame,fragment,getString(R.string.tag_fragment_view_profile));
        fragmentTransaction.addToBackStack(getString(R.string.tag_fragment_view_profile));
        fragmentTransaction.commit();
    }
}
