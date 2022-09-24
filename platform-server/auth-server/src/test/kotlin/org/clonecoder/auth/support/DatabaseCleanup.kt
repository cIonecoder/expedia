package org.clonecoder.auth.support

import com.google.common.base.CaseFormat
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct
import javax.persistence.Entity
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Service
class DatabaseCleanup(
    @PersistenceContext val entityManager: EntityManager
) {

    private var tableNames: List<String>? = null

    @PostConstruct
    fun afterPropertiesSet() {
        tableNames = entityManager.metamodel.entities.asSequence()
            .filter { e -> e.javaType.getAnnotation(Entity::class.java) != null }
            .map { e -> CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, e.name) }
            .toList()
    }

    @Transactional
    fun execute() {
        entityManager.flush()
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate()
        for (tableName in tableNames!!) {
            entityManager.createNativeQuery("TRUNCATE TABLE $tableName").executeUpdate()
            entityManager.createNativeQuery("ALTER TABLE $tableName ALTER COLUMN ID RESTART WITH 1").executeUpdate()
        }
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate()
    }
}