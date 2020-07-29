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
        binding.tvPhoneName.setText(phoneResponse.getDeviceName());
        binding.tvPhoneAnnounced.setText(phoneResponse.getAnnounced());
        binding.tvPhoneBrand.setText(phoneResponse.getBrand());
        binding.tvPhoneStatus.setText(phoneResponse.getStatus());
        binding.tvPhoneTech.setText(phoneResponse.getTechnology());
        binding.tvPhoneWeight.setText(phoneResponse.getWeight());
    }
}