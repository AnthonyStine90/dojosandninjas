package anthony.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anthony.dojosandninjas.models.Dojo;
import anthony.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
  
  @Autowired DojoRepository dojoRepository;

  // method to create a new dojo
  public void createDojo(Dojo dojo) {
    dojoRepository.save(dojo);
  }

  // method to get all the dojos
  public List<Dojo> getAllDojos() {
    return dojoRepository.findAll();
  }

  // method to get one dojo by id
  public Dojo getOne(Long id) {
    // have to use optional whenever searching by id to check if there is one or not
    Optional<Dojo> optionalDojo = dojoRepository.findById(id);
    return optionalDojo.orElse(null);
    // option long way code
    // if(optionalDojo.isPresent()){
    //   return (Dojo) optionalDojo;
    // } else {
    //   return null;
    // }
  }
}
