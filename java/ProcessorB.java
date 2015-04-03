public class ProcessorB extends iProcessorBase
{
    @Override
    protected void execute() throws Exception {
        System.out.println("i'm executing " + this.getClass().getName());
		System.out.println("my state: " + this.getState().toString());
        
    }
}
