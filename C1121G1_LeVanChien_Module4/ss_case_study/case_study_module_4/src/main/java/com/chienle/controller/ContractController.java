package com.chienle.controller;

import com.chienle.dto.ContractDto;
import com.chienle.model.contract.Contract;
import com.chienle.service.IContractService;
import com.chienle.service.ICustomerService;
import com.chienle.service.IEmployeeService;
import com.chienle.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    IContractService iContractService;

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IServiceService iServiceService;

    @GetMapping({"", "/list"})
    public String goList(Model model) {
        model.addAttribute("contracts", iContractService.findAllContract());
        return "contract/list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("contract", new ContractDto());
        model.addAttribute("customers", iCustomerService.findAll());
        model.addAttribute("employees", iEmployeeService.findAll());
        model.addAttribute("services", iServiceService.findAllService());
        return "contract/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ContractDto contractDto, RedirectAttributes redirectAttributes) {
        Contract contract = new Contract();

        BeanUtils.copyProperties(contractDto, contract);

        contract.setCustomer(contractDto.getCustomer());
        contract.setEmployee(contractDto.getEmployee());
        contract.setService(contractDto.getService());

        iContractService.save(contract);

        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");

        return "redirect:/contract/list";
    }
}