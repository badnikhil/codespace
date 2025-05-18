using System;
using RestSharp;
using System.Threading.Tasks;

class Program
{
  static async Task Main(){
    try{
      const String _baseUrl = "https://reqres.in";
      var client = new RestClient(_baseUrl);

      var request = new RestRequest("/api/users/2", Method.Delete);

      request.AddHeader("x-api-key", "reqres-free-v1");
      request.AddHeader("Content-Type", "application/json");

      var jsonBody = new {
name = "marfeus",
job = "accountant"
};
      request.AddJsonBody(jsonBody);

      var response = await client.ExecuteAsync(request);
      Console.WriteLine("Status Code: " + (int)response.StatusCode);
      Console.WriteLine("Response Content: " + response.Content);
    }
    catch(Exception ex){
      Console.WriteLine("Error: " + ex);
    }
  }
}
