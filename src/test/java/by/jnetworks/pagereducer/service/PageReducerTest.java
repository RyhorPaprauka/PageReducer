package by.jnetworks.pagereducer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PageReducer.class)
public class PageReducerTest {

    @Autowired
    private PageReducer reducer;

    @Test
    public void firstCase() {
        String actual = reducer.reducePages("1,3,5,11,7,6,19,2,21,4,8");
        String expected = "1-8,11,19,21";
        assertEquals(expected, actual);
    }

    @Test
    public void secondCase() {
        String actual = reducer.reducePages(" ");
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    public void thirdCase() {
        String actual = reducer.reducePages("1,3,5,11,7,6,19,21,4,8");
        String expected = "1,3-8,11,19,21";
        assertEquals(expected, actual);
    }

    @Test
    public void fourthCase() {
        String actual = reducer.reducePages("1,3,5,11,7,6,19,2,21,22,23,4,8");
        String expected = "1-8,11,19,21-23";
        assertEquals(expected, actual);
    }

    @Test
    public void fifthCase() {
        String actual = reducer.reducePages("1,2,3,4,5,6,7,8,9,10,11,12");
        String expected = "1-12";
        assertEquals(expected, actual);
    }

    @Test
    public void sixthCase() {
        String actual = reducer.reducePages("5");
        String expected = "5";
        assertEquals(expected, actual);
    }

    @Test
    public void seventhCase() {
        String actual = reducer.reducePages("1,2,3,5,11,12,13,14,7,6,22,4,8");
        String expected = "1-8,11-14,22";
        assertEquals(expected, actual);
    }

    @Test
    public void eighthCase() {
        String actual = reducer.reducePages("1,2,3,5,11,12,13,14,7,6,21,22,4,8,23");
        String expected = "1-8,11-14,21-23";
        assertEquals(expected, actual);
    }

    @Test
    public void
    ninthCase() {
        String actual = reducer.reducePages("1,2,3,5,11,12,13,14,7,6,21,22,4,8");
        String expected = "1-8,11-14,21,22";
        assertEquals(expected, actual);
    }

    @Test
    public void tenthCase() {
        String actual = reducer.reducePages("1,3,5,7,9,11,13,15,17");
        String expected = "1,3,5,7,9,11,13,15,17";
        assertEquals(expected, actual);
    }
}