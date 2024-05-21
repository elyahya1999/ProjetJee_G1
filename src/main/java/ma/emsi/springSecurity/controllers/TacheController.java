package ma.emsi.springSecurity.controllers;

import ma.emsi.springSecurity.entities.Tache;
import ma.emsi.springSecurity.repositories.EmpRepo;
import ma.emsi.springSecurity.repositories.ProjetRepo;
import ma.emsi.springSecurity.repositories.TacheRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TacheController {
    @Autowired
    private TacheRepo tacheRepo;
    @Autowired
    private ProjetRepo projetRepo;
    @Autowired
    private EmpRepo empRepo;

    @GetMapping(path="/taches")
    public String taches(Model model,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "size", defaultValue = "3") int size,
                         @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Tache> pageTaches = tacheRepo.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("ListeTaches", pageTaches.getContent());
        model.addAttribute("pages", new int[pageTaches.getTotalPages()]);
        model.addAttribute("currentpage", page);
        model.addAttribute("keyword", keyword);
        return "taches";
    }

    @GetMapping(path="/deleteTache")
    public String deleteTache(Long id, String keyword, int page) {
        tacheRepo.deleteById(id);
        return "redirect:/taches?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/formTache")
    public String formTache(Model model) {
        model.addAttribute("tache", new Tache());
        model.addAttribute("projets", projetRepo.findAll());
        model.addAttribute("employes", empRepo.findAll());
        return "formTache";
    }

    @GetMapping("/editTache")
    public String editTache(Model model, Long id) {
        Tache tache = tacheRepo.findById(id).orElse(null);
        if(tache == null) throw new RuntimeException("Tache Introuvable");
        model.addAttribute("tache", tache);
        return "editTache";
    }

    @PostMapping("/saveTache")
    public String saveTache(Model model, Tache tache) {
        tacheRepo.save(tache);
        return "redirect:/taches";
    }
}