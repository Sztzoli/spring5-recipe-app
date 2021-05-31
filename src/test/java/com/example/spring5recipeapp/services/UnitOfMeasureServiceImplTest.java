package com.example.spring5recipeapp.services;

import com.example.spring5recipeapp.commands.UnitOfMeasureCommand;
import com.example.spring5recipeapp.converters.UnitOfMeasureToUnitMeasureCommand;
import com.example.spring5recipeapp.domain.UnitOfMeasure;
import com.example.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UnitOfMeasureServiceImplTest {

    @Mock
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Spy
    private UnitOfMeasureToUnitMeasureCommand unitOfMeasureToUnitMeasureCommand;

    @InjectMocks
    private UnitOfMeasureServiceImpl unitOfMeasureService;

    public UnitOfMeasureServiceImplTest() {
        this.unitOfMeasureToUnitMeasureCommand = new UnitOfMeasureToUnitMeasureCommand();
    }

    @Test
    void listAllUoms() {
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        unitOfMeasures.add(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom1.setId(2L);
        unitOfMeasures.add(uom2);

        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);

        Set<UnitOfMeasureCommand> commands = unitOfMeasureService.listAllUoms();

        assertEquals(2, commands.size());
        verify(unitOfMeasureRepository, times(1)).findAll();
    }
}