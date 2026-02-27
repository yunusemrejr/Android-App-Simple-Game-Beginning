package com.example.general;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.example.general.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    
    private ActivityMainBinding binding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        setupAnimations();
        setupClickListeners();
    }
    
    private void setupAnimations() {
        binding.welcomeCard.setAlpha(0f);
        binding.radarImage.setAlpha(0f);
        binding.startButton.setAlpha(0f);
        
        binding.welcomeCard.animate()
                .alpha(1f)
                .setDuration(800)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();
        
        binding.radarImage.animate()
                .alpha(1f)
                .setDuration(1000)
                .setStartDelay(300)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();
        
        binding.startButton.animate()
                .alpha(1f)
                .setDuration(800)
                .setStartDelay(600)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();
        
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(binding.radarImage, "rotation", 0f, 360f);
        rotationAnimator.setDuration(3000);
        rotationAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        rotationAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        rotationAnimator.start();
    }
    
    private void setupClickListeners() {
        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.startButton.animate()
                        .scaleX(0.9f)
                        .scaleY(0.9f)
                        .setDuration(100)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                binding.startButton.animate()
                                        .scaleX(1f)
                                        .scaleY(1f)
                                        .setDuration(100)
                                        .withEndAction(new Runnable() {
                                            @Override
                                            public void run() {
                                                switchToMainActivity2();
                                            }
                                        })
                                        .start();
                            }
                        })
                        .start();
            }
        });
    }
    
    private void switchToMainActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
