package sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.entity.Workitem;
import sda.modelDTO.WorkitemDTO;
import sda.repository.WorkitemRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkitemService {
    //fields
    @Autowired
    WorkitemRepository workitemRepository;
    @Autowired
    WorkitemService workitemService;

    //constructor

    //methods

    public List<WorkitemDTO> getAllWorkitems(String workitem_name){
        List<WorkitemDTO> allWorkitem = new ArrayList<>();
        List<Workitem> all =workitemRepository.findWorkitemByName(workitem_name);

        for(Workitem w : all){
            allWorkitem.add(new WorkitemDTO(w.name));
        }
        return allWorkitem;

    }

}
