package com.exercise.zhufangda.androidexercise.dagger2;

import javax.inject.Inject;

public class Repository {

    private final WebService webService;
    private final DBService dbService;

    @Inject
    public Repository(WebService webService, DBService dbService) {
        this.webService = webService;
        this.dbService = dbService;
    }


}


