package com.exercise.zhufangda.androidexercise.dagger2;

import javax.inject.Inject;

class DBService {

    @Inject
    public DBService(){
        System.out.println("DBService is create.");
    }
}
