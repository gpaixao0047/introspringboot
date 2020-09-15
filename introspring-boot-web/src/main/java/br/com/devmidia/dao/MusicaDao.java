package br.com.devmidia.dao;

import java.util.List;

import br.com.devmidia.domain.Musica;

public interface MusicaDao {
	void salvar(Musica musica);

	List<Musica> recuperarPorPlayList(long playlistid);

	Musica recuperarPorPlayListIdMusicaId(long playlistid, long musicaid);

	void atualizar(Musica musica);

	void excluir(long musicaid);
}
