package br.com.rodrigo.imobiliaria.exceptions;

import br.com.rodrigo.imobiliaria.infra.storage.StorageFileNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErroValidacao>> tratarErroValidacaoDTO(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest()
                .body(erros.stream()
                        .map(e -> new DadosErroValidacao(e.getField(), e.getDefaultMessage())).toList());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErroEntityNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity tratarStorageFileNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity tratarErroRegraDeNegocio(ValidacaoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    private record DadosErroValidacao(String campo, String mensagem) {}
}
