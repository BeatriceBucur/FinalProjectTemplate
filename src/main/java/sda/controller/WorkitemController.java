package sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sda.modelDTO.WorkitemDTO;
import sda.service.WorkitemService;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class WorkitemController {

    @Autowired
    WorkitemService workitemService;

    @GetMapping("/barbershop/{workitem_name}")
        public String workitemPage (Model model,  @PathVariable("workitem_name") String workitem_name){
        List<WorkitemDTO> allWorkitem = workitemService.getAllWorkitems(workitem_name);
        model.addAttribute("workitem", allWorkitem);
        return "workitem";
        }
}

