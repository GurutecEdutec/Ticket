package com.ticket.model;

import com.ticket.utils.EntityUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Equipe Gurutec
 */

@Entity
@Table(name="Tickets")
public class Ticket {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String cargo;
    private String unidade;
    private String tipo;
    private String assunto;
    private String texto;
    private boolean isDeleted = false;
    
    public Ticket(){
      
    }
    
    public Ticket(String nome, String email, String cargo, String unidade, String tipo, String assunto, String texto){
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.tipo = tipo;
    }
    
    public static Ticket getTicket(long id) {
        Ticket t = EntityUtils.select("SELECT c FROM Ticket c WHERE id = " + id, Ticket.class).get(0);
        return t;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
    public boolean getIsDeleted() {
        return isDeleted;
    }
    
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
}
