package osg.id.movieproject.data;

import java.util.List;

import osg.id.movieproject.data.local.MovieLocalDataSource;
import osg.id.movieproject.data.remote.MovieRemoteDataSource;
import osg.id.movieproject.model.Movies;

public class MovieRepository implements MovieDataSource {

    private MovieRemoteDataSource remoteDataSource;
    private MovieLocalDataSource localDataSource;

    public MovieRepository (MovieRemoteDataSource remoteDataSource, MovieLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public void getListMovies(final GetListMoviesCallback callBack) {
        remoteDataSource.getListMovies(new GetListMoviesCallback() {
            @Override
            public void onSuccess(List<Movies> data) {
                callBack.onSuccess(data);
            }

            @Override
            public void onFailed(String errorMessage) {
                callBack.onFailed(errorMessage);
            }
        });
    }

    @Override
    public void getMoviesDetail(int userId, GetMoviesDetailCallback callback) {

    }
}
