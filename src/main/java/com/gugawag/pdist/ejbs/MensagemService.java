package com.gugawag.pdist.ejbs;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.gugawag.pdist.model.Mensagem;


@Stateless(name = "mensagemService")
@Remote
public class MensagemService {

    @EJB
    private MensagemDAO mensagemDAO;

    public List<Mensagem> listar() {
        return mensagemDAO.listar();
    }

    public void inserir(long id, String msg) {
        Mensagem novaMsg = new Mensagem(id, msg);
        mensagemDAO.inserir(novaMsg);

        if (msg.contains("palavrao")) {
            throw new RuntimeException("Proibido palavras de baixo calão");
        }
    }
}
