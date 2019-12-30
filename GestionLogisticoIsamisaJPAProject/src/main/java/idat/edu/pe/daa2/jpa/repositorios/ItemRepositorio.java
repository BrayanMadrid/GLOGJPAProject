package idat.edu.pe.daa2.jpa.repositorios;

import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Item;

public interface ItemRepositorio extends CrudRepository<Item, Integer> {

}
