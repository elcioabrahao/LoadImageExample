package br.com.qpainformatica.qpabbb.domain.network;


import br.com.qpainformatica.qpabbb.BuildConfig;
import br.com.qpainformatica.qpabbb.domain.model.Page;
import br.com.qpainformatica.qpabbb.domain.model.Shot;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public class APIClient {

    private static RestAdapter REST_ADAPTER;

    private static void createAdapterIfNeeded() {

        if (REST_ADAPTER == null) {
            REST_ADAPTER = new RestAdapter.Builder()
                    .setEndpoint(BuildConfig.BASE_URL)

                    .setLogLevel((BuildConfig.DEBUG) ?
                            RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                    .setClient(new OkClient())
                    .build();
        }
    }

    public APIClient() {
        createAdapterIfNeeded();
    }

    public RestServices getShots() {
        return REST_ADAPTER.create(RestServices.class);
    }


    public interface RestServices {
        @GET("/shots/popular")
        void getPopularShotsWith(
                @Query("page") int pageNumber,
                Callback<Page> callbackImage
        );

        @GET("/shots/{shot}")
        void getShotDetailWith(
                @Path("shot") long shot,
                Callback<Shot> callbackImageShot
        );
    }


}