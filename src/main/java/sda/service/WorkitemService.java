package sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.entity.Workitem;
import sda.modelDTO.WorkitemDTO;
import sda.repository.WorkitemRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkitemService {
    //fields
    @Autowired
    WorkitemRepository workitemRepository;
    @Autowired
    WorkitemService workitemService;

    //constructor

    //methods

    public WorkitemDTO getWorkitemById(Integer id){
        Optional<Workitem> byId = workitemRepository.findById(id);

        if(byId.isPresent()){
            return new WorkitemDTO(byId.get().name,byId.get().id);
        }
        return new WorkitemDTO("Whatever",0);
    }

    public List<WorkitemDTO> getAllWorkitems(){
        List<WorkitemDTO> allWorkitem = new ArrayList<>();
        List<Workitem> all =workitemRepository.findAll();

        for(Workitem w : all){
            allWorkitem.add(new WorkitemDTO(w.name,w.id));
        }
        return allWorkitem;

    }


}
