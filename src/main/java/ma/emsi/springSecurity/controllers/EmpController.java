package ma.emsi.springSecurity.controllers;

import ma.emsi.springSecurity.entities.Employe;
import ma.emsi.springSecurity.repositories.EmpRepo;
import ma.emsi.springSecurity.repositories.ProjetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller

public class EmpController {
    //acceder a la base de donnée
    @Autowired
    private EmpRepo emp;
    @GetMapping(path="/user/index")
    public String Employe(Model model,
                          @RequestParam(name = "page",defaultValue = "0") int page,
                          @RequestParam(name = "size",defaultValue = "3") int size,
                          @RequestParam(name = "keyword",defaultValue = "") String keyword)
    {
        Page<Employe> pageemployes=emp.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("ListeEmployes",pageemployes.getContent());
        model.addAttribute("pages",new int[pageemployes.getTotalPages()]);
        model.addAttribute("currentpage",page);
        model.addAttribute("keyword",keyword);
        return "employes";
    }
    @GetMapping(path="/admin/delete")
    public String delete (Integer id,String keyword,int page)
    {
        emp.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/admin/formEmploye")
    public String formEmploye(Model model)
    {
        model.addAttribute("employe",new Employe());

        return "formEmploye";
    }
    @GetMapping("/admin/editEmploye")
    public String editEmploye(Model model,Integer id)
    {
        Employe employe=emp.findById(id).orElse(null);
        if(employe==null) throw  new RuntimeException("Employe Introuvable");
        model.addAttribute("employe",employe);

        return "editEmploye";
    }
    @PostMapping("/admin/save")
    public String save(Model model,Employe employe)
    {
        emp.save(employe);
        return "redirect:/user/index";
    }
    @GetMapping("/")
    public String home()
    {
        return "redirect:/user/index";
    }

}
