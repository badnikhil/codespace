using HTTP

url = "https://api.apidash.dev/io/form"

data = Dict(
    "text" => "API",
    "sep" => "|",
    "times" => "3",
)
  paramsSerializer: (params) => {
    return qs.stringify(params, { arrayFormat: 'repeat' });
  }
};

payload = HTTP.Form(data)

response = HTTP.request("POST", url, body=payload, status_exception=false)

println("Status Code: $(response.status)")
println("Response Body: \n$(String(response.body))")
