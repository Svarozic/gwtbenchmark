package de.larsgrammel.gwtbenchmark.client;

import java.util.HashMap;

public class HashMapAddBenchmark implements Runnable
{
    private final int size;
    
    public HashMapAddBenchmark( int size )
    {
        this.size = size;
    }
    
    @Override
    public void run()
    {
        HashMap<String, Integer> map = new HashMap<>();
        for ( int j = 0; j < size; j++ )
        {
            map.put( Integer.toString( j ), j );
        }
    }
    
    @Override
    public String toString()
    {
        return "HashMapAddBenchmark - add"; //$NON-NLS-1$
    }
}
