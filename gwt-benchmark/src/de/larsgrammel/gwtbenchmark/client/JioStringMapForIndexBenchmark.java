package de.larsgrammel.gwtbenchmark.client;

import gwt.interop.utils.shared.collections.Array;

public class JioStringMapForIndexBenchmark extends JioStringMapIteratorBenchmark
{
    
    public JioStringMapForIndexBenchmark( int size )
    {
        super( size );
    }
    
    @Override
    public void run()
    {
        Array<String> keys = stringMap.keys();
        for ( int i = 0, iLength = keys.getLength(); i < iLength; i++ )
        {
            stringMap.get( keys.get( i ) );
        }
        
        Array<Integer> values = stringMap.values();
        for ( int j = 0, jLength = values.getLength(); j < jLength; j++ )
        {
            values.get( j ).intValue();
        }
    }
    
    @Override
    public String toString()
    {
        return "JioStringMap [forIndex]"; //$NON-NLS-1$
    }
}
