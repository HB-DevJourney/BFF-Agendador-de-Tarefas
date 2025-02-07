package com.mateus.bffagendador.business;

import com.mateus.bffagendador.business.dto.in.EnderecoDTORequest;
import com.mateus.bffagendador.business.dto.in.LoginDTORequest;
import com.mateus.bffagendador.business.dto.in.TelefoneDTORequest;
import com.mateus.bffagendador.business.dto.in.UsuarioDTORequest;
import com.mateus.bffagendador.business.dto.out.EnderecoDTOResponse;
import com.mateus.bffagendador.business.dto.out.TelefoneDTOResponse;
import com.mateus.bffagendador.business.dto.out.UsuarioDTOResponse;
import com.mateus.bffagendador.infrastructure.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse salvarUsuario(UsuarioDTORequest usuarioDTO) {
        return client.salvar(usuarioDTO);
    }

    public String loginUsuario(LoginDTORequest loginDTORequest) {
        return client.login(loginDTORequest);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token) {
        return client.buscaUsuarioPorEmail(email, token);
    }

    public void deletarUsuarioPorEmail(String email, String token) {
        client.deletarUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizarDadosUsuario(String token, UsuarioDTORequest dto) {
        return client.atualizarDadoUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token) {
        return client.atualizarEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest telefoneDTO, String token) {
        return client.atualizarTelefone(telefoneDTO, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto) {
        return client.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto) {
        return client.cadastraTelefone(dto, token);
    }
}
