package anthony.dojosandninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import anthony.dojosandninjas.models.Dojo;
import anthony.dojosandninjas.models.Ninja;
import anthony.dojosandninjas.services.DojoService;
import anthony.dojosandninjas.services.NinjaService;

@Controller
public class MainController {

  @Autowired DojoService dojoService;
  @Autowired NinjaService ninjaService;

  // ***** route to new dojo page with form for new dojo *****
  @RequestMapping(value={"dojos/new", "/"})
  // ModelAttribute allows of to pass a model back and forth between view, model and controller
  public String dojoForm(@ModelAttribute("dojo") Dojo dojo) {
    return "dojos/new.jsp";
  }
  
  // ***** create a new dojo *****
  @PostMapping("/dojos")
  public String createNewDojo(@ModelAttribute("dojo") Dojo dojo) {
    dojoService.createDojo(dojo);
    return "redirect:/";

  }
    
  // ***** create a new ninja *****

  // ***** route to show ninjas/new page with new ninja form *****
  @GetMapping("/ninjas/new") 
  public String ninjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
    // need to store dojos somewhere. 2 ways, with model or with a variable
    List<Dojo> dojos = dojoService.getAllDojos();
    model.addAttribute("dojos", dojos);
    //you can call the getAll method directly in the model.addAttribute
    // or model.addAttribute("dojos", dojoService.getAllDojos());
    return "ninjas/new.jsp";
  }

  @PostMapping("/ninjas")
  public String createNinja(@ModelAttribute("ninja") Ninja ninja) {
    ninjaService.createNinja(ninja);
    return "redirect:/";
  }

  // ***** show one dojo ( by id) with all associated ninjas *****

  // when passing in id variables in spring it has to be caleld {id}
  @GetMapping("/dojos/{id}")
  public String showDojo(@PathVariable("id") Long id, Model model){
    // we want to display all the ninjas information in a particular dojo
    // we need a getById for dojo, and get all ninjas for that dojo by the dojo id
    Dojo dojo = dojoService.getOne(id);
    // pass the dojo from controller to the view
    // getNinjas is a function built into our dojo model, so you can access ninjas in your view
    model.addAttribute("dojo", dojo);
    
    return "dojos/show.jsp";
  }


}
