package anthony.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import anthony.dojosandninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {

  List<Dojo> findAll();

}