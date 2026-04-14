package br.com.medvoll.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(@NotNull Long idConsulta, @NotNull MotivoDoCancelamento motivo) {
}
