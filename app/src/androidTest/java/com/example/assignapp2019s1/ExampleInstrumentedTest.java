package com.example.assignapp2019s1;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.example.assignapp2019s1", appContext.getPackageName());

         //assertEquals(R.drawable.show1, appContext.getDrawable(R.drawable.show1));
        //assertEquals("emptyhole", appContext.getString(R.drawable.emptyhole));
       //assertEquals("score", appContext.getString(R.id.score));
       // assertEquals("score", appContext.getDrawable(R.id.score));


    }
}
