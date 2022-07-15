package KyNV1.fsoft.retrofitdemo.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import KyNV1.fsoft.retrofitdemo.objectojson.Currency;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();


    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://apilayer.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);


    @GET("api/live")
    Call<Currency> convertUstToVnd(
            @Query("access_key") String access_key,
            @Query("currencies") String currencies,
            @Query("source") String source,
            @Query("format") int format
    );


}
