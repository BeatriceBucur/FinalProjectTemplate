package sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sda.modelDTO.WorkitemDTO;
import sda.service.WorkitemService;

import java.util.List;

@Controller
@RequestMapping("/workitem")
public class WorkitemController {

    @Autowired
    WorkitemService workitemService;

    @GetMapping("/{workitem_name}")
    public String workitemPage(Model model, @PathVariable("workitem_name") String workitem_name) {
        //TODO fix this
        List<WorkitemDTO> allWorkitem = workitemService.getAllWorkitems();
        model.addAttribute("workitem", allWorkitem);
        return "workitem";
    }

    @GetMapping("/workitemHome")
    public String homePage(Model model) {
        List<WorkitemDTO> allWorkitem = workitemService.getAllWorkitems();
        model.addAttribute("workitem", allWorkitem);

        return "workitem";

    }

    @GetMapping(value = "/json", produces = "application/json")
    @ResponseBody
    public List<WorkitemDTO> getAllWorkitem() {
        List<WorkitemDTO> allWorkitem = workitemService.getAllWorkitems();
        System.out.println("Print bla");
        return allWorkitem;
    }

}

