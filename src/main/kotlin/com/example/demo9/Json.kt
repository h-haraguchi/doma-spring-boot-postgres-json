package com.example.demo9

import org.seasar.doma.Domain

/**
 * PostgresqlのJson型を表すドメインクラスです。
 * valueにjson文字列を入れて使用します。
 */
@Domain(valueType = String::class)
data class Json(val value: String)