package co.com.sofka.comercial.bodega;

import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.comercial.bodega.events.BodegaCreada;
import co.com.sofka.comercial.bodega.events.BodegueroAsignado;
import co.com.sofka.comercial.bodega.values.BodegueroId;
import co.com.sofka.comercial.bodega.values.Dimension;
import co.com.sofka.comercial.bodega.values.Salario;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Nombre;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarDatosBodegueroUseCaseTest {
    @InjectMocks
    ActualizarDatosBodegueroUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarDatosBodegueroHappyPass() {
        //arrange


        //act


        //assert

    }

    private List<DomainEvent> history() {
        var dimension = new Dimension(2.8F, 2.5F, 2.8F);
        var event = new BodegaCreada(dimension);
        event.setAggregateRootId("xxxx");

        var bodegueroId = BodegueroId.of("0");
        var nombre = new Nombre("Felipe", "Castro");
        var salario = new Salario("$", 1500000D);
        var event2 = new BodegueroAsignado(bodegueroId, nombre, salario);

        return List.of(event, event2);
    }
}