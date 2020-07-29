package com.abora.phoneexplorer.ui.fragment.explore;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.abora.phoneexplorer.model.PhoneResponse;
import com.abora.phoneexplorer.network.APIInterface;
import com.abora.phoneexplorer.network.ApiClient;
import com.abora.phoneexplorer.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExploreViewModel extends ViewModel {

    MutableLiveData<List<PhoneResponse>> phoneResponseMutableLiveData = new MutableLiveData<>();
    private static final String TAG = "MainViewModel";

     void getPhones(int limit) {
        final APIInterface apiService = ApiClient.getClient().create(APIInterface.class);
         Call<List<PhoneResponse>> call = apiService.getPhone(Constants.KEY, Constants.SAMSUNG,limit);
         call.enqueue(new Callback<List<PhoneResponse>>() {
            @Override
            public void onResponse(Call<List<PhoneResponse>> call, Response<List<PhoneResponse>> response) {
                phoneResponseMutableLiveData.setValue(response.body());
            }
            @Override
            public void onFailure(Call<List<PhoneResponse>> call, Throwable t) {
                Log.d(TAG, t.toString());
            }
        });
    }
}