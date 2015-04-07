package com.jonesberg;

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

    @Override
    public iProcessor setLast(iProcessor next) {
		iProcessor current = this;
		while (current.getNext() != null)
			current = current.getNext();
		
		current.setNext( this.next );
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
    public final iProcessor process() throws Exception{
        this.execute();
        
        // send state along to next processor
        this.transferState();
		
		// execute next and send back the last proc for access to state
		if (next != null)
			return this.next.process();
		return this;
        
    };
     
    protected abstract void execute() throws Exception;
    
}

