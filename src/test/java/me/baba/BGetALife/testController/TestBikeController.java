package me.baba.BGetALife.testController;

import com.flextrade.jfixture.FixtureBehaviour;
import com.flextrade.jfixture.JFixture;
import com.flextrade.jfixture.SpecimenBuilder;
import me.baba.BGetALife.controller.BikeController;
import me.baba.BGetALife.model.Bike;
import me.baba.BGetALife.repository.BikeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestBikeController {

    @Mock
    private BikeRepository bikeRepository;

    @InjectMocks
    private BikeController bikeController;

    private JFixture fixture = new JFixture();

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        fixture.customise().circularDependencyBehaviour().omitSpecimen();
    }
    @Test
    public void testGetBikes() {
        List<Bike> list = new ArrayList<>();
        list.add(fixture.create(Bike.class));
        list.add(fixture.create(Bike.class));
        list.add(fixture.create(Bike.class));


        Mockito.when(bikeRepository.findAll()).thenReturn(list);
        Assert.assertEquals(list.size(), bikeController.getBikes().size());
    }
}
