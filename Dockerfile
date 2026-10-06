# Imagine de baza: Maven + JDK 17
FROM maven:3.8.4-openjdk-17

# Folderul de lucru in interiorul containerului
WORKDIR /app

# Copiaza tot proiectul in container
COPY . .

# Construieste si ruleaza testele (batch mode = loguri curate, fara interactiune)
RUN mvn -B test

# Comanda rulata la pornirea containerului
CMD ["mvn", "-B", "test"]
