package com.devinhouse.usuario.business;

import com.devinhouse.usuario.business.converter.UsuarioConverter;
import com.devinhouse.usuario.business.dto.UsuarioDTO;
import com.devinhouse.usuario.infrastructure.entity.Usuario;
import com.devinhouse.usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioConverter.paraUsuarioDTO(usuario);

    }
}
