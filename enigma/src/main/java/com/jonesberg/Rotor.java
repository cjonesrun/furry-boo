package com.jonesberg;

public class Rotor
{
	private String name;
	private static final char[] base = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private char[] wiringChars;
	
	private String wiring;
	private char[] notch;
	private int position = 0;
	
    public Rotor( String name, String wiring )
    {
        this( name, wiring, new char[] {} );
    }

    public Rotor( String name, String wiring, char[] notch )
    {   
    	this.notch = notch;
    	this.name = name;
    	this.wiring = wiring;
    	wiringChars = wiring.toCharArray();
    }
    
    public void setStartPos(char x)
    {
    	position = (int) (x - 'A') % base.length;
    }
    
    public char in(char c)
    {
    	// if in notch, move next rotor
    	return wiringChars[ ((int)(c - 'A') + position) % base.length ];
    }
    
    public char out(char c)
    {
    	
    	for (int i = 0; i<wiringChars.length; i++)
    		if (wiringChars[i] == c) 
    			return base[ (int)(c - 'A') - position ];
    }

    
    public String getName() {
		return name;
	}

	public String getWiring() {
		return wiring;
	}

	public char[] getNotch() {
		return notch;
	}

	@Override
	public String toString() 
	{
		return "name: " + name + " wiring: " + wiring + " notch: " + Tools.toString(notch); 
	}
}
