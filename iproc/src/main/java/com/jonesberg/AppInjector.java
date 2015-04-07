package com.jonesberg;

import com.google.inject.Guice;
import com.google.inject.AbstractModule;

public class AppInjector extends AbstractModule {
 
    @Override
    protected void configure() {
        //bind the service to implementation class
        bind(iProcessor.class).to(ChainOne.class);
         
    }
 
}