package com.mateus.bffagendador.business;

import com.mateus.bffagendador.business.dto.out.TarefasDTOResponse;
import com.mateus.bffagendador.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient client;

    public void enviaEmail(TarefasDTOResponse dto) {
        client.enviarEmail(dto);
    }

}
