# spring
Spring Framework

> The Spring Framework is an application framework and inversion of control container for the Java platform. The framework's core features can be used by any Java application, but there are extensions for building web applications on top of the Java EE platform. Although the framework does not impose any specific programming model, it has become popular in the Java community as an alternative to, replacement for, or even addition to the Enterprise JavaBeans (EJB) model. The Spring Framework is open source. [WikiPedia](https://en.wikipedia.org/wiki/Spring_Framework)

#Core Spring

- primary features are 
	- dependency injection ( DI )
	- Aspect Oriented Programming ( AOP )

##1 Springing into action

###1.1 Simplifying Java development

> Spring’s usefulness isn’t limited to server-side development. Any Java application can benefit from Spring in terms of simplicity, testability, and loose coupling.

Spring employs four key strategies:

- Lightweight and minimally invasive development with POJOs
- Loose coupling through DI and interface orientation
- Declarative programming through aspects and common conventions
- Eliminating boilerplate code with aspects and templates

###1.2 Containing beans
In a Spring-based application, your application objects live in the Spring container. 

- the container creates the objects, wires them together, configures them, and manages their com- plete lifecycle from cradle to grave (or new to finalize(), as the case may be).


###1.3 surveying the spring landscape
Spring Framework is focused on simplifying enterprise Java development through DI, AOP, and boilerplate reduction.

#### The Spring Framework is made up of six well-defined module categories:
![The Spring Framework is made up of six well-defined module categories.](files/spring_modules.png)

- CORE SPRING CONTAINER
	- The centerpiece of the Spring Framework is a container that manages how the beans in a Spring-enabled application are created, configured, and managed. 
	- In this module is the Spring bean factory, which is the portion of Spring that provides DI. Building on the bean factory, you’ll find several implementations of Spring’s application context, each of which provides a different way to configure Spring.

- SPRING’S AOP MODULE
	- aspect-oriented programming

- DATA ACCESS AND INTEGRATION
	- Working with JDBC often results in a lot of boilerplate code that gets a connection, creates a statement, processes a result set, and then closes the connection. Spring’s JDBC and data-access objects (DAO) module abstracts away the boilerplate code so that you can keep your database code clean and simple, and prevents problems that result from a failure to close database resources. 
	- For those who prefer using an object-relational mapping (ORM) tool over straight JDBC, Spring provides the ORM module. Spring’s ORM support builds on the DAO support, providing a convenient way to build DAOs for several ORM solutions. Spring doesn’t attempt to implement its own ORM solution but does provide hooks into several popular ORM frameworks, including Hibernate, Java Persistence API, Java Data Objects

- WEB AND REMOTING

- INSTRUMENTATION

- TESTING

## 2 Wiring beans

- objects aren’t responsible for finding or creating the other objects that they need to do their jobs.
- the container gives them references to the objects that they collaborate with
- The act of creating these associations between application objects is the essence of dependency injection (DI) and is commonly referred to as wiring.

### 2.1
three primary wiring mechanisms:

-  Explicit configuration in XML
-  Explicit configuration in Java
-  Implicit bean discovery and automatic wiring


- lean on automatic configuration
-  favor the type-safe and more powerful JavaConfig over XML
-  fall back on XML only in situations where there’s a convenient XML namespace you want to use that has no equivalent in JavaConfig.


At the core of the Spring Framework is the Spring container. This container manages the lifecycle of the components of an application, creating those components and ensuring that their dependencies are met so that they can do their job.

## 3 Advanced wiring

### 3.4 Scoping beans

By default, all beans created in the Spring application context are created as single- tons.

Spring defines several scopes under which a bean can be created, including the following:

-  Singleton	—One instance of the bean is created for the entire application.
-  Prototype	—One instance of the bean is created every time the bean is injected into or retrieved from the Spring application context.
-  Session 	—In a web application, one instance of the bean is created for each session.
-  Request	—In a web application, one instance of the bean is created for each request.


```java
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Notepad { ... }
```

specify prototype scope by using the SCOPE_PROTOTYPE constant from the ConfigurableBeanFactory class. You could also use @Scope("prototype"), but using the SCOPE_PROTOTYPE constant is safer and less prone to mistakes.





#Sources: 

- [Spring in Action, 4th Edition](https://www.manning.com/books/spring-in-action-fourth-edition)
- [WikiPedia](https://en.wikipedia.org/wiki/Spring_Framework)
