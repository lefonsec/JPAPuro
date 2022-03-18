package br.com.loja.dao;

import javax.persistence.EntityManager;

import br.com.loja.entity.Produto;
import br.com.loja.entity.enuns.Categoria;

public class CategoriaDao {

	
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
}
