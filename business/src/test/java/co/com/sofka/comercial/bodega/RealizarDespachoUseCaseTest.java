package co.com.sofka.comercial.bodega;

import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.comercial.bodega.events.BodegaCreada;
import co.com.sofka.comercial.bodega.values.BodegaId;
import co.com.sofka.comercial.bodega.values.Dimension;
import co.com.sofka.comercial.tienda.events.DespachoSolicitado;
import co.com.sofka.comercial.tienda.values.Ubicacion;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RealizarDespachoUseCaseTest {
    @InjectMocks
    RealizarDespachoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void realizarDespachoHappyPass() {
        //arrange
        var ubicacion = new Ubicacion("Cll tal # tal-tal", "Cúcuta", "Colombia");
        var event = new DespachoSolicitado(ubicacion, BodegaId.of("ttt"));




    }

    private List<DomainEvent> history() {
        var dimension = new Dimension(2.8F, 2.5F, 2.8F);
        var event = new BodegaCreada(
                dimension);
        return List.of(event);
    }

}