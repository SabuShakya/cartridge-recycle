package com.cartridgerecycle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : sabushakya
 */
class CartridgeRecycleTest {

    private CartridgeRecycle cartridgeRecycle;

    @BeforeEach
    public void initiate() {
        cartridgeRecycle = new CartridgeRecycle();
    }

    @Test
    void testIsMaxPerksValidForEdgeCaseCartridgesZero() {
        int actualMaxPerks = cartridgeRecycle.maxPerks(0, 4, 3, 4);

        assertEquals(0, actualMaxPerks);
    }

    @Test
    void testIsMaxPerksValidForEdgeCaseRewardZero() {
        int actualMaxPerks = cartridgeRecycle.maxPerks(2, 2, 0, 1);

        assertEquals(2, actualMaxPerks);
    }

    @Test
    void testIsMaxPerksValidForEdgeCasePerkCostZero() {
        int actualMaxPerks = cartridgeRecycle.maxPerks(2, 2, 1, 0);

        assertEquals(2, actualMaxPerks);
    }

    @Test
    void testIsMaxPerksValidForEdgeCaseDollarZero() {
        int actualMaxPerks = cartridgeRecycle.maxPerks(3, 0, 3, 3);

        assertEquals(1, actualMaxPerks);
    }

    @Test
    void testIsMaxPerksValidForCase1() {
        int actualMaxPerks = cartridgeRecycle.maxPerks(10, 10, 2, 2);

        assertEquals(7, actualMaxPerks);
    }

    @Test
    void testIsMaxPerksValidForCase2() {
        int actualMaxPerks = cartridgeRecycle.maxPerks(4, 4, 3, 4);

        assertEquals(2, actualMaxPerks);
    }

    @Test
    void testIsMaxPerksValidForCase3() {
        int actualMaxPerks = cartridgeRecycle.maxPerks(100, 100, 5, 5);

        assertEquals(60, actualMaxPerks);
    }

    @Test
    void testIsMaxPerksValidForCase4() {
        int actualMaxPerks = cartridgeRecycle.maxPerks(12, 0, 4, 3);

        assertEquals(6, actualMaxPerks);
    }
}