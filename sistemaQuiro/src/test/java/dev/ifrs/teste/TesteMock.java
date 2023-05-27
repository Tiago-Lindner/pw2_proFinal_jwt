package dev.ifrs.teste;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
//import java.util.ArrayList;
//import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.ifrs.model.Consulta;
import dev.ifrs.model.Paciente;



@ExtendWith(MockitoExtension.class)
public class TesteMock {

// 1 - Crie um mock da classe AudioManager
@Mock
Consulta cons;
//Paciente pac;


// 2 - injete um mock da classe VolumeUtil
@InjectMocks
Paciente pac = new Paciente();
//Consulta cons = new Consulta();


    @Test
    public void testAudioManagerSetVolume() {

        // 3 - realize uma chamada para o método maximizeVolume do objeto VolumeUtil
        cons.setPaciente(pac);
        // 4 - Verifique se o método setVolume foi chamado uma única vez
        verify(cons, times(1)).setPaciente(pac);
        
    
    }

}