package osg.id.movieproject.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "movies")
public class Movies {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private final int id;

    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count")
    private final int voteCount;

    @ColumnInfo(name = "video")
    @SerializedName("video")
    private final boolean video;

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    private final double voteAverage;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    private final String title;

    @ColumnInfo(name = "popularity")
    @SerializedName("popularity")
    private final double popularity;

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    private final String posterPath;

    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    private final String originalLanguage;

    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    private final String originalTitle;

    // @ColumnInfo(name = "genre_ids")
    // @SerializedName("genre_ids")
    // private List<Integer> genreIds;

    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    private final String backdropPath;

    @ColumnInfo(name = "adult")
    @SerializedName("adult")
    private final boolean adult;

    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    private final String overview;

    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    private final String releaseDate;

    public Movies(int id, int voteCount, boolean video, double voteAverage, String title, double popularity, String posterPath, String originalLanguage, String originalTitle, /* List<Integer> genreIds, */ String backdropPath, boolean adult, String overview, String releaseDate) {
        this.id = id;
        this.voteCount = voteCount;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        // this.genreIds = genreIds;
        this.backdropPath = backdropPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public int getId() {
        return id;
    }

    public boolean isVideo() {
        return video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    // public List<Integer> getGenreIds() {
    //     return genreIds;
    // }

    public String getBackdropPath() {
        return backdropPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

}