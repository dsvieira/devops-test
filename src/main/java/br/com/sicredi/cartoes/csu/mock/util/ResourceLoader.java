package br.com.sicredi.cartoes.csu.mock.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ResourceLoader {

    public static String load(String resource) throws IOException{

        try {
            ClassPathResource classPathResource = new ClassPathResource("static/" + resource);
            byte[] binaryData = FileCopyUtils.copyToByteArray(classPathResource.getInputStream());
            return new String(binaryData, StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
            throw new IOException("Falha na tentativa de efetuar a leitura do arquivo de recurso do serviço");
        }
    }
}
