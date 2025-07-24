# CarAPI

API REST pour la gestion d’une flotte de voitures, avec gestion des propriétaires, immatriculations et fonctionnalités associées.

---

## 🚀 Technologies utilisées

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Spring boot Validation
- Maven 

---

## 📦 Structure du projet

com.gretacvdl.carapi.car_api
--
├─ config 
--
├─ controller 
--
├─ dto
--
├─ exception
--
├─ model
--
├─ repository
--
└─ service
--

---

## 🔧 Configuration

Retrouvez un fichier application.properties.example au chemin suivant: src/main/resources/application.properties.example

---

## ⚙️ Fonctionnalités

- Gestion des propriétaires (Owner)

- Gestion des voitures (Car) liées à un propriétaire

- Gestion des immatriculations (Registration) liées à une voiture

- Gestion des fonctionnalités (Feature) associées aux voitures (many-to-many)

- Validation des données d’entrée

- Exception personnalisées pour gestion des erreurs métier

- API REST avec endpoints CRUD pour chaque ressource
