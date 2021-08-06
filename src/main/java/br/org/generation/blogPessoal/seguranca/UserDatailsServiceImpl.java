package br.org.generation.blogPessoal.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.org.generation.blogPessoal.model.Usuario;
import br.org.generation.blogPessoal.repository.usuarioRepository;

@Service
public class UserDatailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private usuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) {
		Optional<Usuario> user = userRepository.findByUsuario(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " Not found."));
		return user.map(UserDetailsImpl::new).get();
	}

}
