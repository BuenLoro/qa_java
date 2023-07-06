package com.example;
// Покрываем тестами класс Cat

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Spy
    private Feline feline;
    @InjectMocks
    private Cat cat;
    @Test
    public void catSound() {
        cat.getSound();
        MatcherAssert.assertThat("Барсик, подай голос", "Мяу", is(cat.getSound()));
    }
    @Test
    public void feedACat() throws Exception {
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}