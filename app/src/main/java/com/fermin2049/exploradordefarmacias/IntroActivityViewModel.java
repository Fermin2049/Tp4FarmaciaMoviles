package com.fermin2049.exploradordefarmacias;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fermin2049.exploradordefarmacias.model.User;

import java.util.ArrayList;
import java.util.List;

public class IntroActivityViewModel extends AndroidViewModel {
    private List<User> userList;

    public IntroActivityViewModel(@NonNull Application application) {
        super(application);
        userList = new ArrayList<>();
        userList.add(new User("admin", "1234"));
        userList.add(new User("user", "password"));
    }

    public void verificationUser(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplication(), "Ingrese Los Campos", Toast.LENGTH_SHORT).show();
        } else {
            boolean found = false;
            for (User user : userList) {
                if (user.getUser().equals(username) && user.getPassword().equals(password)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                Intent intent = new Intent(getApplication(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplication().startActivity(intent);
            } else {
                Toast.makeText(getApplication(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
