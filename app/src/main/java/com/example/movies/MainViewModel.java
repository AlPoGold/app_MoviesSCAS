package com.example.movies;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movies.Elements.Movie;
import com.example.movies.Elements.MovieResponse;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {
    public final String TAG = "MainViewModel";

    private MutableLiveData<List<Movie>> movies = new MutableLiveData<List<Movie>>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public LiveData<List<Movie>> getMovies() {
        return movies;
    }


    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadMovies(){

        Disposable disposable = ApiFactory.apiService.loadMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MovieResponse>() {
                    @Override
                    public void accept(MovieResponse movieResponse) throws Throwable {
                        movies.setValue(movieResponse.getMovies());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {

                        Log.d(TAG, throwable.toString());

                    }
                });

        compositeDisposable.add(disposable);

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
