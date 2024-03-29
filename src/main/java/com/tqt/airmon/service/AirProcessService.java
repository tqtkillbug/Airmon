package com.tqt.airmon.service;

import com.tqt.airmon.exception.ExistResourceException;
import com.tqt.airmon.model.Address;
import com.tqt.airmon.model.AirProcess;
import com.tqt.airmon.model.AirProject;
import com.tqt.airmon.model.dto.AirProcessDTO;
import com.tqt.airmon.repository.AirProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirProcessService {

    @Autowired
    private AirProcessRepository repository;

    @Autowired
    private AirProjectService projectService;

    public AirProcess insert(AirProcess process){
      Optional<AirProject> airProjectOptional  = projectService.getById(process.getAirProject().getId());
        airProjectOptional .ifPresent(airProject -> {
            airProject.getProcess().add(process);
            projectService.insert(airProject);
        });
      return process;
    }

    public List<AirProcess> getAll(){
        return repository.findAll();
    }

    public List<AirProcess> getListProcessByProjectId(Long id){
        return repository.findAllByAirProjectId(id);
    }


    public AirProcessDTO insert(AirProcessDTO processDTO) {
        Optional<AirProject> airProjectOptional  = projectService.getById(processDTO.getAirProject().getId());
        airProjectOptional .ifPresent(airProject -> {
            AirProcess airProcess = AirProcess.fromDTO(processDTO);
            if (airProcess.getInfo().isEmpty()){
                airProcess.setInfo("----------");
            }
            Optional<AirProcess> processExisting = airProject.getProcess().stream()
                    .filter(p -> p.getAddress().getId().equals(airProcess.getAddress().getId())).findFirst();
            if (processExisting.isEmpty()){
                airProject.getProcess().add(airProcess);
                projectService.insert(airProject);
            }else {
                throw new ExistResourceException("This wallet added to project");
            }
        });
        return processDTO;
    }

    public AirProcess updateProcess(Long id, AirProcess processUpdate) {
        AirProcess existingProcess = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Source not found"));
        if (processUpdate.getInfo() != null){
            existingProcess.setInfo(processUpdate.getInfo());
        }
        if (processUpdate.getStatus() != null){
            existingProcess.setStatus(processUpdate.getStatus());
        }
        return repository.save(existingProcess);
    }
}
