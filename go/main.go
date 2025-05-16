package main

import (
  "fmt"
  "io"
  "net/http"
  "net/url"
  "bytes"
  "mime/multipart"
  "os"
)

func main() {
  client := &http.Client{}
  url, _ := url.Parse("https://api.apidash.dev/io/img")
  payload := &bytes.Buffer{}
  writer := multipart.NewWriter(payload)
  var (
    file *os.File
    part io.Writer
  )
  
  writer.WriteField("token", "xyz")
  file, _ = os.Open("/Documents/up/1.png")
  defer file.Close()
  part, _ = writer.CreateFormFile("imfile", "/Documents/up/1.png")
  io.Copy(part, file)
  
  writer.Close()

query := url.Query()

query.Add("size", "2")
query.Add("len", "3")

url.RawQuery = query.Encode()
  req, _ := http.NewRequest("POST", url.String(), payload)

  req.Header.Set("User-Agent", "Test Agent")
  req.Header.Set("Keep-Alive", "true")
  req.Header.Set("Content-Type", writer.FormDataContentType())

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