package com.jonesberg;

public class ProcessorA extends iProcessorBase
{
    @Override
    protected void execute() throws Exception {
		System.out.println("i'm executing " + this.getClass().getName());
		System.out.println("my state: " + this.getState().toString());
		System.out.println("changing z");
		this.addParameter("z", "aaaa");
		System.out.println("now my state: " + this.getState().toString());
        
    }
}
