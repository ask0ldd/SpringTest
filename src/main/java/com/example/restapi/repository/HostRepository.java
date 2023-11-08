package com.example.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.model.Host;

/*
 * Spring Data JPA : permet d’exécuter des requêtes SQL, sans avoir besoin de les écrire.
 * 
 * @Repository est une annotation Spring pour indiquer que la classe est un bean, et que son rôle est de communiquer avec une source de données.
 * En réalité, @Repository est une spécialisation de @Component.
 * 
 * CrudRepository est une interface fournie par Spring. Elle fournit des méthodes pour manipuler votre entité. 
 * Elle utilise la généricité pour que son code soit applicable à n’importe quelle entité, d’où la syntaxe “CrudRepository<Employee, Long>” 
 * (je ne vous fais pas un cours sur la généricité, cela fait partie de vos acquis de développeur Java ).
 * La classe entité fournie doit être annotée @Entity, sinon Spring retournera une erreur.
 * Ainsi, vous pouvez utiliser les méthodes définies par l’interface CrudRepository. Pour en avoir la liste complète, rendez-vous sur la documentation.
*/
@Repository
public interface HostRepository extends CrudRepository<Host, Long> {

}
