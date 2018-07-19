package com.exercise.zhufangda.androidexercise.dagger2.di;

import com.exercise.zhufangda.androidexercise.dagger2.Repository;

import dagger.Component;

@Component
public interface ServiceComponent {
    public Repository inject();
}
