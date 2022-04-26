package com.dictionary.ws.business.concretes;

import com.dictionary.ws.dataAccess.abstracts.ListClassDAO;
import com.dictionary.ws.dataAccess.abstracts.VocabularyDAO;
import com.dictionary.ws.entities.DTO.ListClassDTO;
import com.dictionary.ws.entities.DTO.SaveVocabDTO;
import com.dictionary.ws.entities.concretes.ListClass;
import com.dictionary.ws.entities.concretes.User;
import com.dictionary.ws.entities.concretes.Vocabulary;
import com.dictionary.ws.entities.concretes.WorkspaceVocabulary;
import com.dictionary.ws.entities.mappers.ListClassMapper;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListClassService {

    private final ListClassDAO listClassDAO;

    @Transactional
    public void saveList(ListClassDTO listClassDTO) {
        Optional<ListClass> listClass=listClassDAO.findByNameAndUserId(listClassDTO.getName(),listClassDTO.getUser().getId());

        if(!listClass.isPresent()){
            ListClass listClassSave=ListClassMapper.INSTANCE.toEntity(listClassDTO);
        listClassDAO.save(listClassSave);
        }

    }

    public ListClass getList(Long id){
        return listClassDAO.getById(id);
    }

}
