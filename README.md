# Registration Numbers

## Tech Used
- Java with maven for dependency management.
- Lombok for reduction of boilerplate code
- JUnit for testing

## Decisions Made
- `year` field represented as primitive `int` to make numeric calculations easier (e.g. sort by year)
- `vehicleId` field represented as `Integer` to allow the field to be missing (represented as null)
- The example data is stored as a `json` file to allow for easier editing of data and reduces hard coding

