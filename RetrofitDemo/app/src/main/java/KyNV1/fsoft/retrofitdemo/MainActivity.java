package KyNV1.fsoft.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import KyNV1.fsoft.retrofitdemo.api.ApiService;
import KyNV1.fsoft.retrofitdemo.databinding.ActivityMainBinding;
import KyNV1.fsoft.retrofitdemo.objectojson.Currency;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createObjectToJson();

        CreateJsonToObject();

    }

    private void CreateJsonToObject() {
        binding.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCallApi();
            }
        });
    }

    private void clickCallApi() {
        ApiService.apiService.convertUstToVnd("843d4d34ae72b3882e3db642c51e28e6", "VND", "USD", 1)
                .enqueue(new Callback<Currency>() {
                    @Override
                    public void onResponse(Call<Currency> call, Response<Currency> response) {
                        Log.d(TAG, "onResponse: ");
                        Currency currency  = response.body();
                        Log.d(TAG, "Currency : "+currency.getSource());
                        binding.txtTerm.setText(currency.getTerms());
                        binding.txtSource.setText(currency.getSource());
                        binding.txtUsdVnd.setText(currency.getQuotes().getUSDVND()+"");
                    }

                    @Override
                    public void onFailure(Call<Currency> call, Throwable t) {
                        Log.d(TAG, "onFailure: ");
                    }
                });

    }

    private void createObjectToJson() {
        Job job = new Job(1, "Coder");
        List<Favorite> favorites = new ArrayList<>();
        favorites.add(new Favorite(1, "Music"));
        favorites.add(new Favorite(2, "Read book"));

        User user = new User(1, "Tincoder", true, job, favorites);
        Gson gson = new Gson();

        String strJson = gson.toJson(user);
        Log.e(TAG, "onCreate: " + strJson);
    }
}