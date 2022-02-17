package com.arquitetura.camadas.camadas.service;

import com.arquitetura.camadas.camadas.entities.Mensagem;
import com.arquitetura.camadas.camadas.repository.CamadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class CamadasService {

    @Autowired
    CamadasRepository camadasRepository;


        public List<Mensagem>findAll(String mensagem){
            if(mensagem != null){
                return camadasRepository.findAll(mensagem);
            }
            return camadasRepository.findAll();
        }

        public Mensagem findById(Integer id){
            return camadasRepository.findById(id);
        }

        public Integer add( Mensagem mensagem){
            if(mensagem.getId() == null){
                mensagem.setId(camadasRepository.count()+1);
        }
            camadasRepository.add(mensagem);
            return mensagem.getId();

        }

        public void upDate(Mensagem mensagem){
            camadasRepository.upDate(mensagem);
        }
        public void delete(@PathVariable("/id") Integer id){
            camadasRepository.delete(id);
        }
}
