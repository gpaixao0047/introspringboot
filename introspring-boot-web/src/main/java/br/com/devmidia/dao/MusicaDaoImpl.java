package br.com.devmidia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.devmidia.domain.Musica;

@Repository
public class MusicaDaoImpl implements MusicaDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void salvar(Musica musica) {
		em.persist(musica);

	}

	@Override
	public List<Musica> recuperarPorPlayList(long playlistid) {
		return em.createQuery("select m from Musica m where m.playlist.id = :playlistId", Musica.class)
		                  .setParameter("playlistId", playlistid)
		                  .getResultList();
	}

	@Override
	public Musica recuperarPorPlayListIdMusicaId(long playlistid, long musicaid) {
		return em.createQuery("select m from Musica m where m.playlist.id = :playlistId and m.id = :musicaId", Musica.class)
		                  .setParameter("playlistId", playlistid)
		                  .setParameter("musicaId", musicaid)
		                  .getSingleResult();
	}

	@Override
	public void atualizar(Musica musica) {
		em.merge(musica);

	}

	@Override
	public void excluir(long musicaid) {
		em.remove(em.getReference(Musica.class, musicaid));

	}

}
