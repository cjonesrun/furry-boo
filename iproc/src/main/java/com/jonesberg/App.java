package com.jonesberg;

import javax.inject.Singleton;
import javax.inject.Inject;
import com.google.inject.AbstractModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App 
{
	@Inject
	iProcessor chain;
	
	public void go() throws Exception
	{
		chain.process();
	}
	
    public static void main( String[] args )
    {
		try
		{
	        System.out.println( "Starting App" );
		
	        Injector injector = Guice.createInjector(new AppInjector());        
	        injector.getInstance(App.class).go();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
    }
}
	
/*@Singleton
class ChainOne implements iProcessor {
    public iProcessor getChain() {
    	iProcessor i = new ProcessorA().setNext(new ProcessorB());
    	i.addParameter("x", "x")
			.addParameter("y", "y");
		return i;
    }
}

class Application {
	@Inject
	ProcessorChain chain;
	
	public void go() throws Exception
	{
		chain.getChain().process();
	}
}

class AppInjector extends AbstractModule {
 
    @Override
    protected void configure() {
        //bind the service to implementation class
        bind(iProcessor.class).to(ChainOne.class);
         
    }
 
}*/