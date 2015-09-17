package br.com.qpainformatica.dribbble.domain.network;


import br.com.qpainformatica.dribbble.BuildConfig;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.GET;
import retrofit.http.Query;

public class APIClient {

    private static RestAdapter REST_ADAPTER;

    private static void createAdapterIfNeeded() {

        if (REST_ADAPTER == null) {
            REST_ADAPTER = new RestAdapter.Builder()
                    .setEndpoint(BuildConfig.BASE_URL +
                            "v1")

                    .setLogLevel((BuildConfig.DEBUG) ?
                            RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                    .setClient(new OkClient())
                    .build();
        }
    }

    public APIClient() {
        createAdapterIfNeeded();
    }

    public GetShots getShots() {
        return REST_ADAPTER.create(GetShots.class);
    }

    public GetShotDetail getShotDetail() {
        return REST_ADAPTER.create(GetShotDetail.class);
    }


    public interface GetShots {
        @GET("/XXX") void getWith(
                @Query("page") String page,
                Callback<String> callback
        );
    }


    public interface GetShotDetail {
        @GET("/YYY")
        String with(
                @Query("ZZZZ") String shot //TODO change this
        );
    }

}