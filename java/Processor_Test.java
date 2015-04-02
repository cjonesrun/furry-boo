public class Processor_Test
{

    private static iProcessor processorChain; 
    
    static {
        // chain of processors ...
        processorChain = new Processor1()
            .setNext(new Processor2());
    }

    public static final void main(String[] args)
    {
        processorChain.addParameter(x,y);
        // add in initial state
        processorChain.addParameter("x", "x")
            .addParameter("y", "y");
        
        // kick off the processors
        processorChain.process();
    }
