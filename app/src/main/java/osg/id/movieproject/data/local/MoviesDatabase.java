package osg.id.movieproject.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import osg.id.movieproject.model.Movies;

@Database(entities = Movies.class, version = 1)
public abstract class MoviesDatabase extends RoomDatabase {

    public abstract MoviesDao moviesDao();

    private static MoviesDatabase moviesDatabase;

    public static MoviesDatabase getMoviesDatabase(Context context) {
        synchronized (MoviesDatabase.class) {
            if (moviesDatabase == null) {
                moviesDatabase = Room.databaseBuilder(context, MoviesDatabase.class, "db_movies").allowMainThreadQueries().build();
            }
        }
        return moviesDatabase;
    }
}
