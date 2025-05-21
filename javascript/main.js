const axios = require('axios');
const config = {
  url: 'https://api.apidash.dev/io/form',
  method: 'post',
  params: {
    "size": [
      "2"
    ],
    "len": [
      "3"
    ]
  },
  headers: {
    "Content-Type": "multipart/form-data"
  },
  data: {
    "text": "API",
    "sep": "|",
    "times": "3"
  }
};

axios(config)
  .then(res => {
    console.log(res.status);
    console.log(res.data);
  })
  .catch(err => {
    console.log(err);
  });
