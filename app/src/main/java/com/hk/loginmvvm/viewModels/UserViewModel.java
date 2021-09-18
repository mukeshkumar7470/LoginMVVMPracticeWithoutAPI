package com.hk.loginmvvm.viewModels;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hk.loginmvvm.models.UserModel;

public class UserViewModel extends ViewModel {
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    public UserModel userModel;
    public Context context;

    public UserViewModel(Context context, UserModel userModel) {
        this.userModel = userModel;
        this.context = context;
    }

    public void onSubmitClick() {
        userModel.setEmail(email.getValue());
        userModel.setPassword(password.getValue());
        if (userModel.isValid()) {
            Toast.makeText(context, userModel.getEmail(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "please enter valid email", Toast.LENGTH_LONG).show();

        }
    }

}
