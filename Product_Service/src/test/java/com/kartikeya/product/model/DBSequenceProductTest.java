package com.kartikeya.product.model;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kartikeya.product.entity.DBSequenceProduct;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DBSequenceProductTest {


    @BeforeEach
    public void after() {
        DBSequenceProduct db = new DBSequenceProduct("1", 1);

        db.setId("1");
        db.setSeq(1);

    }

    @Test
    public void dbSeq() {
        DBSequenceProduct db = new DBSequenceProduct();
        DBSequenceProduct db1 = new DBSequenceProduct();
        assertEquals(db, db1);
    }

    @Test
    public void testGetIdAndSequence() {
        DBSequenceProduct db = new DBSequenceProduct();
        db.setId("1");
        db.setSeq(1);
        assertEquals("1", db.getId());
    }
}
