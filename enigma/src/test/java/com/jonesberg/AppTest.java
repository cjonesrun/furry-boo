package com.jonesberg;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.io.FileInputStream;
import java.io.StringWriter;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        try
        {
            StringWriter writer = new StringWriter();
            IOUtils.copy( new FileInputStream("./config.json") , writer);
            JSONObject config = new JSONObject( writer.toString() );
            writer.flush();
            
            writer = new StringWriter();
            IOUtils.copy( new FileInputStream("./defs.json") , writer);
            JSONObject def = new JSONObject( writer.toString() );
            writer.flush();

            EnigmaMachine e = new EnigmaMachine( def );
            e.configure( config );

            System.out.println("encoding char 'A' to: " + e.encode('A'));
            System.out.println("encoding String 'abcd' to: " + e.encode("abcd"));
        
            
            System.out.println( "a=" + (int)'a' );
            System.out.println( "z=" + (int)'z' );
            System.out.println( "A=" + (int)'A' );
            System.out.println( "Z=" + (int)'Z' );
            
            System.out.println( 'c' > 'b' );

            assertTrue( true );
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
