package com.contacter.web;

import com.contacter.entity.Contact;
import com.contacter.repository.ContactRepository;
import com.contacter.repository.SubcategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private ContactRepository contactRepository;
    private SubcategoryRepository subcategoryRepository;

    public ContactController(ContactRepository contactRepository, SubcategoryRepository subcategoryRepository) {
        this.contactRepository = contactRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    @GetMapping("/all")
    public String allContacts(Model model) {
        model.addAttribute("contacts",contactRepository.findAll());
        return "contact/list";
    }
    @GetMapping("/short")
    public String shortList(Model model) {
        model.addAttribute("contacts",contactRepository.findAll());
        return "contact/shortList";
    }
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("subcategory", subcategoryRepository.findAll());
        return "contact/form";
    }
    @PostMapping("/add")
    public String perform(@ModelAttribute @Valid Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            return "contact/form";
        }
        contactRepository.save(contact);
        return "redirect:/contact/short";
    }
    @GetMapping("/details/{id}")
    public String showDetails(Model model, @PathVariable long id) {
        model.addAttribute("thisContact", contactRepository.findOne(id));
        return "contact/details";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(Model model, @PathVariable long id) {
        model.addAttribute("contact", contactRepository.findOne(id));
        return "contact/form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        contactRepository.delete(id);
        return "forward:/contact/short";
    }
}
