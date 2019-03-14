package edu.cnm.deepdive.green_print.service;

import android.support.annotation.Nullable;
import edu.cnm.deepdive.green_print.BuildConfig;
import edu.cnm.deepdive.green_print.CC_APIApplication;
import edu.cnm.deepdive.green_print.R;
import edu.cnm.deepdive.green_print.model.entity.CCResponse;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jaxb.JaxbConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

public interface CC_APIWebService {
  @Headers({
      "app_id: " + BuildConfig.APP_ID,
      "app_key: " + BuildConfig.API_KEY
  })
  @GET("coolclimate/footprint")
  Call<CCResponse> get(@QueryMap Map<String, String> mapParam);





  class InstanceHolder {



    private static final CC_APIWebService INSTANCE;

    private static final String API_KEY;
    private static final String APP_ID;



    static {

      CC_APIApplication application = CC_APIApplication.getInstance();

//      Gson gson = new GsonBuilder()
//
//          .excludeFieldsWithoutExposeAnnotation()
//          .create();

      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(application.getApplicationContext().getString(R.string.base_url))
          .addConverterFactory(JaxbConverterFactory.create())
          .build();

      INSTANCE = retrofit.create(CC_APIWebService.class);

      API_KEY = BuildConfig.API_KEY;

      APP_ID = BuildConfig.APP_ID;

    }



  }



  class GetCCAPITask extends BaseFluentAsyncTask<Map, Void, CCResponse, CCResponse> {



    @Nullable

    @Override

    protected CCResponse perform(Map... maps) throws TaskException {

      try {

        Response<CCResponse> response = InstanceHolder.INSTANCE.get(maps[0]).execute();

        if (!response.isSuccessful()) {

          throw new TaskException();

        }

        return response.body();
      } catch (Exception e) {
        throw  new RuntimeException(e);

      }

   }



  }



}
