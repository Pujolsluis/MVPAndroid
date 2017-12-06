package com.example.devs.mvplogin;

/**
 * Created by devs on 8/25/17.
 */

public interface BasePresenter<T>{

    void start();

    /**
     * Binds presenter with a view when resumed. The Presenter will perform initialization here.
     *
     * @param view the view associated with this presenter
     */
    void takeView(T view);

    /**
     * Drops the reference to the view when destroyed
     */
    void dropView();

}
