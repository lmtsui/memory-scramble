/* Copyright (c) 2017-2020 MIT 6.031 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package memory;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.IOException;

/**
 * TODO
 */
public class CardTest {
    
    // Testing strategy
    //   Card():
    //   setOwner():
    //   relinquish():
    //   turnFirst():
    //   turnSecond():
    //   getSymbol():
    //   getOwner():
    //   isUp():
    //   turnDown():
    //   isEmpty():
    //   remove():
    //   isControlled():
    //   viewBy():
    //   toString():
    
    @Test
    public void testAssertionsEnabled() {
        assertThrows(AssertionError.class, () -> { assert false; },
                "make sure assertions are enabled with VM argument '-ea'");
    }
    
    // TODO tests
    
    @Test
    public void testinit() {
        Card card = new Card("A");
        assertEquals(card.getSymbol(),"A");
    }
    
    @Test
    public void testowner() {
        Card card = new Card("A");
        Player p1 = new Player("Simon");
        card.setUp(true);
        card.setOwner(p1);
        assertEquals(card.getOwner(),p1,"got "+card.getOwner());
        assertEquals(card.isControlled(),true);
        card.relinquish();
        assertEquals(card.isControlled(),false);
    }
    
   
    @Test
    public void testviewBy() {
        Card card = new Card("A");
        Player p1 = new Player("Simon");
        p1.turnOver(card);
        assertEquals(p1,card.getOwner());
        assertEquals(card.viewBy(p1),"my A");
        assertEquals(card.viewBy(new Player("Simon")),"my A");
        assertEquals(card.viewBy(new Player("James")),"up A");
    }
    

    
}
