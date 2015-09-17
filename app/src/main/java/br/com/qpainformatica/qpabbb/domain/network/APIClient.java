package br.com.qpainformatica.qpabbb.domain.network;



import org.json.JSONObject;

import br.com.qpainformatica.qpabbb.BuildConfig;
import br.com.qpainformatica.qpabbb.domain.model.Page;
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

    public GetPopularShots getShots() {
        return REST_ADAPTER.create(GetPopularShots.class);
    }

    public GetShotDetail getShotDetail() {
        return REST_ADAPTER.create(GetShotDetail.class);
    }


    public interface GetPopularShots {
        @GET("/shots/popular")
        Page getWith(
                @Query("page") int pageNumber
        );
    }


    public interface GetShotDetail {
        @GET("/shots/{shot}")
        JSONObject getWith(
                @Path("shot") String shot
        );
    }

}