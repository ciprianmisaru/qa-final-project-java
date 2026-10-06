# QA Final Project - Java

![CI/CD Pipeline](https://github.com/ciprianmisaru/qa-final-project-java/actions/workflows/ci.yml/badge.svg)

Proiect de QA Automation care demonstreaza un flux complet: structura Maven, logica unui test API (in pseudocod), containerizare cu Docker si un pipeline CI/CD cu GitHub Actions care publica imaginea pe Docker Hub.

## Ce face proiectul
- Defineste structura unui proiect de testare Java/Maven.
- Contine logica unui test API (pseudocod): un GET la `/todos/1` trebuie sa returneze status **200** si sa contina un camp `title`.
- Impacheteaza proiectul intr-o imagine Docker (Maven + JDK 17).
- La fiecare push pe `main`, ruleaza automat testele si publica imaginea pe Docker Hub.

## Cum rulezi testele local
```bash
mvn test
```

## Cum folosesti Docker
```bash
# Construieste imaginea
docker build -t qa-final-project-java .

# Ruleaza testele in container
docker run --rm qa-final-project-java
```

## Pipeline CI/CD (GitHub Actions)
La fiecare push pe branch-ul `main`:
1. **job `test`** - ruleaza `mvn test`;
2. **job `build-and-push`** - ruleaza doar daca `test` a trecut (`needs: test`), construieste imaginea Docker si o publica pe Docker Hub.

## Structura proiectului
```
qa-final-project-java/
├─ config/app.yaml                              # configurari (env, baseUrl, timeouts)
├─ data/                                        # date de test (gol deocamdata)
├─ src/test/java/com/ciprianmisaru/tests/       # testele (ApiTest.txt - pseudocod)
├─ .github/workflows/ci.yml                     # pipeline-ul CI/CD
├─ Dockerfile                                   # reteta imaginii Docker
└─ pom.xml                                      # configurarea Maven
```
