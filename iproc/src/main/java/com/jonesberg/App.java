package com.jonesberg;

import javax.inject.Singleton;
import javax.inject.Inject;
import com.google.inject.AbstractModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App 
{
	public static void main( String[] args )
    {
		try
		{
	        System.out.println( "Starting App" );
		
	        Injector injector = Guice.createInjector(new AppInjector());        
	        iProcessor p = injector.getInstance(iProcessor.class);
			p.process();
			
			Temp t = new Temp();
			t.go();		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
    }
}
class Temp
{
	iProcessor chain;
	
	@Inject
    public void setProcessor(iProcessor svc){
        this.chain=svc;
    }
	
	public void go() throws Exception
	{
		chain.process();
	}
}