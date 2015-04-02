abstract class iProcessBase implements iProcessor
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
    public iProcessor setNext(iProcessor next) {
        this.next = next;
        return this;
    }

    /**
     * transfers the state of this processor to the next in line.
     * also clears the local state.
     */
    @Override
    public void transferState() {
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
        
    };
     
    protected abstract void execute() throws Exception;
    
}

