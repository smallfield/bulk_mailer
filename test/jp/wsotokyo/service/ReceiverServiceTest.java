package jp.wsotokyo.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ReceiverServiceTest extends AppEngineTestCase {

    private ReceiverService service = new ReceiverService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
