package br.com.medvoll.domain.consulta.validacoes;

import br.com.medvoll.domain.ValidacaoException;
import br.com.medvoll.domain.consulta.DadosAgendamentoConsulta;
import br.com.medvoll.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com médico inativo!");
        }
    }
}
