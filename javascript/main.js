// refer https://github.com/foss42/apidash/issues/293#issuecomment-1997568083 for details regarding integration

const config = {
  url: 'https://api.apidash.dev/country/data',
  method: 'get',
  params: {
    "code": [
      "IND",
      "US"
    ]
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
