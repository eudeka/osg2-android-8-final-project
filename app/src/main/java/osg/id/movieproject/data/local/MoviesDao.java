package osg.id.movieproject.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import osg.id.movieproject.model.Movies;

@Dao
public interface MoviesDao {

    @Insert
    void insert(List<Movies> moviesList);

    @Query("SELECT * FROM movies ORDER BY release_date ASC")
    List<Movies> select();

    @Delete
    void delete(Movies movies);

    @Update
    void update(Movies movies);

}
