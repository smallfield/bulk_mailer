package jp.wsotokyo.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ReceiverTest extends AppEngineTestCase {

    private Receiver model = new Receiver();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
