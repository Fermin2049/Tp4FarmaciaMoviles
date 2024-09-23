package com.fermin2049.exploradordefarmacias;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.fermin2049.exploradordefarmacias.databinding.ActivityIntroBinding;

public class IntroActivity extends AppCompatActivity {
    private ActivityIntroBinding binding;
    private IntroActivityViewModel viewModelMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModelMain = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(IntroActivityViewModel.class);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = binding.username.getText().toString();
                String word2 = binding.password.getText().toString();
                viewModelMain.verificationUser(word, word2);
            }
        });

    }
}