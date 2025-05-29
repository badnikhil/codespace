import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.MediaType.Companion.toMediaType

fun main() {
    val client = OkHttpClient()

    val url = "https://reqres.in/api/users/2"

    val mediaType = "application/json".toMediaType()

    val body = """{
"name": "morpheus",
"job": "zion resident"
}""".toRequestBody(mediaType)

    val request = Request.Builder()
        .url(url)
        .addHeader("x-api-key", "reqres-free-v1")
        .put(body)
        .build()

    val response = client.newCall(request).execute()

    println(response.code)
    println(response.body?.string())
}
