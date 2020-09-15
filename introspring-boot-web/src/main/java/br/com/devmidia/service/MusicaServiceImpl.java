package br.com.devmidia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.devmidia.dao.MusicaDao;
import br.com.devmidia.domain.Musica;
@Service
@Transactional
public class MusicaServiceImpl implements MusicaService {
	
	@Autowired
	private MusicaDao musicaDao;
	
	@Autowired
	private PlayListService playListService;
	
	@Override
	public void salvar(Musica musica, long playListId) {
		musica.setPlaylist(playListService.recuperarPorId(playListId));
		musicaDao.salvar(musica);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Musica> recuperarPorPlayList(long playlistid) {
		return musicaDao.recuperarPorPlayList(playlistid);
	}

	@Override
	public Musica recuperarPorPlayListIdMusicaId(long playlistid, long musicaid) {
		return musicaDao.recuperarPorPlayListIdMusicaId(playlistid, musicaid);
	}

	@Override
	public void atualizar(Musica musica, long playListId) {
		musica.setPlaylist(playListService.recuperarPorId(playListId));
		musicaDao.atualizar(musica);
		
	}

	@Override
	public void excluir(long playListId, long musicaId) {
		musicaDao.excluir(recuperarPorPlayListIdMusicaId(playListId, musicaId).getId());
		
	}

}
