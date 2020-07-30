package com.abora.phoneexplorer.ui.activity.compare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.abora.phoneexplorer.R;
import com.abora.phoneexplorer.databinding.ActivityCompareBinding;
import com.abora.phoneexplorer.model.PhoneResponse;
import com.abora.phoneexplorer.util.Constants;
import com.google.gson.Gson;

import org.json.JSONObject;

public class CompareActivity extends AppCompatActivity {

    PhoneResponse device1;
    PhoneResponse device2;
    ActivityCompareBinding binding;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_compare);

        getData();
    }

    private void getData() {
        gson = new Gson();
        SharedPreferences sharedpreferences = getSharedPreferences(Constants.COMPARE_PREFERENCES, Context.MODE_PRIVATE);
        device1 = gson.fromJson(sharedpreferences.getString(Constants.DEVICE1, "null"), PhoneResponse.class);
        device2 = gson.fromJson(sharedpreferences.getString(Constants.DEVICE2, "null"), PhoneResponse.class);
        setData();
    }

    private void setData() {
        binding.tvPhoneName1.setText(device1.getDeviceName());
        binding.tvPhoneName2.setText(device2.getDeviceName());

        binding.tvPhoneGpu1.setText(device1.getGpu());
        binding.tvPhoneGpu2.setText(device2.getGpu());

        binding.tvPhoneGps1.setText(device1.getGps());
        binding.tvPhoneGps2.setText(device2.getGps());

        binding.tvPhoneSim1.setText(device1.getBatteryC());
        binding.tvPhoneSim2.setText(device2.getBatteryC());

        binding.tvPhoneWeight1.setText(device1.getWeight());
        binding.tvPhoneWeight2.setText(device2.getWeight());
    }
}