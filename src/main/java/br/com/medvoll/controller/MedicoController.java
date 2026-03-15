package br.com.medvoll.controller;

import br.com.medvoll.medico.DadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void cadastroMedico(@RequestBody DadosCadastroMedico dados){
        System.out.println(dados);

    }
}
