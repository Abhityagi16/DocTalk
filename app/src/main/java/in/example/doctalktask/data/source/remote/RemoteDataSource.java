package in.example.doctalktask.data.source.remote;

import android.accounts.NetworkErrorException;
import android.provider.ContactsContract;

import java.util.List;

import in.example.doctalktask.data.models.User;
import in.example.doctalktask.data.response.ApiResponse;
import in.example.doctalktask.data.source.DataSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by abhishektyagi on 06/01/18.
 */

public class RemoteDataSource implements DataSource{
    private static final String API_URL = "https://api.github.com/";

    private Retrofit mRetrofit;
    private static RemoteDataSource INSTANCE;

    private RemoteDataSource() {
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(API_URL)
                .build();
    }

    public static RemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource();
        }

        return INSTANCE;

    }

    private interface SearchAPI {
        @GET("search/users")
        Single<ApiResponse> getChat(@Query("q") String name);
    }

    @Override
    public Single<List<User>> getUsers(String name) {
        SearchAPI searchAPI = mRetrofit.create(SearchAPI.class);
        return searchAPI.getChat(name)
                .flatMap(new Function<ApiResponse, SingleSource<List<User>>>() {
                    @Override
                    public SingleSource<List<User>> apply(ApiResponse apiResponse) throws
                            Exception {
                        return Single.just(apiResponse.getItems());
                    }
                });
    }
}
