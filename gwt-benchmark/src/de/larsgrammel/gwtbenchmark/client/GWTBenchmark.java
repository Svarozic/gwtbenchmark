/*
 *   Copyright 2010 Lars Grammel
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *   
 */
package de.larsgrammel.gwtbenchmark.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GWTBenchmark implements EntryPoint
{
    
    @Override
    public void onModuleLoad()
    {
        int collectionSize = 100;
        int containsTests = 20;
        
        Panel parentPanel = new VerticalPanel();
        RootPanel.get().add( parentPanel );
        
        Panel arrayPanel = new HorizontalPanel();
        parentPanel.add( arrayPanel );
        
        addBenchmark( new ArrayListAddBenchmark( collectionSize ), arrayPanel );
        addBenchmark( new HashSetAddBenchmark( collectionSize ), arrayPanel );
        addBenchmark( new JsArrayAddBenchmark( collectionSize ), arrayPanel );
        addBenchmark( new JioArrayAddBenchmark( collectionSize ), arrayPanel );
        
        addBenchmark( new ArrayListIteratorBenchmark( collectionSize ), arrayPanel );
        addBenchmark( new HashSetIteratorBenchmark( collectionSize ), arrayPanel );
        addBenchmark( new JioArrayIteratorBenchmark( collectionSize ), arrayPanel );
        addBenchmark( new JioArrayForEachBenchmark( collectionSize ), arrayPanel );
        
        addBenchmark( new ArrayListContainsBenchmark( collectionSize, containsTests ), arrayPanel );
        addBenchmark( new HashSetContainsBenchmark( collectionSize, containsTests ), arrayPanel );
        addBenchmark( new JsArrayContainsBenchmark( collectionSize, containsTests ), arrayPanel );
        addBenchmark( new JioArrayContainsBenchmark( collectionSize, containsTests ), arrayPanel );
        
        Panel mapPanel = new HorizontalPanel();
        parentPanel.add( mapPanel );
        
        addBenchmark( new HashMapAddBenchmark( collectionSize ), mapPanel );
        addBenchmark( new JioStringMapAddBenchmark( collectionSize ), mapPanel );
        
        addBenchmark( new HashMapIteratorBenchmark( collectionSize ), mapPanel );
        addBenchmark( new JioStringMapIteratorBenchmark( collectionSize ), mapPanel );
        addBenchmark( new HashMapEntrySetBenchmark( collectionSize ), mapPanel );
        addBenchmark( new JioStringMapForEachBenchmark( collectionSize ), mapPanel );
        
        addBenchmark( new HashMapContainsBenchmark( collectionSize, containsTests ), mapPanel );
        addBenchmark( new JioStringMapContainsBenchmark( collectionSize, containsTests ), mapPanel );
        
    }
    
    private void addBenchmark( final Runnable benchmark, Panel parentPanel )
    {
        VerticalPanel panel = new VerticalPanel();
        
        final ListBox list = new ListBox();
        list.setVisibleItemCount( 20 );
        
        Button button = new Button( benchmark.toString(), new ClickHandler()
        {
            @Override
            public void onClick( ClickEvent event )
            {
                list.addItem( "" + runBenchmark( benchmark, 2500 ) );
            }
        } );
        
        panel.add( button );
        panel.add( list );
        
        parentPanel.add( panel );
    }
    
    private long runBenchmark( Runnable benchmark, int iterations )
    {
        long startTime = System.currentTimeMillis();
        
        for ( int i = 0; i < iterations; i++ )
        {
            benchmark.run();
        }
        
        return System.currentTimeMillis() - startTime;
    }
    
}
