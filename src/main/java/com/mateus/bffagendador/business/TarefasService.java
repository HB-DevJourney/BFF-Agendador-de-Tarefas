package com.mateus.bffagendador.business;

import com.mateus.bffagendador.business.dto.in.TarefasDTORequest;
import com.mateus.bffagendador.business.dto.out.TarefasDTOResponse;
import com.mateus.bffagendador.business.enums.StatusNotificacaoEnum;
import com.mateus.bffagendador.infrastructure.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient client;

    public TarefasDTOResponse salvarTarefa(String token, TarefasDTORequest dto) {
        return client.salvarTarefas(dto, token);
    }

    public List<TarefasDTOResponse> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal, String token) {
        return client.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscaTarefasPorEmail(String token) {
        return client.buscaTarefasPorEmail(token);
    }

    public void deletarPorId(String id, String token) {
        client.deletaTarefaPorID(id, token);
    }

    public TarefasDTOResponse alteraStatus(StatusNotificacaoEnum status, String id, String token) {
        return client.alteraStatusNotificacao(status, id, token);
    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest dto, String id, String token) {
        return client.updateTarefas(dto, id, token);
    }
}
