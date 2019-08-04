package sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.entity.Workitem;

import java.util.List;

public interface WorkitemRepository extends JpaRepository<Workitem, Integer> {
//findWorkitemByWorkitem_name(
 Workitem findWorkitemByName(String name);

}
