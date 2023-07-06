package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Mock
    Animal animal;
    @Mock
    private Predator predator;
    @Spy
    private Feline feline;

    @Test
    public void getKittensTest() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }
    @Test
    public void countOfKittensTest() {
        feline.getKittens();
        MatcherAssert.assertThat("Сколько котят", 1, is(feline.getKittens()));
    }
    @Test
    public void getFamilyTest() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }
}