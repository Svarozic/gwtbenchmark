package de.larsgrammel.gwtbenchmark.client;

import gwt.interop.utils.client.collections.JsStringMap;
import gwt.interop.utils.shared.collections.StringMap;

public class JioStringMapContainsBenchmark implements Runnable
{
    private final StringMap<Integer> stringMap;
    private final int tests;
    
    public JioStringMapContainsBenchmark( int size, int tests )
    {
        this.tests = tests;
        this.stringMap = JsStringMap.create();
        for ( int j = 0; j < size; j++ )
        {
            stringMap.put( Integer.toString( j ), j );
        }
    }
    
    @Override
    public void run()
    {
        for ( int j = 0; j < tests / 2; j++ )
        {
            stringMap.hasKey( Integer.toString( j ) );
            stringMap.values().indexOf( j );
        }
        
        for ( int j = 0; j < tests / 2; j++ )
        {
            stringMap.hasKey( Integer.toString( j ) + "not" ); //$NON-NLS-1$
            stringMap.values().indexOf( -1 - j );
        }
    }
    
    @Override
    public String toString()
    {
        return "JioStringMap [contains]"; //$NON-NLS-1$
    }
}
