# wealthmgmt

To Run the same from maven 

mvn clean package exec:java



Request from CURL 

curl --location --request GET "http://localhost:4567/account/94452345/detail"   --header "Accept: application/json"   --header "Content-Type: application/json"
{
  "userID" : "AF98405",
  "accountNumber" : "94452345",
  "accountType" : "401K",
  "vestedBalance" : 33450,
  "portfolio" : null,
  "balance" : 43590
}


shivakumars-mbp:~ sgokaram$ curl --location --request GET "http://localhost:4567/user/AF98405"   --header "Accept: application/json"   --header "Content-Type: application/json"
{
  "firstName" : "Sam",
  "lastName" : "Matthew",
  "address" : "4 Cornell Dr",
  "state" : "FL",
  "country" : "USA",
  "city" : "Jacksonville",
  "zip" : "32003"
}


