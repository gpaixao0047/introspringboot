package br.com.devmidia.dao;

import java.util.List;

import br.com.devmidia.domain.Playlist;

public interface PlayListDao {
	void salvar(Playlist playList);

	List<Playlist> recuperar();

	Playlist recuperarPorId(long id);

	void atualizar(Playlist playList);

	void excluir(long id);
}
