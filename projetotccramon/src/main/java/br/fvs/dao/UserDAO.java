package br.fvs.dao;

import br.fvs.model.User;
import br.fvs.util.GenericDAO;

public class UserDAO extends GenericDAO<User> {
	
	public UserDAO(){
		super(User.class);
	}

}
