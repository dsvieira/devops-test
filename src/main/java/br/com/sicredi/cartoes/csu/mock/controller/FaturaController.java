package br.com.sicredi.cartoes.csu.mock.controller;

import br.com.sicredi.cartoes.csu.mock.request.AlterarDiaVencimento;
import br.com.sicredi.cartoes.csu.mock.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fatura")
public class FaturaController {

    @RequestMapping(value = "/alterardiavencimento", method = RequestMethod.PUT)
    public ResponseEntity<String> alterarDiaVencimento(@RequestBody AlterarDiaVencimento alterarDiaVencimentos){

        if(alterarDiaVencimentos.getNumeroConta() == null || alterarDiaVencimentos.getNumeroConta().isEmpty() ||
                alterarDiaVencimentos.getDiaVencimento() == null || alterarDiaVencimentos.getDiaVencimento().isEmpty())
            return ResponseUtil.error();

        if(alterarDiaVencimentos.getNumeroConta().length() != 19)
            return ResponseUtil.error("{\"Message\": \"Erro | Relacionamento não pode ser inferior a 19 caracteres.\"}", HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>("", null, HttpStatus.OK);
    }

    @RequestMapping(value = "/obtertransacoes", method = RequestMethod.GET)
    public ResponseEntity<String> obterTransacoes(){
        String response = "{\"teste\":\"teste\"}";
        return new ResponseEntity<>(response, null, HttpStatus.OK);
    }

    @RequestMapping(value = "/obtertransacoesfuturas", method = RequestMethod.GET)
    public ResponseEntity<String> obterTransacoesFuturas(){
        String response = "{\"teste\":\"teste\"}";
        return new ResponseEntity<>(response, null, HttpStatus.OK);
    }

    @RequestMapping(value = "/obterrelacaofaturaspdf", method = RequestMethod.GET)
    public ResponseEntity<String> obterRelacaoFuturasPdf(){
        String response = "{\"teste\":\"teste\"}";
        return new ResponseEntity<>(response, null, HttpStatus.OK);
    }

    @RequestMapping(value = "/faturaimpressa", method = RequestMethod.GET)
    public ResponseEntity<String> faturaImpressa(){
        String response = "{\"teste\":\"teste\"}";
        return new ResponseEntity<>(response, null, HttpStatus.OK);
    }

    @RequestMapping(value = "/obterrelacaofaturas", method = RequestMethod.GET)
    public ResponseEntity<String> obterRelacaoFuturas(){
        String response = "{\"teste\":\"teste\"}";
        return new ResponseEntity<>(response, null, HttpStatus.OK);
    }
}
