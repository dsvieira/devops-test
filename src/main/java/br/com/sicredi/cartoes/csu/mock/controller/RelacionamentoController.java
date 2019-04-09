package br.com.sicredi.cartoes.csu.mock.controller;

import br.com.sicredi.cartoes.csu.mock.util.ResourceLoader;
import br.com.sicredi.cartoes.csu.mock.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/relacionamento")
public class RelacionamentoController {

    @RequestMapping(value = "/obterrelacionamento/{num_conta_relacionamento}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> obterRelacionamento(@PathVariable("num_conta_relacionamento") String numContaRelacionamento){
        try{
            if(numContaRelacionamento == null || numContaRelacionamento.isEmpty())
                return ResponseUtil.error();

            if(numContaRelacionamento.length() != 19)
                return ResponseUtil.error("{\"Message\": \"Erro | Relacionamento não pode ser inferior a 19 caracteres.\"}", HttpStatus.INTERNAL_SERVER_ERROR);

            return new ResponseEntity<>(ResourceLoader.load("obtercontarelacionamento_ok.json"), null, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
