package com.example.horoscopo_app.data

import android.util.Log
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class HoroscopoProvider {

    fun getHoroscopos(): List<Horoscopo> {
        return listOf(
            Horoscopo.Aries,
            Horoscopo.Taurus,
            Horoscopo.Gemini,
            Horoscopo.Cancer,
            Horoscopo.Leo,
            Horoscopo.Virgo,
            Horoscopo.Libra,
            Horoscopo.Scorpio,
            Horoscopo.Sagittarius,
            Horoscopo.Capricorn,
            Horoscopo.Aquarius,
            Horoscopo.Pisces
        )
    }

    fun getHoroscopo(id: String): Horoscopo {
        return getHoroscopos().filter { it.id == id }.firstOrNull()!!
    }

    suspend fun getHoroscopoLuck(horoscopoId: String): String? {
        val url = URL("https://horoscope-app-api.vercel.app/api/v1/get-horoscope/daily?sign=$horoscopoId&day=TODAY") // URL de la API o endpoint
        var connection: HttpsURLConnection? = null
        var result: String? = null

        try {
            // Crear la conexión HTTP
            connection = url.openConnection() as HttpsURLConnection
            connection.requestMethod = "GET" // Establecer el método GET
            connection.setRequestProperty("Accept", "application/json") // Establecer el tipo de contenido

            // Leer la respuesta de la solicitud
            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val response = readStream (connection.inputStream)
                Log.i("HTTP", "Respuesta: ${response.toString()}")

                val responseObject: JSONObject = JSONObject(response.toString())
                result = responseObject.getJSONObject("data").getString("horoscope_data")
            } else {
                Log.i("HTTP", "Error en la solicitud. Código de respuesta: $responseCode")
            }

        } catch (e: Exception) {
            Log.e("HTTP", "Error en la solicitud. ", e)
        } finally {
            // Cerrar la conexión
            connection?.disconnect()
        }
        return result
    }

    private fun readStream (inputStream: InputStream) : StringBuilder {
        val reader = BufferedReader(InputStreamReader(inputStream))
        val response = StringBuilder()
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            response.append(line)
        }
        reader.close()
        return response
    }
}