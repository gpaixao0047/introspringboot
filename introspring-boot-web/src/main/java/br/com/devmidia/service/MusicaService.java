package br.com.devmidia.service;

import java.util.List;

import br.com.devmidia.domain.Musica;

public interface MusicaService {
	void salvar(Musica musica, long playListId);

	List<Musica> recuperarPorPlayList(long playlistid);

	Musica recuperarPorPlayListIdMusicaId(long playlistid, long musicaid);

	void atualizar(Musica musica, long playListId);

	void excluir(long playListId, long musicaId);
}
