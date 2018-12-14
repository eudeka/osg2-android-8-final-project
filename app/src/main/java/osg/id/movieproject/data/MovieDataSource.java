package osg.id.movieproject.data;

import android.content.Context;

import java.util.List;

import osg.id.movieproject.model.Movies;

public interface MovieDataSource {

    void getListMovies(Context context, GetListMoviesCallback callBack);

    interface GetListMoviesCallback {
        void onSuccess(List<Movies> data);

        void onFailed(String errorMessage);
    }
}