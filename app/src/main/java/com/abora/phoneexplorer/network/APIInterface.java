package com.abora.phoneexplorer.network;


import com.abora.phoneexplorer.model.PhoneResponse;
import com.abora.phoneexplorer.util.Constants;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    //this interface is using special retrofit annotations to encode the parameters and request method

    //https://fonoapi.freshpixl.com/v1/getlatest?token=5a437bd80ea753b2706facbebe872d1fb800218bee8903f1&brand=Samsung&limit=1

    @GET(Constants.GET_LATEST)
    Single<List<PhoneResponse>> getPhone(@Query(Constants.TOKEN) String apiKey, @Query(Constants.BRAND) String brand, @Query(Constants.LIMIT) int limit);


    //https://fonoapi.freshpixl.com/v1/getdevice?token=5a437bd80ea753b2706facbebe872d1fb800218bee8903f1&brand=Samsung&device=a70

    @GET(Constants.GET_DEVICE)
    Single<List<PhoneResponse>> searchPhone(@Query(Constants.TOKEN) String apiKey, @Query(Constants.BRAND) String brand, @Query(Constants.DEVICE) String device);

}
