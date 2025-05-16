using System;
using RestSharp;
using System.Threading.Tasks;

class Program
{
  static async Task Main(){
    try{
      const String _baseUrl = "https://api.apidash.dev";
      var client = new RestClient(_baseUrl);

      var request = new RestRequest("/country/data", Method.Get);

      request.AddQueryParameter("code", "IND");
      request.AddQueryParameter("code", "US");

      var response = await client.ExecuteAsync(request);
      Console.WriteLine("Status Code: " + (int)response.StatusCode);
      Console.WriteLine("Response Content: " + response.Content);
    }
    catch(Exception ex){
      Console.WriteLine("Error: " + ex);
    }
  }
}
