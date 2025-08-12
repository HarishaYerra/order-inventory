Order-Inventory Microservices Project
A cloud-ready, microservices-based application that manages customers, products, inventory, and orders. It is built with Spring Boot, Spring Security (JWT), Docker, and Kubernetes, following a fully distributed architecture with service discovery, API gateway, and centralized configuration.
________________________________________
✨ Features
•	Microservices Architecture — Independent services for Customer, Product, Inventory, and Orders.
•	Centralized API Gateway — Unified entry point for all client requests.
•	Service Discovery — Eureka server for dynamic service registration and lookup.
•	Centralized Configuration — Spring Cloud Config server for externalized configuration management.
•	Security — Authentication & Authorization using Spring Security and JWT token.
•	Dockerized Deployment — Containerized microservices for portability.
•	Kubernetes Orchestration — Scaling, load balancing, and service management.
•	REST APIs — CRUD operations for customers, products, inventory, and orders.
•	Inter-service Communication — Feign clients / RestTemplate (depending on implementation).
________________________________________
🛠 Tech Stack
•	Backend Framework: Spring Boot, Spring Security, Spring Data JPA, Spring Cloud 
•	Language: Java 17
•	Service Discovery: Eureka Server
•	API Gateway: Spring Cloud Gateway
•	Database: MySQL
•	Build Tool: Maven
•	Containerization: Docker
•	Orchestration: Kubernetes
•	API Documentation: Swagger / OpenAPI
________________________________________
🏗 Microservices Structure

ecommerce-backend/
├── api-gateway/
├── config-server/
├── product-service/
├── order-service/
├── customer-service/
├── inventory-service/
├── eureka-service/
└── docker-compose.yml
________________________________________
📌 Sample APIs
Authentication
POST /authenticate
Content-Type: application/json

{
    "username": "admin",
    "password": "password"
}

#List all customers
GET / api/v2/customers

# Create new products
POST / api/v1/Products

#Update customer details
PUT /customers/{id}

#Delete the order
DELETE /api/v1/orders /{id}
________________________________________
▶ Running Locally
1. Clone the Repository
git clone https://github.com/HarishaYerra/order-inventory-microservices.git
cd order-inventory-microservices
2. Start Config Server
cd config-server
mvn spring-boot:run
3. Start Eureka Server
cd eureka-server
mvn spring-boot:run
4. Start All Services
cd customer-service && mvn spring-boot:run
cd product-service && mvn spring-boot:run
cd inventory-service && mvn spring-boot:run
cd order-service && mvn spring-boot:run
cd api-gateway && mvn spring-boot:run
5. Access
•	API Gateway: http://localhost:8080
•	Eureka Dashboard: http://localhost:8761
•	Swagger UI (per service): http://localhost:<port>/swagger-ui.html
________________________________________
🚀 Future Enhancements
•	Implement Circuit Breaker using Resilience4j
•	Admin panel with role-based access
•	Implement Kafka-based Event-driven communication
•	Implement OAuth2 for SSO login
________________________________________
🙏 Acknowledgements
Inspired by real-world e-commerce architecture and cloud-ready backend systems.
________________________________________
📬 Contact
Yerra Harisha

🔗 GitHub: github.com/yourusername
💼 LinkedIn: linkedin.com/in/yerra-harisha-112a3a23b/

