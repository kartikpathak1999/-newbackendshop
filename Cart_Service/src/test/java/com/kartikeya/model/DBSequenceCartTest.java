package com.kartikeya.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kartikeya.cart.entity.DBSequenceCart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;



public class DBSequenceCartTest {


    @BeforeEach
    public void after() {
        DBSequenceCart db = new DBSequenceCart("1", 1);

        db.setId("1");
        db.setSeq(1);

    }

    @Test
    public void dbSeq() {
        DBSequenceCart db = new DBSequenceCart();
        DBSequenceCart db1 = new DBSequenceCart();
        assertEquals(db, db1);
    }

    @Test
    public void testGetIdAndSequence() {
        DBSequenceCart db = new DBSequenceCart();
        db.setId("1");
        db.setSeq(1);
        assertEquals("1", db.getId());
    }
}
