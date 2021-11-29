package com.zendeskcodingchallenge.ZendeskTicketViewer;

import com.zendeskcodingchallenge.ZendeskTicketViewer.entity.Ticket;
import com.zendeskcodingchallenge.ZendeskTicketViewer.util.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class ResultTests {

    static class TestObj{
        String content;
        public TestObj(String content){
            this.content = content;
        }
    }

    private static Result<TestObj> singleResult;
    private static Result<List<TestObj>> listResult;

    @Test
    @BeforeAll
    static void testSetUp(){
        singleResult = new Result<>(200, "Success");
        listResult = new Result<>(300, "Fail");
    }

    @Test
    public void setDataTest(){
        singleResult.setData(new TestObj("single"));
        listResult.setData(Arrays.asList(new TestObj("list1"), new TestObj("list2")));
        Assertions.assertEquals(singleResult.getData().content, "single");
        Assertions.assertEquals(listResult.getData().get(0).content, "list1");
        Assertions.assertEquals(listResult.getData().get(1).content, "list2");
    }

    @Test
    public void getDataTest(){
        Assertions.assertEquals(singleResult.getMessage(), "Success");
        Assertions.assertEquals(singleResult.getResultCode(), 200);
        Assertions.assertEquals(listResult.getMessage(), "Fail");
        Assertions.assertEquals(listResult.getResultCode(), 300);
    }
}
