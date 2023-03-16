package com.elieldev.cursojava.config;

import com.elieldev.cursojava.entities.User;
import com.elieldev.cursojava.repositories.UserRepositorys;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration //informa para o spring que essa classe é de configuração
@Profile("test") //informa que essas configurações so serão utilizadas no perfil de teste
public class TestConfig implements CommandLineRunner {

  @Autowired //resolve o sistema de dependencia e associar a instancia a dependencia userRepositorys
  private UserRepositorys userRepositorys;

  @Override
  public void run(String... args) throws Exception { //metodo que instancia os dados no banco assim que inicia a aplicação

    User u1 = new User(
      null,
      "Maria Brown",
      "maria@gmail.com",
      "988888888",
      "123456"
    );

    User u2 = new User(
      null,
      "Alex Green",
      "alex@gmail.com",
      "977777777",
      "123456"
    );

    userRepositorys.saveAll(Arrays.asList(u1, u2)); //metodo que salta uma lista no banco chamando o userRepositorys que é o objeto que acessa os dados
  }
}
