package ro.kata;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by julianghionoiu on 26/11/2015.
 */
public class AppTest {

    @Test
    public void testOne() throws Exception {

        assertThat(App.one(), is(1));
    }
}