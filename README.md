# cs_shopping: Simple shopping cart project

## Project structure:
* _spec/base_scenarios.feature_:  contain a feature file to cover simple BDD scenarios for this project
* _main/java_:  main java sources
* _test/java_:  test java sources
* _pom.xml_:  Simple maven config to build and execute the project tests
* _README.md_

## Functional assumptions
* "buy 1 get 1 free" is equivalent to "2 for 1". That's a simplification choice.
* No synchronisation aspect is being handled here

## Technical choices
* prices are being calculated / stored in pence, to avoid to use BigDecimal (for instance) for such a simple project
* maven is being used to gather basic dependencies and build the project
* JUnit used for unit tests, those unit tests are manually inferred from the BDD scenario
