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

./gradlew jar
export JDBC_DATABASE_URL="jdbc:postgresql://localhost/docker?user=docker&password=docker&sslmode=disable"
java -jar app/build/app-0.1.jar

./gradlew jacocoTestCoverageVerification

./gradlew ktlintCheck

./gradlew ktlintFormat

./gradlew detekt
```


Taskfile commands:
```
task download

cp app/config/deployments/.env.dev .env

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
