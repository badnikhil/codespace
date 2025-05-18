package main

import (
  "fmt"
  "io"
  "net/http"
  "net/url"
  "bytes"
)

func main() {
  client := &http.Client{}
  url, _ := url.Parse("https://reqres.in/api/users/2")
  payload := bytes.NewBuffer([]byte(`{
"name": "marfeus",
"job": "accountant"
}`))
  req, _ := http.NewRequest("PUT", url.String(), payload)

  req.Header.Set("x-api-key", "reqres-free-v1")
  req.Header.Set("Content-Type", "application/json")

  response, err := client.Do(req)
  if err != nil {
    fmt.Println(err)
    return
  }
  defer response.Body.Close()

  fmt.Println("Status Code:", response.StatusCode)
  body, _ := io.ReadAll(response.Body)
  fmt.Println("Response body:", string(body))
}