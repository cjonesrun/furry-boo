package com.jonesberg;

import javax.inject.Singleton;

@Singleton
class ChainOne extends iProcessorBase implements iProcessor {
	
	public ChainOne()
	{
		this.setNext(new ProcessorA().setNext(new ProcessorB()));
		this.addParameter("x", "x").addParameter("y","y");

	}
		
	
    @Override
    protected void execute() throws Exception {
		/*System.out.print("i'm executing " + this.getClass().getName());
		System.out.println("my state: " + this.getState().toString());
		System.out.println("adding z to state");*/
		System.out.println(this.toString());
		this.addParameter("z", "zz");
		System.out.println(this.toString());
        
    }
}
