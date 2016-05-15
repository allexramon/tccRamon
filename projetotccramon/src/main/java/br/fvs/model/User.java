/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fvs.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Pedro Saraiva
 */
@Entity
public class User implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 150, nullable = false)
    private String name;
    
    @Column(length = 50, nullable = false)
    private String login;

    @Column(length = 50, nullable = false)
    private String password;
  
    private boolean active;
    
    @ManyToOne
    private Setor setor;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_permission",
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user", "permission"})},
            joinColumns = @JoinColumn(name = "user"))
    @Column(name = "permission", length = 50)
    private List<String> permission;// = new HashSet<String>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<String> getPermission() {
        return permission;
    }

    public void setPermission(List<String> permission) {
        this.permission = permission;
    }
    

    public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	@Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.login);
        hash = 83 * hash + Objects.hashCode(this.password);
        hash = 83 * hash + (this.active ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.permission);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final User other = (User) obj;
//        if (this.id != other.id) {
//            return false;
//        }
//        if (!Objects.equals(this.name, other.name)) {
//            return false;
//        }
//        if (!Objects.equals(this.login, other.login)) {
//            return false;
//        }
//        if (!Objects.equals(this.password, other.password)) {
//            return false;
//        }
//        if (!Objects.equals(this.city, other.city)) {
//            return false;
//        }
//        if (this.active != other.active) {
//            return false;
//        }
//        if (!Objects.equals(this.permission, other.permission)) {
//            return false;
//        }
//        return true;
    	if (obj == null)  return false;  
        if (obj instanceof User){
            return ((User)obj).getId().equals(this.id);  
        }
        return false;
    }
    private static final long serialVersionUID = -2268058922183899685L;

}
