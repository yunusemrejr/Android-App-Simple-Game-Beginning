package com.example.general;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Toast;

import com.example.general.databinding.ActivityMain2Binding;
import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "GeneralRadarStats";
    private static final String KEY_TOTAL_MISSIONS = "total_missions";
    private static final String KEY_VICTORIES = "victories";
    private static final String KEY_DEFEATS = "defeats";
    
    private int totalMissions = 0;
    private int victories = 0;
    private int defeats = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        
        loadStatistics();
        setupAnimations();
        setupClickListeners();
        updateStatisticsDisplay();
    }
    
    private void setupAnimations() {
        binding.missionCard.setAlpha(0f);
        binding.inputCard.setAlpha(0f);
        binding.resultCard.setAlpha(0f);
        binding.statsCard.setAlpha(0f);
        
        binding.missionCard.animate()
                .alpha(1f)
                .setDuration(600)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();
        
        binding.inputCard.animate()
                .alpha(1f)
                .setDuration(600)
                .setStartDelay(200)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();
        
        binding.resultCard.animate()
                .alpha(1f)
                .setDuration(600)
                .setStartDelay(400)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();
        
        binding.statsCard.animate()
                .alpha(1f)
                .setDuration(600)
                .setStartDelay(600)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();
    }
    
    private void setupClickListeners() {
        binding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateMissionOutcome();
            }
        });
        
        binding.resetStatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetStatistics();
            }
        });
    }
    
    private void calculateMissionOutcome() {
        String inputText = binding.inputNumber.getText().toString().trim();
        
        if (inputText.isEmpty()) {
            binding.inputLayout.setError(getString(R.string.error_empty_input));
            Snackbar.make(binding.getRoot(), R.string.error_empty_input, Snackbar.LENGTH_SHORT).show();
            return;
        }
        
        binding.inputLayout.setError(null);
        
        try {
            int enemyBatCount = Integer.parseInt(inputText);
            
            if (enemyBatCount < 0) {
                binding.inputLayout.setError(getString(R.string.error_invalid_input));
                Snackbar.make(binding.getRoot(), R.string.error_invalid_input, Snackbar.LENGTH_SHORT).show();
                return;
            }
            
            boolean isVictory = enemyBatCount >= 10;
            
            totalMissions++;
            if (isVictory) {
                victories++;
            } else {
                defeats++;
            }
            
            saveStatistics();
            updateStatisticsDisplay();
            displayResult(isVictory);
            
        } catch (NumberFormatException e) {
            binding.inputLayout.setError(getString(R.string.error_invalid_input));
            Snackbar.make(binding.getRoot(), R.string.error_invalid_input, Snackbar.LENGTH_SHORT).show();
        }
    }
    
    private void displayResult(boolean isVictory) {
        String resultMessage;
        int textColor;
        int backgroundColor;
        
        if (isVictory) {
            resultMessage = getString(R.string.result_win);
            textColor = ContextCompat.getColor(this, R.color.success_green);
            backgroundColor = Color.parseColor("#E8F5E9");
        } else {
            resultMessage = getString(R.string.result_lose);
            textColor = ContextCompat.getColor(this, R.color.warning_red);
            backgroundColor = Color.parseColor("#FFEBEE");
        }
        
        binding.resultText.setText(resultMessage);
        binding.resultText.setTextColor(textColor);
        binding.resultText.setBackgroundColor(backgroundColor);
        
        binding.resultText.setScaleX(0f);
        binding.resultText.setScaleY(0f);
        binding.resultText.animate()
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(500)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();
        
        ObjectAnimator pulseAnimator = ObjectAnimator.ofFloat(binding.resultText, "alpha", 1f, 0.7f, 1f);
        pulseAnimator.setDuration(1000);
        pulseAnimator.setRepeatCount(2);
        pulseAnimator.start();
    }
    
    private void loadStatistics() {
        totalMissions = sharedPreferences.getInt(KEY_TOTAL_MISSIONS, 0);
        victories = sharedPreferences.getInt(KEY_VICTORIES, 0);
        defeats = sharedPreferences.getInt(KEY_DEFEATS, 0);
    }
    
    private void saveStatistics() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_TOTAL_MISSIONS, totalMissions);
        editor.putInt(KEY_VICTORIES, victories);
        editor.putInt(KEY_DEFEATS, defeats);
        editor.apply();
    }
    
    private void updateStatisticsDisplay() {
        binding.totalMissions.setText(String.valueOf(totalMissions));
        binding.victories.setText(String.valueOf(victories));
        binding.defeats.setText(String.valueOf(defeats));
        
        double winRate = totalMissions > 0 ? (victories * 100.0 / totalMissions) : 0;
        binding.winRate.setText(String.format(Locale.getDefault(), "%.1f%%", winRate));
    }
    
    private void resetStatistics() {
        totalMissions = 0;
        victories = 0;
        defeats = 0;
        
        saveStatistics();
        updateStatisticsDisplay();
        
        binding.resultText.setText(getString(R.string.result_placeholder));
        binding.resultText.setTextColor(ContextCompat.getColor(this, R.color.md_theme_light_onSurfaceVariant));
        binding.resultText.setBackgroundColor(Color.TRANSPARENT);
        
        Snackbar.make(binding.getRoot(), R.string.stats_reset_message, Snackbar.LENGTH_SHORT).show();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}

