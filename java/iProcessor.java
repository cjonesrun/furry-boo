interface iProcessor
{
    public void process() throws Exception;
    
    public iProcessor setNext(iProcessor next);
    public void transferState();
    
    public iProcessor addParameter(String name, Object value);
    public Object getParameter(String name);
    public String getStringParam(String name);
    public Integer getIntegerParam(String name);
}
