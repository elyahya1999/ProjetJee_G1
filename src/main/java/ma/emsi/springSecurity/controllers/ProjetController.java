package ma.emsi.springSecurity.controllers;

import ma.emsi.springSecurity.entities.Employe;
import ma.emsi.springSecurity.entities.Projet;
import ma.emsi.springSecurity.repositories.ProjetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class ProjetController {
    @Autowired
    ProjetRepo projetRepo;
    @GetMapping(path="/user/Project")
    public String Pojet (Model model)
    {
        List<Projet> projets=projetRepo.findAll();
        model.addAttribute("listeprojets",projets);
        return "Project";
    }
    @GetMapping("/admin/formProjet")
    public String formProject(Model model)
    {
        model.addAttribute("projet",new Projet());

        return "formProjet";
    }
    @PostMapping("/admin/save1")
    public String save(Model model,Projet projet)
    {
        projetRepo.save(projet);
        return "redirect:/user/index";
    }
}
