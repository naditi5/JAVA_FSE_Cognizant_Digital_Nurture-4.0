package com.example.assertions;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdditionTest {

	AdditionOperation add = new AdditionOperation();
	@Test
	public void testOperation() {
		
        assertEquals(5, add.performOp(2, 3));

        assertTrue(5 > add.performOp(1, 2));

        assertFalse(5 > add.performOp(10, 48));

        assertNull(null);

        assertNotNull(new AdditionOperation());
	}

}
