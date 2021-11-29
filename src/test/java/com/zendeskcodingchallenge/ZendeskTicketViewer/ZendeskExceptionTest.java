package com.zendeskcodingchallenge.ZendeskTicketViewer;

import com.zendeskcodingchallenge.ZendeskTicketViewer.external.ZendeskException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Assertions;

public class ZendeskExceptionTest {

    private static ZendeskException a;

    @Test
    @BeforeAll
    static void testSetup(){
        a = new ZendeskException("Error", 400);
        assertThat(a).isNotNull();
    }

    @Test
    public void getterTest(){
        Assertions.assertEquals(a.getCode(), 400);
        Assertions.assertEquals(a.getMessage(), "Error");
    }
}
