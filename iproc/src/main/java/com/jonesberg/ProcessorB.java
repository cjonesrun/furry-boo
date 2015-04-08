package com.jonesberg;

public class ProcessorB extends iProcessorBase
{
    @Override
    protected void execute() throws Exception {
		System.out.println(this.toString());
		this.addParameter("w", "bbbbb");
		System.out.println(this.toString());
        
    }
}
