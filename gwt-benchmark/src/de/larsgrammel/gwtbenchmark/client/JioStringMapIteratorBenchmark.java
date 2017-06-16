package de.larsgrammel.gwtbenchmark.client;

import gwt.interop.utils.client.collections.JsStringMap;
import gwt.interop.utils.shared.collections.StringMap;

public class JioStringMapIteratorBenchmark implements Runnable
{
    protected final StringMap<Integer> stringMap;
    
    public JioStringMapIteratorBenchmark( int size )
    {
        stringMap = JsStringMap.create();
        for ( int j = 0; j < size; j++ )
        {
            stringMap.put( Integer.toString( j ), j );
        }
    }
    
    @Override
    public void run()
    {
        for ( String key : stringMap.keys().asIterable() )
        {
            stringMap.get( key );
        }
        
        for ( Integer value : stringMap.values().asIterable() )
        {
            value.intValue();
        }
    }
    
    @Override
    public String toString()
    {
        return "JioStringMap [iterator]"; //$NON-NLS-1$
    }
}
