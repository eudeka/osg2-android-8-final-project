package osg.id.movieproject.main;

import osg.id.movieproject.data.MovieRepository;

public class MainPresenter implements MainContract.Presenter {

    private MovieRepository repository;
    private MainContract.View view;

    public MainPresenter (MovieRepository repository, MainContract.View view) {
        this.repository = repository;
        this.view = view;
    }

    @Override
    public void getDataListMovies() {

    }
}
