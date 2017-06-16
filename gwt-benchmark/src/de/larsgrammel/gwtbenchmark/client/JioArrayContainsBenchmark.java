package de.larsgrammel.gwtbenchmark.client;

import gwt.interop.utils.client.collections.JsArray;
import gwt.interop.utils.shared.collections.Array;

public class JioArrayContainsBenchmark implements Runnable
{
    private final Array<String> array;
    private final int tests;
    
    public JioArrayContainsBenchmark( int size, int tests )
    {
        array = JsArray.create();
        for ( int j = 0; j < size; j++ )
        {
            array.push( Integer.toString( j ) );
        }
        this.tests = tests;
    }
    
    @Override
    public void run()
    {
        for ( int j = 0; j < tests / 2; j++ )
        {
            //            collection.contains(Integer.toString(j));
            array.indexOf( Integer.toString( j ) );
        }
        
        for ( int j = 0; j < tests / 2; j++ )
        {
            //            collection.contains(Integer.toString(j) + "not");
            array.indexOf( Integer.toString( j ) + "not" ); //$NON-NLS-1$
        }
    }
    
    @Override
    public String toString()
    {
        return "JioArray [contains]"; //$NON-NLS-1$
    }
}
