package br.com.sicredi.cartoes.csu.mock.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtil {

    public static void error(HttpServletResponse res) throws IOException {
        //set the response object
        res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        res.setContentType("application/json");

        //pass down the actual obj that exception handler normally send
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter out = res.getWriter();
        out.print("{\"Message\": \"An error has occurred.\"}");
        out.flush();
    }

    public static ResponseEntity<String> error() {
        return new ResponseEntity<>("{\"Message\": \"An error has occurred.\"}", null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public static ResponseEntity<String> error(String message, HttpStatus httpStatus) {
        return new ResponseEntity<>(message, null, httpStatus);
    }
}
