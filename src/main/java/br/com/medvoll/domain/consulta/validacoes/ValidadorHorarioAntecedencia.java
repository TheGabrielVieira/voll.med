package br.com.medvoll.domain.consulta.validacoes;

import br.com.medvoll.domain.ValidacaoException;
import br.com.medvoll.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();
        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com antecedência mínima de 30 minutos!");
        }
    }
}
