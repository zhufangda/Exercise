package com.exercise.zhufangda.androidexercise.dagger2.di;

import com.exercise.zhufangda.androidexercise.dagger2.Repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppModuleTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void providerHeater() {
        Repository repository= DaggerServiceComponent.create().inject();

    }

}