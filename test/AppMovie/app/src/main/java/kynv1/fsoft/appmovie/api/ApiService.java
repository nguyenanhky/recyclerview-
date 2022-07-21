package kynv1.fsoft.appmovie.api;

import kynv1.fsoft.appmovie.model.Popular;
import kynv1.fsoft.appmovie.utls.Constance;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {

    ApiService apiService = new Retrofit.Builder()
            .baseUrl(Constance.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);

    @GET(Constance.KEY_MOVIE)
    Call<Popular>getPopularMovies();
}
