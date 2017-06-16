package de.larsgrammel.gwtbenchmark.client;

import gwt.interop.utils.shared.collections.StringMap;
import gwt.interop.utils.shared.collections.StringMap.ForEachFn;

public class JioStringMapForEachBenchmark extends JioStringMapIteratorBenchmark
{
    public JioStringMapForEachBenchmark( int size )
    {
        super( size );
    }
    
    @Override
    public void run()
    {
        stringMap.forEach( new ForEachFn<Integer>()
        {
            
            @Override
            public void forEach( Integer value, String key, StringMap<Integer> map )
            {
                value.intValue();
                key.length();
            }
        } );
    }
    
    @Override
    public String toString()
    {
        return "JioStringMap [forEach]"; //$NON-NLS-1$
    }
}
