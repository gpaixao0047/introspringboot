package br.com.devmidia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.devmidia.domain.Playlist;

@Repository
public class PlayListDaoImpl implements PlayListDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void salvar(Playlist playList) {
		em.persist(playList);
		
	}

	@Override
	public List<Playlist> recuperar() {
		return em.createQuery("select p from Playlist p", Playlist.class).getResultList();
	}

	@Override
	public Playlist recuperarPorId(long id) {
		return em.find(Playlist.class, id);
	}

	@Override
	public void atualizar(Playlist playList) {
	em.merge(playList);
		
	}

	@Override
	public void excluir(long id) {
		em.remove(em.getReference(Playlist.class, id));
		
	}

}
