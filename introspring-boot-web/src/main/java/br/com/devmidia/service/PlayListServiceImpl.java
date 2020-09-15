package br.com.devmidia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.devmidia.dao.PlayListDao;
import br.com.devmidia.domain.Playlist;

@Service
@Transactional
public class PlayListServiceImpl implements PlayListService {
	
	@Autowired
	private PlayListDao playListDao;

	@Override
	public void salvar(Playlist playList) {
		playListDao.salvar(playList);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Playlist> recuperar() {
		return playListDao.recuperar();
	}

	@Override
	@Transactional(readOnly = true)
	public Playlist recuperarPorId(long id) {
		return playListDao.recuperarPorId(id);
	}

	@Override
	public void atualizar(Playlist playList) {
		playListDao.atualizar(playList);
		
	}

	@Override
	public void excluir(long id) {
		playListDao.excluir(id);
		
	}

}
