package com.jonesberg;

public class ProcessorA extends iProcessorBase
{
    @Override
    protected void execute() throws Exception {
		System.out.println(this.toString());
		this.addParameter("z", "aaaa");
		System.out.println(this.toString());
        
    }
}
