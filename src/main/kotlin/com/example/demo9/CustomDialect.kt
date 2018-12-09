package com.example.demo9

import org.seasar.doma.jdbc.JdbcMappingFunction
import org.seasar.doma.jdbc.JdbcMappingHint
import org.seasar.doma.jdbc.dialect.PostgresDialect
import org.seasar.doma.jdbc.type.JdbcTypes
import org.seasar.doma.jdbc.type.PortableObjectType
import org.seasar.doma.wrapper.StringWrapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.sql.SQLException
import java.util.*

@Configuration
class CustomDialect : PostgresDialect(PgJdbcMappingVisitor()) {

    @Bean
    fun dialect(): CustomDialect {
        return CustomDialect()
    }
}

private class PgJdbcMappingVisitor : PostgresDialect.PostgresJdbcMappingVisitor() {

    @Throws(SQLException::class)
    override fun visitStringWrapper(wrapper: StringWrapper?, p: JdbcMappingFunction, q: JdbcMappingHint?): Void? {
        return if (isJsonObjectType(q?.domainClass)) {
            p.apply<Void, String>(wrapper, STRING_PORTABLE_OBJECT)
        } else {
            super.visitStringWrapper(wrapper, p, q)
        }
    }

    private fun isJsonObjectType(domainClass: Optional<Class<*>>?): Boolean {
        return domainClass?.map { Json::class.java.isAssignableFrom(it) }?.orElse(false) ?: false
    }

    companion object {
        val STRING_PORTABLE_OBJECT = PortableObjectType(JdbcTypes.STRING)
    }
}