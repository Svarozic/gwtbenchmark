package de.larsgrammel.gwtbenchmark.client;

public class JioArrayForIndexBenchmark extends JioArrayIteratorBenchmark
{
    
    public JioArrayForIndexBenchmark( int size )
    {
        super( size );
    }
    
    @Override
    public void run()
    {
        for ( int i = 0, iLength = array.getLength(); i < iLength; i++ )
        {
            array.get( i ).length();
        }
    }
    
    @Override
    public String toString()
    {
        return "JioArray [forIndex]"; //$NON-NLS-1$
    }
}
