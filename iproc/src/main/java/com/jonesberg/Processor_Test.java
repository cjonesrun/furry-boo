package com.jonesberg;

import javax.inject.Singleton;
import javax.inject.Inject;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Processor_Test
{
    private static iProcessor processorChain; 

/*	public static void main(String[] args) {
		        Injector injector = Guice.createInjector(new AppInjector());        
         
		        Application app = injector.getInstance(Application.class);
         

		    }*/
	
    public static final void main_old(String[] args)
    {
		try
		{

	        processorChain = new ProcessorA()
	            .setNext(new ProcessorB());
						
        	// add in initial state
        	processorChain.addParameter("x", "x")
            	.addParameter("y", "y");

			Dictionary dict = new Dictionary();
			dict.addProcessor("one", processorChain);
        
        	// kick off the processors
        	iProcessor finalProc = dict.getProcessor("one").process();
			System.out.println( finalProc.getClass().getSimpleName() + " " + finalProc.getParameter("z"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	
}