package com.hendisantika.springbootdddbank.infrastructure;

import com.hendisantika.springbootdddbank.domain.Client;
import com.hendisantika.springbootdddbank.domain.imports.ClientRepository;
import com.hendisantika.springbootdddbank.infrastructure.imports.ImportedClientJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ddd-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/03/20
 * Time: 06.44
 */
@Service
public class ClientJpaRepository implements ClientRepository {

    private final ImportedClientJpaRepository impl;

    @Autowired
    public ClientJpaRepository(final ImportedClientJpaRepository impl) {
        this.impl = impl;
    }

    public void deleteAll() {
        impl.deleteAll();
    }

    public Client save(final Client client) {
        return impl.save(client);
    }

    public void delete(Client client) {
        impl.delete(client);
    }

    @Override
    public Optional<Client> find(Long id) {
        return impl.findOneById(id);
    }

    @Override
    public Optional<Client> find(String username) {
        return impl.findOneByUsername(username);
    }

    public List<Client> findAll() {
        return impl.findAllByOrderByIdDesc();
    }

}
