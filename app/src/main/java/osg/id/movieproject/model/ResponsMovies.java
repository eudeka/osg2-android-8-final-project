package osg.id.movieproject.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsMovies {

    @SerializedName("page")
    private final int page;

    @SerializedName("total_results")
    private final int totalResults;

    @SerializedName("total_pages")
    private final int totalPages;

    @SerializedName("results")
    private final List<Movies> movies;

    public ResponsMovies(int page, int totalResults, int totalPages, List<Movies> movies) {
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.movies = movies;
    }

    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<Movies> getMovies() {
        return movies;
    }

}
