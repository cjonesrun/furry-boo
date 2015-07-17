package com.jonesberg;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 
 *
 */
public class EnigmaMachine
{
	private Map<String, Rotor> allReflectors = new HashMap<String, Rotor>();
	private Map<String, Rotor> allRotors = new HashMap<String, Rotor>();
	
	private PlugBoard plugBoard;
	private Rotor reflector;
	private Rotor[] rotors;
	
	
    public EnigmaMachine(JSONObject def)
    {
        this.build( def );
    }

    private void build(JSONObject def)
    {
    	// build reflectors
    	JSONArray a = def.getJSONArray("reflectors");
    	
    	for (int i = 0; i<a.length(); i++)
    	{
    		Rotor refl = new Rotor(a.getJSONObject(i).getString("name"), a.getJSONObject(i).getString("wiring"));
    		allReflectors.put(refl.getName(), refl);
    	}
    	//System.out.println("reflectors: " + allReflectors);
    	
    	// build rotors
    	a = def.getJSONArray("rotors");
    	
    	for (int i = 0; i<a.length(); i++)
    	{
    		Rotor rotor = new Rotor(a.getJSONObject(i).getString("name"), a.getJSONObject(i).getString("wiring"), a.getJSONObject(i).getString("notch").toCharArray());
    		allRotors.put(rotor.getName(), rotor);
    	}
    	//System.out.println("rotors: " + allRotors);
    	
    	this.plugBoard = new PlugBoard();
    }

    public void configure(JSONObject j)
    {
        this.reflector = allReflectors.get( j.getString("reflector-setup") );
       
        JSONArray a = j.getJSONArray("rotor-setup");
        this.rotors = new Rotor[a.length()];
        for (int i = 0; i<rotors.length; i++)
        {
        	this.rotors[i] = allRotors.get(a.getJSONObject(i).getString("name"));
        	//this.rotors[i].setStartPos( a.getJSONObject(i).getString("startpos").toCharArray() );
        }
        
        a = j.getJSONArray("plugboard");
        for (int i=0; i<a.length(); i++)
        {
        	char[] plug = a.getJSONObject(i).getString("plug").toCharArray();
        	plugBoard.add(plug[0], plug[1]);        	
        }
        
        System.out.println("reflector: " + this.reflector.getName() + " " + this.reflector.getWiring());
        for (Rotor r : this.rotors)
        	System.out.println("rotor: " + r.getName() + " " + r.getWiring());
        System.out.println( "plugs: " + plugBoard.toString());
        
        
    }
    
    private static final String spacer = "->";
    
    public char encode(char c)
    {
    	StringBuilder sequence = new StringBuilder(""+c).append(spacer);
    	char x = plugBoard.in(c);
    	sequence.append(x).append(spacer);
    	
    	for (int i = 0; i<rotors.length; i++)
    	{
    		x = rotors[i].in(x);
    		sequence.append(x).append(spacer);
    	}
    	
    	x = this.reflector.in(x);
    	sequence.append(x).append(spacer);
    	
    	for (int i = rotors.length-1; i >= 0; i--)
    	{
    		x = rotors[i].in(x);
    		sequence.append(x).append(spacer);
    	}
    	
    	x = plugBoard.in(x);
    	sequence.append(x);
    	
    	System.out.println(sequence.toString());
    	return x;
    }

    public String encode(String s)
    {
        s = this.sanitize(s);
        return s;
    }   

    public char decode(char c)
    {
        return c;
    }

    public String decode(String s)
    {
        return s;
    }

    private String sanitize(String s)
    {
        return s;
    }
}

class PlugBoard
{
	Map<Character, Character> mapIn = new HashMap<Character, Character>();
	
	public void add(char x, char y)
	{
		mapIn.put(x, y);
		mapIn.put(y, x);
	}
	
	public char in(char x)
	{
		return mapIn.get(x) == null ? x : mapIn.get(x);
	}
	
	public String toString()
	{
		StringBuilder s = new StringBuilder("{ ");
		for (Character c : mapIn.keySet())
			s.append(c).append("=").append(mapIn.get(c)).append(" ");
		
		s.append("}");
		return s.toString();
	}
}
