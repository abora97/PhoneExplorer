package com.abora.phoneexplorer.ui.fragment.compare;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.abora.phoneexplorer.model.PhoneResponse;
import com.abora.phoneexplorer.network.APIInterface;
import com.abora.phoneexplorer.network.ApiClient;
import com.abora.phoneexplorer.util.Constants;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompareViewModel extends ViewModel {

    MutableLiveData<List<PhoneResponse>> phoneResponseMutableLiveData = new MutableLiveData<>();
    private static final String TAG = "MainViewModel";
    CompositeDisposable compositeDisposable = new CompositeDisposable();

     void getPhones(String deviceName) {

         Single<List<PhoneResponse>> observable = ApiClient.getClient().create(APIInterface.class).searchPhone(Constants.KEY, Constants.SAMSUNG,deviceName)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread());
         compositeDisposable.add(observable.subscribe(o -> phoneResponseMutableLiveData.setValue((o)), e -> Log.d(TAG,  e.toString())));

    }
    @Override
    protected void onCleared() {
        super.onCleared();
        // to clear all Observable Observer connection
        compositeDisposable.clear();
    }
}
