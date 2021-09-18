package com.hk.loginmvvm.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;
import android.os.UserHandle;

import com.hk.loginmvvm.R;
import com.hk.loginmvvm.databinding.ActivityMainBinding;
import com.hk.loginmvvm.models.UserModel;
import com.hk.loginmvvm.viewModels.UserViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        userViewModel = ViewModelProviders.of(this, new UserViewModelFactory(this, new UserModel())).get(UserViewModel.class);

        binding.setUserModel(userViewModel);



    }

    public class UserViewModelFactory extends ViewModelProvider.NewInstanceFactory {
        private UserModel user;
        private Context context;

        public UserViewModelFactory(MainActivity mainActivity, UserModel user) {
            this.context = mainActivity;
            this.user = user;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T)new UserViewModel(context,user);
        }
    }
}