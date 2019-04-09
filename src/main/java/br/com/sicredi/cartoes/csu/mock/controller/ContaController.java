package br.com.sicredi.cartoes.csu.mock.controller;

import br.com.sicredi.cartoes.csu.mock.request.IncluirFilaAtendimentoRequest;
import br.com.sicredi.cartoes.csu.mock.util.ResourceLoader;
import br.com.sicredi.cartoes.csu.mock.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {

    @RequestMapping(value = "/obterconta/{num_conta}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> obterConta(@PathVariable("num_conta") String numConta){
        try{
            if(numConta == null || numConta.isEmpty())
                return ResponseUtil.error();

            if(numConta.length() != 16)
                new ResponseEntity<>("{\"Message\": \"Conta/Cartão não pode ser inferior a 16 caracteres.\"}", null, HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(ResourceLoader.load("obterconta_ok.json"), null, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/incluirfilaatendimento", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> incluirFilaAtendimento(@RequestBody IncluirFilaAtendimentoRequest incluirFilaAtendimentoRequest){
        try{
            if(incluirFilaAtendimentoRequest.getConta() == null || incluirFilaAtendimentoRequest.getConta().isEmpty() ||
                incluirFilaAtendimentoRequest.getCartao() == null || incluirFilaAtendimentoRequest.getCartao().isEmpty() ||
                incluirFilaAtendimentoRequest.getCodigoAcao() == null || incluirFilaAtendimentoRequest.getCodigoAcao().isEmpty() ||
                incluirFilaAtendimentoRequest.getDescricao() == null || incluirFilaAtendimentoRequest.getDescricao().isEmpty())
                return ResponseUtil.error();

            if(incluirFilaAtendimentoRequest.getConta().length() < 16 || incluirFilaAtendimentoRequest.getCartao().length() < 16)
                new ResponseEntity<>("{\"Message\": \"Conta/Cartão não pode ser inferior a 16 caracteres.\"}", null, HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(ResourceLoader.load("incluirfilaatendimento_ok.json"), null, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
