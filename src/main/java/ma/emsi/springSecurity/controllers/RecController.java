package ma.emsi.springSecurity.controllers;

import ma.emsi.springSecurity.entities.Projet;
import ma.emsi.springSecurity.entities.Reclamation;
import ma.emsi.springSecurity.repositories.ProjetRepo;
import ma.emsi.springSecurity.repositories.RecRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class RecController {
    @Autowired
    RecRepo recRepo;
    @GetMapping(path="/user/Reclam")
    public String Reclam (Model model)
    {
        List<Reclamation> reclamations=recRepo.findAll();
        model.addAttribute("listereclamations",reclamations);
        return "Reclam";
    }
    @GetMapping("/admin/formReclam")
    public String formProject(Model model)
    {
        model.addAttribute("Reclamation",new Reclamation());

        return "formReclam";
    }
    @PostMapping("/admin/save2")
    public String save(Model model,Reclamation reclamation)
    {
        recRepo.save(reclamation);
        return "redirect:/user/index";
    }
}
