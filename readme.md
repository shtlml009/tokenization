#Tokenization service

## Technical stack
- Java = 21
- Framework = Spring boot 3
- Database = H2
- Testing = Junit 5, Mockito

## Assumptions & design choices
- Used List<String> for inputs and outputs to strictly match the requirement specifications.
- Used SecureRandom to to generate 32 character String for tokens.
- For detokenization, if token is not found in database then service returns "NOT FOUND" for that particular entry and
- allows rest of the collection to process.

## How to run
```Powershell
./mvnw.cmd spring-boot:run