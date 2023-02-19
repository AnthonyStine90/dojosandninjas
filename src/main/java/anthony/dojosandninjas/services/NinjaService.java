package anthony.dojosandninjas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anthony.dojosandninjas.models.Ninja;
import anthony.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
  
  @Autowired NinjaRepository ninjaRepository;

  public void createNinja(Ninja ninja) {

    ninjaRepository.save(ninja);
  }


}
