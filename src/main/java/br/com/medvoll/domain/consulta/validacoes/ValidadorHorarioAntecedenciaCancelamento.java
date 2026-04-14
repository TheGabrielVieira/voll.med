package br.com.medvoll.domain.consulta.validacoes;

import br.com.medvoll.domain.ValidacaoException;
import br.com.medvoll.domain.consulta.ConsultaRepository;
import br.com.medvoll.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedenciaCancelamento implements ValidadorCancelamentoDeConsulta{

    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DadosCancelamentoConsulta dados) {
        var consulta = repository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();
        if (diferencaEmHoras < 24) {
            throw new ValidacaoException("Consulta deve ser cancelada com antecedência mínima de 24 horas!");

        }
    }

}
