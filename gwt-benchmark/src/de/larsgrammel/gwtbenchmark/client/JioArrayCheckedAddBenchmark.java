//
/////////////////////////////////////////////////////////////////
//                 C O P Y R I G H T  (c) 2017                 //
//    A G F A   H E A L T H C A R E   C O R P O R A T I O N    //
//                    All Rights Reserved                      //
/////////////////////////////////////////////////////////////////
//
//        THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
//                      AGFA CORPORATION
//       The copyright notice above does not evidence any
//      actual or intended publication of such source code.
//
/////////////////////////////////////////////////////////////////
//

package de.larsgrammel.gwtbenchmark.client;

import gwt.interop.utils.client.collections.JsArray;
import gwt.interop.utils.shared.collections.Array;

/**
 * @author Peter Petranik (apuhu) <peter.petranik@agfa.com>
 *
 */
public class JioArrayCheckedAddBenchmark extends JioArrayAddBenchmark
{
    
    public JioArrayCheckedAddBenchmark( int size )
    {
        super( size );
    }
    
    @Override
    public void run()
    {
        Array<String> array = JsArray.create();
        for ( int j = 0; j < size; j++ )
        {
            String value = Integer.toString( j );
            // simulate Set restriction for duplicates
            if ( !array.contains( value ) )
            {
                array.push( value );
            }
        }
    }
    
    @Override
    public String toString()
    {
        return "JioArray [checkedAdd]"; //$NON-NLS-1$
    }
}
