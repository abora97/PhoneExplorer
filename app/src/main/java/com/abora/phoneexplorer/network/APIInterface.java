package com.abora.phoneexplorer.network;


import com.abora.phoneexplorer.model.PhoneResponse;
import com.abora.phoneexplorer.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    //this interface is using special retrofit annotations to encode the parameters and request method

    //https://fonoapi.freshpixl.com/v1/getlatest?token=5a437bd80ea753b2706facbebe872d1fb800218bee8903f1&brand=Samsung&limit=1

    @GET(Constants.GET_LATEST)
    Call<List<PhoneResponse>> getPhone(@Query(Constants.TOKEN) String apiKey, @Query(Constants.BRAND) String brand);


}
