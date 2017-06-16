package de.larsgrammel.gwtbenchmark.client;

import gwt.interop.utils.client.collections.JsArray;
import gwt.interop.utils.shared.collections.Array;

public class JioArrayAddBenchmark implements Runnable
{
    private final int size;
    
    public JioArrayAddBenchmark( int size )
    {
        this.size = size;
    }
    
    @Override
    public void run()
    {
        Array<String> array = JsArray.create();
        for ( int j = 0; j < size; j++ )
        {
            array.push( Integer.toString( j ) );
        }
    }
    
    @Override
    public String toString()
    {
        return "JioArray - add"; //$NON-NLS-1$
    }
}
