package com.luanabarbosa.toolkit.extensions

inline fun <reified E : Enum<E>> valueOf(name: String, default: E) =
    enumValues<E>().find { it.name == name } ?: default
