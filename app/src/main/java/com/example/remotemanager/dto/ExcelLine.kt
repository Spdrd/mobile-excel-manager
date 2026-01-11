package com.example.remotemanager.dto

data class ExcelLine(
    val register_id : String,
    val file_name: String,
    val register: Map<String, Any>
)