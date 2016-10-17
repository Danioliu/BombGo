package com.bombgo.myapplication2.base;

/**
 * Created by zhonghang on 2016/10/4.
 */

public interface IPresenter<T extends IView> {

    public void detachView();

    public void attachView(T view);
}
