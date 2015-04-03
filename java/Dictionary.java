import java.util.Map;
import java.util.HashMap;

public class Dictionary {
	public Map<String, iProcessor> map = new HashMap<String, iProcessor>();
	
	public void addProcessor(String name, iProcessor proc) {
		this.map.put(name, proc);
	}
	public iProcessor getProcessor(String name) {
		return this.map.get(name);
	}
}
