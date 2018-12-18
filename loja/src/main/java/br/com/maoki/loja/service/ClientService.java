package br.com.maoki.loja.service;

import org.springframework.stereotype.Component;

import br.com.maoki.loja.entity.Client;

@Component
public interface ClientService {
	void addClient(Client client);
}
