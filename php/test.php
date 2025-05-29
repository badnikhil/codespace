<?php

$uri = 'https://reqres.in/api/users/2';

$request_body = '{
"name": "marfeus",
"job": "accountant"
}';

$headers = [
    'x-api-key: reqres-free-v1',
    'Content-Type: application/json',
];

$request = curl_init($uri);

curl_setopt_array($request, [
    CURLOPT_RETURNTRANSFER => 1,
    CURLOPT_CUSTOMREQUEST => 'PATCH',
    CURLOPT_HTTPHEADER => $headers,
    CURLOPT_POSTFIELDS => $request_body,
    CURLOPT_FOLLOWLOCATION => true,
]);

$response = curl_exec($request);

$httpCode = curl_getinfo($request, CURLINFO_HTTP_CODE);
curl_close($request);

echo "Status Code: " . $httpCode . "\n";
echo $response . "\n";
