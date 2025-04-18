package com.yuseogi.simpleblog.util.func

import jakarta.servlet.http.HttpServletResponse
import java.io.PrintWriter

fun responseData(response: HttpServletResponse, jsonData: String?) {
    val out: PrintWriter

    response.setHeader("Content-Type", "application/json; charset=utf-8")
    try {
        out = response.writer
        out.println(jsonData)
        out.flush()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}