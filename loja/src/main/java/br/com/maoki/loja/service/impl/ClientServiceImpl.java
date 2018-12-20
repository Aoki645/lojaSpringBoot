package br.com.maoki.loja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maoki.loja.dao.ClientRepository;
import br.com.maoki.loja.entity.Client;
import br.com.maoki.loja.service.ClientService;;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepository clientDao;
	
	@Override
	public void addClient(Client client) {		 
		clientDao.save(client);
	}
		


	 
	
}
