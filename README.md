I'm using Hexagonal Architecture in this project as a study case for larger 
applications. Although it isn't necessary for an application of this size, 
this project provides a good opportunity to practice the architecture and 
understand how it can be applied to larger and more complex systems.

This project follows the Hexagonal Architecture (Ports and Adapters) pattern.

The application is divided into three main areas:

- Domain: contains business rules and domain models.
- Application: contains use cases and application orchestration.
- Infrastructure: contains adapters and external technical concerns.

The goal is to keep the business logic independent of external technologies
such as databases, HTTP frameworks, and messaging systems.