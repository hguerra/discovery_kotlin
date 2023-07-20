# Worker Application


Gradle commands:
```
gradle init

./gradlew run

./gradlew test

./gradlew test --tests ArchTest

# check tasks executed in build:
./gradlew build --dry-run

./gradlew build

java -jar app/build/libs/app-0.1.jar

./gradlew jacocoTestCoverageVerification

./gradlew ktlintCheck

./gradlew ktlintFormat

./gradlew detekt
```


Taskfile commands:
```
task download

task build

task dbUp

task dbInspect

task dbCreateSeed -- 

task dbUpdateMigrationHash

task dbMigrate

task dbCreateMigration -- add_tables

task dbMigrate

task run
```
