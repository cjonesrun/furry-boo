public class Processor_Test
{

    private static iProcessor processorChain; 
    
    static {
        // chain of processors ...
        processorChain = new ProcessorA()
            .setNext(new ProcessorB());
    }

    public static final void main(String[] args)
    {
		try
		{
        	// add in initial state
        	processorChain.addParameter("x", "x")
            	.addParameter("y", "y");
        
        	// kick off the processors
        	processorChain.process();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}