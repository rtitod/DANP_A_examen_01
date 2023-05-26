package com.example.examen1.model

data class DeforestedArea (
    val nombre: String,
    val fechaDeteccion: String,
    val latitud: String,
    val longitud: String,
    val tamanioZD: Double,
    val CausaZD: String,
    val consecuenciaZD: String,
    var img: String
)