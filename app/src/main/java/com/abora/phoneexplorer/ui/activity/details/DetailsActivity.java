package com.abora.phoneexplorer.ui.activity.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.abora.phoneexplorer.R;
import com.abora.phoneexplorer.databinding.ActivityDetailsBinding;
import com.abora.phoneexplorer.model.PhoneResponse;
import com.abora.phoneexplorer.util.Constants;

public class DetailsActivity extends AppCompatActivity {
    PhoneResponse phoneResponse;
    ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();
        // check bundle
        if (bundle != null) {
            phoneResponse = (PhoneResponse) bundle.getSerializable(Constants.DETAILS_DATA);
            setTitle(phoneResponse.getDeviceName());
            init();
        }

    }

    private void init() {
        binding.tvPhoneGpu.setText(phoneResponse.getGpu());
        binding.tvPhoneCpu.setText(phoneResponse.getCpu());
        binding.tvPhoneAnnounced.setText(phoneResponse.getAnnounced());
        binding.tvPhoneBrand.setText(phoneResponse.getBrand());
        binding.tvPhoneBattery.setText(phoneResponse.getBatteryC());
        binding.tvPhoneStatus.setText(phoneResponse.getStatus());
        binding.tvPhoneTech.setText(phoneResponse.getTechnology());
        binding.tvPhoneWeight.setText(phoneResponse.getWeight());
        binding.tvPhoneCamera.setText(phoneResponse.getSingle());
        binding.tvPhoneBuild.setText(phoneResponse.getBuild());
    }
}