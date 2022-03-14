
curl -X 'POST' \
  $URL/welcome \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "Friend1",
  "content": "Hello",
  "language": "en",
  "country": "United Kingdom",
  "romanic": false
}'

curl -X 'POST' \
  $URL/welcome \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "Friend2",
  "content": "Hola",
  "language": "es",
  "country": "Spain",
  "romanic": true
}'

curl -X 'POST' \
  $URL/welcome \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "Friend3",
  "content": "Salut",
  "language": "ro",
  "country": "Romania",
  "romanic": true
}'

curl -X 'POST' \
  $URL/welcome \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "Friend4",
  "content": "Bonjour",
  "language": "fr",
  "country": "France",
  "romanic": true
}'

curl -X 'POST' \
  $URL/welcome \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "Friend5",
  "content": "Ciao",
  "language": "it",
  "country": "Italy",
  "romanic": true
}'

curl -X 'POST' \
  $URL/welcome \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "Friend6",
  "content": "Hallo",
  "language": "nl",
  "country": "Netherlands",
  "romanic": false
}'