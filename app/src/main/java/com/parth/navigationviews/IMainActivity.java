package com.parth.navigationviews;


import com.parth.navigationviews.models.Message;
import com.parth.navigationviews.models.User;

/**
 * Created by User on 1/24/2018.
 */

public interface IMainActivity {

    void inflateViewProfileFragment(User user);
    void onMessageSelected(Message message);
}
