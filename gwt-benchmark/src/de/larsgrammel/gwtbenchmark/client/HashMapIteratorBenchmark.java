package de.larsgrammel.gwtbenchmark.client;

import java.util.HashMap;
import java.util.Map;

public class HashMapIteratorBenchmark implements Runnable
{
    protected final Map<String, Integer> map;
    
    public HashMapIteratorBenchmark( int size )
    {
        this.map = new HashMap<>();
        for ( int j = 0; j < size; j++ )
        {
            map.put( Integer.toString( j ), j );
        }
    }
    
    @Override
    public void run()
    {
        for ( String key : map.keySet() )
        {
            map.get( key );
        }
        
        for ( Integer value : map.values() )
        {
            value.intValue();
        }
    }
    
    @Override
    public String toString()
    {
        return "HashMap - iterator"; //$NON-NLS-1$
    }
}
