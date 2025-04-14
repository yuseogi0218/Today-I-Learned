package com.yuseogi.simpleblog.config

import com.p6spy.engine.common.ConnectionInformation
import com.p6spy.engine.event.JdbcEventListener
import com.p6spy.engine.spy.P6SpyOptions
import com.p6spy.engine.spy.appender.MessageFormattingStrategy
import org.hibernate.engine.jdbc.internal.FormatStyle
import org.springframework.context.annotation.Configuration
import org.springframework.util.StringUtils.hasText
import java.sql.SQLException

@Configuration
class P6SpyFormatter : JdbcEventListener(), MessageFormattingStrategy {

    override fun onAfterGetConnection(connectionInformation: ConnectionInformation?, e: SQLException?) {
        P6SpyOptions.getActiveInstance().logMessageFormat = this::class.java.name
    }

    override fun formatMessage(
        connectionId: Int,
        now: String,
        elapsed: Long,
        category: String,
        prepared: String,
        sql: String,
        url: String,
    ): String {
        val sb = StringBuilder()
        sb.append(category).append(" ").append(elapsed).append("ms")

        if (hasText(sql)) {
            sb.append(format(sql))
        }
        return sb.toString()
    }

    private fun format(sql: String): String {
        if (isDDL(sql)) {
            return FormatStyle.DDL.formatter.format(sql)
        } else if (isBasic(sql)) {
            return FormatStyle.BASIC.formatter.format(sql)
        }
        return sql
    }

    private fun isDDL(sql: String): Boolean {
        return sql.startsWith("create") || sql.startsWith("alter") || sql.startsWith("comment")
    }

    private fun isBasic(sql: String): Boolean {
        return sql.startsWith("select") || sql.startsWith("insert") || sql.startsWith("update") || sql.startsWith("delete")
    }
}