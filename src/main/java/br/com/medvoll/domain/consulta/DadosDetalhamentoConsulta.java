package br.com.medvoll.domain.consulta;

import jakarta.validation.constraints.Future;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
}
