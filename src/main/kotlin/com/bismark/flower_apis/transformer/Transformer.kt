package com.bismark.flower_apis.transformer

interface Transformer<A,B> {
    fun transform(source: A): B
}