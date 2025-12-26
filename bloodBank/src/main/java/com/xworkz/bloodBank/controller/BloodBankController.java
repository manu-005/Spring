package com.xworkz.bloodBank.controller;

import com.xworkz.bloodBank.dto.BloodDonorDTO;
import com.xworkz.bloodBank.service.BloodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class BloodBankController {

    @Autowired
    BloodBankService bloodBankService;

    public BloodBankController() {
        System.out.println("controller object created");
    }

    @PostMapping("/createAccount")
    public String createDonorAccount(BloodDonorDTO bloodDonorDTO, Model model) {


        boolean validAndSave = bloodBankService.validAndSave(bloodDonorDTO);
        if (validAndSave) {
            model.addAttribute("success", "Successfully account created..");
        } else {
            model.addAttribute("error", "Try again after sometimes..!");

        }
        return "CreateAccount.jsp";
    }

    @GetMapping("/searchAccountByEmail")
    public String searchAccountByEmail(@RequestParam("searchEmail") String searchEmail, Model model) {

        System.out.println(searchEmail);

        Optional<BloodDonorDTO> dto = bloodBankService.validEmail(searchEmail);
        if (dto.isPresent()) {
            model.addAttribute("dto", dto.get());
        } else {
            model.addAttribute("error", "data is not exist");
        }
        return "SearchByEmail.jsp";
    }

    @GetMapping("/edit/{donorAccountId}")
    public String editByMail(@PathVariable("donorAccountId") int id, Model model) {
        System.out.println(id);

        Optional<BloodDonorDTO> updatedto = bloodBankService.validId(id);
        System.out.println(updatedto);
        if (updatedto.isPresent()) {
            model.addAttribute("updateDto", updatedto.get());

        } else {
            model.addAttribute("error", "data is not exist");

        }
        return "/UpdateByEmail.jsp";
    }

    @PostMapping("update")
    public String update(BloodDonorDTO bloodDonorDTO, Model model) {

        System.out.println(bloodDonorDTO);

        boolean updated = bloodBankService.validUpdate(bloodDonorDTO);

        if (updated) {
            model.addAttribute("success", "Successfully account Updated..");
        } else {
            model.addAttribute("error", "Try again after sometimes..!");

        }
        return "/UpdateByEmail.jsp";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {

        System.out.println(id);

        boolean deleted = bloodBankService.validdelete(id);

        if (deleted) {
            model.addAttribute("delete", "Successfully deleted..");
        } else {
            model.addAttribute("notdelete", "Try again after sometimes..!");

        }
        return "/SearchByEmail.jsp";
    }
}
