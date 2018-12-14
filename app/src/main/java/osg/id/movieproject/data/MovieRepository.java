package osg.id.movieproject.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.util.List;

import osg.id.movieproject.data.local.MovieLocalDataSource;
import osg.id.movieproject.data.local.MoviesDatabase;
import osg.id.movieproject.data.remote.MovieRemoteDataSource;
import osg.id.movieproject.model.Movies;

public class MovieRepository implements MovieDataSource {

    private final MovieRemoteDataSource remoteDataSource;
    private final MovieLocalDataSource localDataSource;
    private MoviesDatabase moviesDatabase;

    public MovieRepository(MovieRemoteDataSource remoteDataSource, MovieLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public void getListMovies(Context context, final GetListMoviesCallback callBack) {
        NetworkInfo info = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        moviesDatabase = MoviesDatabase.getMoviesDatabase(context);
        if (moviesDatabase.moviesDao().select().size() != 0) {
            Toast.makeText(context, "use database local", Toast.LENGTH_SHORT).show();
            localDataSource.getListMovies(context, new GetListMoviesCallback() {
                @Override
                public void onSuccess(List<Movies> data) {
                    callBack.onSuccess(data);
                }

                @Override
                public void onFailed(String errorMessage) {
                    callBack.onFailed(errorMessage);
                }
            });
        } else if (info != null && info.isConnected()) {
            Toast.makeText(context, "use database cloud", Toast.LENGTH_SHORT).show();
            remoteDataSource.getListMovies(context, new GetListMoviesCallback() {
                @Override
                public void onSuccess(List<Movies> data) {
                    callBack.onSuccess(data);
                    moviesDatabase.moviesDao().insert(data);
                }

                @Override
                public void onFailed(String errorMessage) {
                    callBack.onFailed(errorMessage);
                }
            });
        } else {
            callBack.onSuccess(null);
            callBack.onFailed("");
        }
    }
}
