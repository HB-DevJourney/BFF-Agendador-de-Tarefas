package com.mateus.bffagendador.infrastructure.client;

import com.mateus.bffagendador.business.dto.in.EnderecoDTORequest;
import com.mateus.bffagendador.business.dto.in.LoginDTORequest;
import com.mateus.bffagendador.business.dto.in.TelefoneDTORequest;
import com.mateus.bffagendador.business.dto.in.UsuarioDTORequest;
import com.mateus.bffagendador.business.dto.out.EnderecoDTOResponse;
import com.mateus.bffagendador.business.dto.out.TelefoneDTOResponse;
import com.mateus.bffagendador.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @RequestMapping(method = RequestMethod.GET)
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @RequestMapping(method = RequestMethod.POST)
    UsuarioDTOResponse salvar(@RequestBody UsuarioDTORequest usuarioDTO);

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    String login(@RequestBody LoginDTORequest loginDTO);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{email}")
    Void deletarUsuarioPorEmail(@PathVariable String email,
                                @RequestHeader("Authorization") String token);

    @RequestMapping(method = RequestMethod.PUT)
    UsuarioDTOResponse atualizarDadoUsuario(@RequestBody UsuarioDTORequest usuarioDTO,
                                            @RequestHeader("Authorization") String token);

    @RequestMapping(method = RequestMethod.PUT, value = "/endereco")
    EnderecoDTOResponse atualizarEndereco(@RequestBody EnderecoDTORequest enderecoDTO,
                                          @RequestParam("id") Long id,
                                          @RequestHeader("Authorization") String token);

    @RequestMapping(method = RequestMethod.PUT, value = "/telefone")
    TelefoneDTOResponse atualizarTelefone(@RequestBody TelefoneDTORequest telefoneDTO,
                                          @RequestParam("id") Long id,
                                          @RequestHeader("Authorization") String token);

    @RequestMapping(method = RequestMethod.POST, value = "/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest enderecoDTO,
                                         @RequestHeader("Authorization") String token);

    @RequestMapping(method = RequestMethod.POST, value = "/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest telefoneDTO,
                                         @RequestHeader("Authorization") String token);
}
