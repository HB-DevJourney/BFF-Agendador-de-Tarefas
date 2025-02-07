package com.mateus.bffagendador.infrastructure;

import com.mateus.bffagendador.business.dto.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    @RequestMapping(method = RequestMethod.POST)
    Void enviarEmail(@RequestBody TarefasDTOResponse dto);

}
