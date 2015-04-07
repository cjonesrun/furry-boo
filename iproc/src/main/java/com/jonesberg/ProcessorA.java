package com.jonesberg;

public class ProcessorA extends iProcessorBase
{
    @Override
    protected void execute() throws Exception {
		System.out.println("i'm executing " + this.getClass().getName());
		System.out.println("my state: " + this.getState().toString());
		System.out.println("adding z to state");
		this.addParameter("z", "zz");
		System.out.println("now my state: " + this.getState().toString());
        
    }
}
