public class ProcessorA extends iProcessorBase
{
    @Override
    protected void execute() throws Exception {
		System.out.println("i'm executing " + this.getClass().getName());
		this.addParameter("z", "zz")
;		System.out.println("my state: " + this.getState().toString());
        
    }
}
