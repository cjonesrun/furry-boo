import java.util.Map;
import java.util.HashMap;

public abstract class iProcessorBase implements iProcessor
{
    private Map<String, Object> state = new HashMap<String,Object>();
    private iProcessor next;
    
    @Override
    public iProcessor addParameter(String name, Object value) {
        state.put(name, value);
        return this;
    };
    
    @Override
    public Object getParameter(String name) {
        return state.get(name);
    }
    
    @Override
    public String getStringParam(String name) {
        return (String) state.get(name);
    }
	
    @Override
    public Integer getIntegerParam(String name) {
        return (Integer) state.get(name);
    }
	
    @Override
    public iProcessor setNext(iProcessor next) {
        this.next = next;
        return this;
    }

    public Map<String,Object> getState() {
		return this.state;
	}
	
    /**
     * transfers the state of this processor to the next in line.
     * also clears the local state.
     */
	private void transferState() {
        if (next != null)
        {
            for (String key : state.keySet())
                this.next.addParameter(key, state.get(key));
            state.clear();
        }
        
    }

    @Override
    public final void process() throws Exception{
        this.execute();
        
        // send state along to next processor
        this.transferState();
		
		// execute next
		if (next != null)
			this.next.process();
        
    };
     
    protected abstract void execute() throws Exception;
    
}

