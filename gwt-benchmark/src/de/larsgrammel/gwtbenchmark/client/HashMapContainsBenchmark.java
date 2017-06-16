package de.larsgrammel.gwtbenchmark.client;

import java.util.HashMap;
import java.util.Map;

public class HashMapContainsBenchmark implements Runnable
{
    private final Map<String, Integer> map;
    private final int tests;
    
    public HashMapContainsBenchmark( int size, int tests )
    {
        this.tests = tests;
        this.map = new HashMap<>();
        for ( int j = 0; j < size; j++ )
        {
            map.put( Integer.toString( j ), j );
        }
    }
    
    @Override
    public void run()
    {
        for ( int j = 0; j < tests / 2; j++ )
        {
            map.containsKey( Integer.toString( j ) );
            map.containsValue( j );
        }
        
        for ( int j = 0; j < tests / 2; j++ )
        {
            map.containsKey( Integer.toString( j ) + "not" ); //$NON-NLS-1$
            map.containsValue( -1 - j );
        }
    }
    
    @Override
    public String toString()
    {
        return "HashMap - contains"; //$NON-NLS-1$
    }
}
