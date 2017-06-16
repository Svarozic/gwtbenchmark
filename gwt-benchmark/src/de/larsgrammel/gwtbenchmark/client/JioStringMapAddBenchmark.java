package de.larsgrammel.gwtbenchmark.client;

import gwt.interop.utils.client.collections.JsStringMap;
import gwt.interop.utils.shared.collections.StringMap;

public class JioStringMapAddBenchmark implements Runnable
{
    private final int size;
    
    public JioStringMapAddBenchmark( int size )
    {
        this.size = size;
    }
    
    @Override
    public void run()
    {
        StringMap<Integer> stringMap = JsStringMap.create();
        for ( int j = 0; j < size; j++ )
        {
            stringMap.put( Integer.toString( j ), j );
        }
    }
    
    @Override
    public String toString()
    {
        return "JioStringMap [add]"; //$NON-NLS-1$
    }
}
