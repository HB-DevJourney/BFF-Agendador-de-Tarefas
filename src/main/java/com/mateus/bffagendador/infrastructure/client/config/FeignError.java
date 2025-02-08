package com.mateus.bffagendador.infrastructure.client.config;

import com.mateus.bffagendador.infrastructure.exception.BusinessException;
import com.mateus.bffagendador.infrastructure.exception.ConflictException;
import com.mateus.bffagendador.infrastructure.exception.ResourceNotFoundException;
import com.mateus.bffagendador.infrastructure.exception.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {


    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()) {
            case 409 -> {
                return new ConflictException("Erro: Atributo já existente.");
            }
            case 403 -> {
                return new ResourceNotFoundException("Erro: Atributo não encontrado.");
            }
            case 401 -> {
                return new UnauthorizedException("Erro: Usuário não encontrado.");
            }
            default -> {
                return new BusinessException("Erro de servidor.");
            }
        }
    }
}
