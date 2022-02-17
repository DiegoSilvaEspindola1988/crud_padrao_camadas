package com.arquitetura.camadas.camadas.repository;

import com.arquitetura.camadas.camadas.entities.Mensagem;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CamadasRepository {
    public List<Mensagem> mensagens;

    public List<Mensagem>findAll(){
        return mensagens;
    }

    public List<Mensagem>findAll(String mensagem){
        return mensagens.stream()
                .filter(msg->msg.getMensagem()
                        .contains(mensagem)).collect(Collectors.toList());
    }
    public Mensagem findById(Integer id){
        return mensagens.stream()
                .filter(msg->msg.getId().equals(id))
                .findFirst().orElse(null);
    }

    public void add(Mensagem mensagem){
        mensagens.add(mensagem);
    }
    public int count(){
        return mensagens.size();
    }

    public void upDate(Mensagem mensagem){
        mensagens.stream()
                .filter(msg->msg.getId().equals(mensagem.getId()))
                .forEach(msg->msg.setMensagem(mensagem.getMensagem()));
    }
    public void delete(@PathVariable("/id") Integer id){
        mensagens.removeIf(msg -> msg.getId().equals(id));
    }
}
