package br.com.medvoll.domain.consulta.validacoes;

import br.com.medvoll.domain.ValidacaoException;
import br.com.medvoll.domain.consulta.DadosAgendamentoConsulta;
import br.com.medvoll.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente inativo!");

        }
    }
}
