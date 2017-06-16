package de.larsgrammel.gwtbenchmark.client;

import java.util.Map.Entry;

public class HashMapEntrySetBenchmark extends HashMapIteratorBenchmark
{
    public HashMapEntrySetBenchmark( int size )
    {
        super( size );
    }
    
    @Override
    public void run()
    {
        for ( Entry<String, Integer> entry : map.entrySet() )
        {
            entry.getKey();
            entry.getValue();
        }
    }
    
    @Override
    public String toString()
    {
        return "HashMap - entrySet"; //$NON-NLS-1$
    }
}
