package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Lion lion;
    @Spy
    private Feline feline;
    private static List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");


    @Test
    public void doesHaveManeTest() {
        boolean lionHasMane = true;
        when(lion.doesHaveMane()).thenReturn(lionHasMane);
        MatcherAssert.assertThat("Лев с красивой гривой", lionHasMane, is(lion.doesHaveMane()));
    }

    @Test
    public void countOfKittensTest() {
        int kittensCount = 1;
        when(lion.getKittens()).thenReturn(1);
        MatcherAssert.assertThat("Сколько котят", 1, is(lion.getKittens()));
    }
    @Test
    public void getFoodTest() throws Exception {
        when(lion.getFood()).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        MatcherAssert.assertThat("Что едят львы", expectedFood, is(lion.getFood()));
    }
    @Test
    public void lionTest() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion("Самец");
        lion = new Lion("Самка");
    }
}