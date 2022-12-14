package co.com.sofka.comercial.tienda;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.comercial.tienda.commands.ActualizarDatosEncargado;
import co.com.sofka.comercial.tienda.events.*;
import co.com.sofka.comercial.tienda.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarDatosEncargadoUseCaseTest {
    @InjectMocks
    ActualizarDatosEncargadoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarDatosEncargadoHappyPass() {
        //arrange
        var tiendaId = TiendaId.of("cccc");
        var entityId = EncargadoId.of("0");
        var nombre = new Nombre("Adrian", "Gutierrrez");
        var command = new ActualizarDatosEncargado(tiendaId, entityId, nombre);



        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTiendaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert

    }

    private List<DomainEvent> history() {
        var ubicacion = new Ubicacion("Cll tal # tal-tal", "Cúcuta", "Colombia");
        var event = new TiendaCreada(ubicacion);
        event.setAggregateRootId("cccc");

        var entityId = EncargadoId.of("0");
        var nombre = new Nombre("Lorena", "Castro");
        var metaMensual = new MetaMensual("Superar los 10,000,000 en ventas");
        var event2 = new EncargadoAsignado(entityId, nombre, metaMensual);

        return List.of(event, event2);

    }

}