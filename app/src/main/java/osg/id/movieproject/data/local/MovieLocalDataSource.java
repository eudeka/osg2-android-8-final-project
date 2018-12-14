package osg.id.movieproject.data.local;

import android.content.Context;

import osg.id.movieproject.data.MovieDataSource;

public class MovieLocalDataSource implements MovieDataSource {

    @Override
    public void getListMovies(Context context, GetListMoviesCallback callBack) {
        MoviesDatabase moviesDatabase = MoviesDatabase.getMoviesDatabase(context);
        if (moviesDatabase.moviesDao().select() != null) {
            callBack.onSuccess(moviesDatabase.moviesDao().select());
        } else {
            callBack.onFailed("no database on local");
        }
    }
}
