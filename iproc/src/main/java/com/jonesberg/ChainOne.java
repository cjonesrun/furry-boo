package com.jonesberg;

import javax.inject.Singleton;

@Singleton
class ChainOne extends iProcessorBase implements iProcessor {
	
	public ChainOne()
	{
		this.addParameter("x", "x").addParameter("y","y");
		this.setNext(new ProcessorA().setNext(new ProcessorB()));
	}
		
	
    @Override
    protected void execute() throws Exception {
		System.out.println("i'm executing " + this.getClass().getName());
		System.out.println("my state: " + this.getState().toString());
		System.out.println("adding z to state");
		this.addParameter("z", "zz");
		System.out.println("now my state: " + this.getState().toString());
        
    }
}
