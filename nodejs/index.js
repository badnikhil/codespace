import fetch from 'node-fetch'

const url = new URL('https://reqres.in/api/users/2'); 
const options = {
  method: 'PUT',
  headers: {
    "Content-Type": "application/json",
    "x-api-key": "reqres-free-v1"
  },
  body: "{\n\"name\": \"morpheus\",\n\"job\": \"zion resident\"\n}"
};

fetch(url, options)
  .then(res => {
    console.log(res.status);
    return res.text()
  })
  .then(body => {
    console.log(body);
  })
  .catch(err => {
    console.error(`error:${err}`);
  });
