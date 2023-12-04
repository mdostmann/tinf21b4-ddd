# Code-Beispiele zur Vorlesung DDD

Hier sind begleitende Code-Beispiele

## package a_valueobjects
* betrifft Vorlesungs-Inhalte zu VO
* enthält Beispiel zu value object "Weight"

## package b_entities
* betrifft Vorlesungs-Inhalte zu Entities
* enthält Beispiel zu Entity "Person" und Vergleich mit "anämischer" Entity

## package c_aggregates
* betrifft Vorlesungs-Inhalte zu Aggregates, Commands, Queries, Domain Events, Repositories und Factories

### Aggregates
* enthält Beispiele zu den Aggregaten "Customer", "Product" und "Order"
* Order Aggregate
  * Konstruktion über Builder wie in Vorlesung praktiziert
  * liefert defensive Kopien der OrderItems

### Commands, Queries
* CreateProductCommand
* FindProductByNumberQuery

### Domain Events
* OrderCreatedEvent

### Repository
* OrderRepository
  * finden/speichern von OrderAggregates
  * erzeugen eines Reports als reines Lese-Modell (createSalesPerProductReport)

### Factory
* ProductFactory