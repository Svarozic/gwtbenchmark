package de.larsgrammel.gwtbenchmark.client;

import gwt.interop.utils.shared.collections.Array.ForEachFn;

public class JioArrayForEachBenchmark extends JioArrayIteratorBenchmark
{
    public JioArrayForEachBenchmark( int size )
    {
        super( size );
    }
    
    @Override
    public void run()
    {
        array.forEachElem( new ForEachFn<String>()
        {
            @Override
            public void exec( String currentValue )
            {
                currentValue.length();
            }
        } );
    }
    
    @Override
    public String toString()
    {
        return "JioArray- forEach"; //$NON-NLS-1$
    }
}
