package de.larsgrammel.gwtbenchmark.client;

import gwt.interop.utils.client.collections.JsArray;
import gwt.interop.utils.shared.collections.Array;

public class JioArrayIteratorBenchmark implements Runnable
{
    protected final Array<String> array;

    public JioArrayIteratorBenchmark( int size )
    {
        array = JsArray.create();
        for ( int j = 0; j < size; j++ )
        {
            array.push( Integer.toString( j ) );
        }
    }
    
    @Override
    public void run()
    {
        for ( String value : array.asIterable() )
        {
            value.length();
        }
    }
    
    @Override
    public String toString()
    {
        return "JioArray- iterator"; //$NON-NLS-1$
    }
}
