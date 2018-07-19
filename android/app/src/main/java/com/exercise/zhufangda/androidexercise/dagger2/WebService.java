package com.exercise.zhufangda.androidexercise.dagger2;

import javax.inject.Inject;

class WebService {

    @Inject
    public WebService(){
        System.out.print("WebService is create.");
    }
}
