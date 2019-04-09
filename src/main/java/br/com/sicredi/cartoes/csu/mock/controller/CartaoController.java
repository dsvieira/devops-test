package br.com.sicredi.cartoes.csu.mock.controller;

import br.com.sicredi.cartoes.csu.mock.request.BloquearDesbloquearCartaoRequest;
import br.com.sicredi.cartoes.csu.mock.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cartao")
public class CartaoController {

    @RequestMapping(value = "/bloquearcartao", method = RequestMethod.PUT)
    public ResponseEntity<String> bloquearCartao(@RequestBody BloquearDesbloquearCartaoRequest bloquearDesbloquearCartaoRequest){
        if(bloquearDesbloquearCartaoRequest.getCodigoBloqueio() == null || bloquearDesbloquearCartaoRequest.getNumeroCartao() == null)
            return ResponseUtil.error();

        if(bloquearDesbloquearCartaoRequest.getNumeroCartao().length() < 16)
            return new ResponseEntity<>("{\"Message\": \"Cartão não pode ser inferior a 16 caracteres.\"}", null, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>("", null, HttpStatus.OK);
    }

    @RequestMapping(value = "/desbloquearcartao", method = RequestMethod.PUT)
    public ResponseEntity<String> desbloquearCartao(@RequestBody BloquearDesbloquearCartaoRequest bloquearDesbloquearCartaoRequest){
        if(bloquearDesbloquearCartaoRequest.getCodigoBloqueio() == null || bloquearDesbloquearCartaoRequest.getNumeroCartao() == null)
            return ResponseUtil.error();

        if(bloquearDesbloquearCartaoRequest.getNumeroCartao().length() < 16)
            return new ResponseEntity<>("{\"Message\": \"Cartão não pode ser inferior a 16 caracteres.\"}", null, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>("", null, HttpStatus.OK);
    }

}
