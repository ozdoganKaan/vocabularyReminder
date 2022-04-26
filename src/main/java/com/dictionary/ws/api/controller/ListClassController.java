package com.dictionary.ws.api.controller;

import com.dictionary.ws.business.concretes.ListClassService;
import com.dictionary.ws.dataAccess.abstracts.ListClassDAO;
import com.dictionary.ws.entities.DTO.ListClassDTO;
import com.dictionary.ws.entities.DTO.SaveVocabDTO;
import com.dictionary.ws.entities.concretes.User;
import com.dictionary.ws.entities.mappers.ListClassMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/lists")
@RequiredArgsConstructor
public class ListClassController {

    private final ListClassService listClassService;
    private final ListClassDAO listClassDAO;





    @PostMapping
    public void saveList(@RequestBody ListClassDTO listClassDTO){
        listClassService.saveList(listClassDTO);
    }

    @GetMapping("/getall")
    public List<ListClassDTO> getLists(){
        return listClassDAO.findAll().stream().map(ListClassMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }


}
