# Pre-Interview Assignment: Implement an extensible Calculator

## Features
- RESTful APIs
- addition, subtraction, multiplication and division
- Structured log printing
- Graceful error handling and clear error messages
- Extensive test cases

## Requisites
- Java
- Spring 2.x
- JUnit
- Log4j2
- Maven

## How to build
```mav clean install```

## Get Started
- The application will start on port `8383`

## Calculate - Sample Requests

### Addition Case 01
```shell
curl --location 'localhost:8383/v1/calculator/calculate' \
--header 'Content-Type: application/json' \
--data '{
        "op": "ADD",
        "num1": 1,
        "num2": 2
    }'
```

```json
{
  "code": "200",
  "message": "Calculation successful",
  "data": 3.0
}
```
### Addition Case 02
```shell
curl --location 'localhost:8383/v1/calculator/calculate' \
--header 'Content-Type: application/json' \
--data '{
        "op": "ADD",
        "num1": 1e308,
        "num2": 1e308
    }'
```

```json
{
    "code": "400 BAD_REQUEST",
    "message": "Double overflow or invalid result",
    "data": null
}
```

### Addition Case 03

```shell
curl --location 'localhost:8383/v1/calculator/calculate' \
--header 'Content-Type: application/json' \
--data '{
        "op": "INVALID_OPERATION",
        "num1": 1,
        "num2": 2
    }'
```

```json
{
        "code":"500 INTERNAL_SERVER_ERROR",
        "message":"JSON parse error: Cannot deserialize value of type `com.ebay.calculator.dto.Operation` from String \"INVALID_OPERATION\": not one of the values accepted for Enum class: [ADD, MULTIPLY, DIVIDE, SUBTRACT]; nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot deserialize value of type `com.ebay.calculator.dto.Operation` from String \"INVALID_OPERATION\": not one of the values accepted for Enum class: [ADD, MULTIPLY, DIVIDE, SUBTRACT]\n at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 2, column: 15] (through reference chain: com.ebay.calculator.dto.OperationRequest[\"op\"])",
        "data":null
}
```

## Chain Calculate - Sample Requests

```shell
curl --location 'localhost:8383/v1/calculator/chain' \
--header 'Content-Type: application/json' \
--data '{
    "initial_value":0.0,
    
    "operations": [
        {
            "op": "ADD",
            "num": 5
        },
        {
            "op": "SUBTRACT",
            "num": 2
        },
        {
            "op": "MULTIPLY",
            "num": 3
        },
        {
            "op": "DIVIDE",
            "num": 4
        }
    ]
}'
```

```json
{
  "code": "200",
  "message": "Calculation successful",
  "data": 2.25
}
```

## Future Improvements
- Expand the calculator to handle more operations (like mod, square root) and support more numeric types (e.g., `Long`).
- Add APM, Service Monitoring, and Tracing.
- Edge case bug fixes
- Resiliency (Rate Limiting, Retries, Multithreading)

