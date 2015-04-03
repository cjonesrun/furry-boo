public class Processor_Test
{
    private static iProcessor processorChain; 

    public static final void main(String[] args)
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
        	dict.getProcessor("one").process();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}