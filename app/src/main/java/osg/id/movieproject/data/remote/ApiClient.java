package osg.id.movieproject.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

//    private static Retrofit retrofit = null;
//
//    public static Retrofit getClient() {
//        retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.themoviedb.org/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        return retrofit;
//    }

    private  static  final String base_url = "https://api.themoviedb.org/";

    private static Retrofit retrofit = null;
    public static Retrofit getClient(){

        //start converter json
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …

        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                //tambahkan converterFactory
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();
        return retrofit;
    }

}