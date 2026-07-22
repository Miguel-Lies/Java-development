# Hexagonal Architecture Application - Agent Instructions

## Project Overview
Spring Boot 4.1.0 application implementing **Hexagonal Architecture** (Ports & Adapters pattern). This is an order management system with domain models for Order and OrderItem, currently in early development with core domain models and empty adapter/application layers.

## Architecture & Package Organization

### Core Packages
- **`domain/`** - Pure business logic, domain models, and repository interfaces (no external dependencies)
  - `model/` - Domain entities (OrderEntity, OrderItem)
  - `repository/` - Repository port interfaces (define contracts, not implementations)
  
- **`application/`** - Use cases and application services
  - Orchestrates domain logic and interacts with adapters
  - Receives requests through inbound ports, calls domain logic, returns responses
  
- **`adapters/`** - Inbound and outbound port implementations
  - Inbound adapters: HTTP controllers, message listeners, CLI
  - Outbound adapters: Database, external APIs, file systems
  
- **`infrastructure/`** - Spring configuration and external service implementations
  - Database configurations, JPA repository implementations
  
- **`shared/`** - Cross-cutting concerns
  - `enums/` - Shared enumerations (OrderStatus: PENDING, PAID, CANCELED)
  - `exceptions/` - Custom exceptions

### Dependency Flow
Domain → Application → Adapters ← Infrastructure

Domain code has **no** Spring or external dependencies. Keep it framework-agnostic.

## Technology Stack
- **Java 25** with Lombok for reducing boilerplate
- **Spring Boot 4.1.0** with WebMVC for HTTP handling
- **Spring Data JPA** for persistence layer
- **H2 Database** (in-memory) with H2 Console for dev/testing
- **Maven** for build and dependency management

## Common Development Tasks

### Build and Run
```bash
# Compile
mvn clean compile

# Run tests
mvn test

# Start application
mvn spring-boot:run

# Full build
mvn clean install
```

### Database
- H2 Console available at `http://localhost:8080/h2-console` (configure in application.properties)
- JPA repositories extend Spring Data interfaces in infrastructure package
- Use `OrderEntity` with UUID primary keys

## Architecture Patterns & Conventions

### Domain-Driven Design
- Domain models (OrderEntity, OrderItem) contain business logic and validation
- Use UUIDs for entity IDs
- Keep BigDecimal for monetary values, java.sql.Date for timestamps

### Hexagonal Architecture Rules
1. **Domain independence**: Domain models and logic have zero Spring/external dependencies
2. **Port definitions**: Repository interfaces defined in `domain/repository/` as ports
3. **Adapter implementations**: Spring Data JPA repositories in `infrastructure/`, implement domain ports
4. **Inbound/Outbound adapters**: HTTP controllers (inbound), database/APIs (outbound) in `adapters/`
5. **Application services**: Define use cases, coordinate domain + adapters

### Naming Conventions
- Entity classes: `*Entity` suffix (OrderEntity, not Order)
- Enums: `src/main/java/com/studies/hexagonal/shared/enums/`
- Services: `*Service` suffix
- Controllers: `*Controller` suffix (place in adapters)

## Recommended Next Steps
1. Implement JPA repository adapter for OrderEntity in `infrastructure/`
2. Create repository port interface in `domain/repository/`
3. Build application services in `application/` for order operations
4. Add REST controllers in `adapters/` to expose API endpoints
5. Add comprehensive unit tests in `src/test/java/`

## Useful Files
- [pom.xml](pom.xml) - Dependencies and Maven configuration
- [application.properties](src/main/resources/application.properties) - Spring Boot configuration
- [OrderEntity](src/main/java/com/studies/hexagonal/domain/model/OrderEntity.java) - Primary domain model
- [OrderStatus](src/main/java/com/studies/hexagonal/shared/enums/OrderStatus.java) - Order state enumeration
