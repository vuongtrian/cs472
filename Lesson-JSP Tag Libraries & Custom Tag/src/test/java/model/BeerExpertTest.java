package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BeerExpertTest {

    @Test
    public void testGetBrands() {
        BeerExpert beerExpert = new BeerExpert();

        // Test amber selection
        List<String> amberBrands = beerExpert.getBrands("amber");
        assertEquals(2, amberBrands.size());
        assertTrue(amberBrands.contains("Jack Amber"));
        assertTrue(amberBrands.contains("Red Moose"));

        // Test light selection
        List<String> lightBrands = beerExpert.getBrands("light");
        assertEquals(2, lightBrands.size());
        assertTrue(lightBrands.contains("Jail Pale Ale"));
        assertTrue(lightBrands.contains("Gout Stout"));
    }
}
