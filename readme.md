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
```

## Troubleshooting
If you encounter a `Fatal error compiling: invalid flag: --release` or a `class file version` error:
- This project requires **Java 21**.
- Ensure your `JAVA_HOME` environment variable points to a JDK 21 installation.
- In PowerShell, you can temporarily set it using:
  `$env:JAVA_HOME = "C:\Path\To\Your\JDK-21"`
  `$env:Path = "$env:JAVA_HOME\bin;$env:Path"`