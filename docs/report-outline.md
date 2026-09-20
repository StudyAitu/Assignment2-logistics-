# Assignment 2 Report — 3–5 page structure

> Replace placeholders with your real details.

## 1. Identification

**Assignment:** Assignment 2 — Factory Method and Abstract Factory  
**Student:** Muratbek Ibrai
**Group:** Se-2529
**GitHub:**  https://chatgpt.com/c/6aafcc67-d670-83ed-b5a9-141ab7c126dc
**Submitted commit:** 18dc5dc

## 2. Introduction

The application is a Java 17 console logistics system. It supports road and sea delivery and two UI component families: Windows and macOS.

Factory Method is used for transport creation because the common delivery workflow belongs to the `Logistics` creator while subclasses decide which `Transport` implementation to instantiate.

Abstract Factory is used for UI because a platform consists of a related family of products: a button and a checkbox. A concrete factory guarantees that both products belong to the same platform family.

## 3. UML diagrams

Insert `factory-method.puml` rendered as an image.

Insert `abstract-factory.puml` rendered as an image.

The diagrams must match the submitted code.

## 4. Clean Code evidence

### 4.1 Meaningful names
Excerpt: `RoadLogistics`, `SeaLogistics`, `WindowsFactory`, `MacOSFactory`.

Benefit: names immediately communicate the domain and pattern roles.

### 4.2 Small methods
Excerpt: `readChoice(...)` only reads and validates one input value.

Benefit: input handling is separated from object creation and application execution.

### 4.3 Avoid duplicated logic
Excerpt: `Logistics.planDelivery(...)`.

Benefit: the delivery workflow is written once and the factory method supplies the transport.

### 4.4 Data abstraction — Chapter 6
Excerpt: `Transport transport = createTransport(); transport.deliver(...)`.

Benefit: the workflow depends on the `Transport` abstraction rather than concrete `Truck` or `Ship` state.

### 4.5 Objects and encapsulation — Chapter 6
Excerpt: `DeliveryApplication` stores `GUIFactory` and `Logistics` as private fields and uses behavior methods.

Benefit: clients request behavior through interfaces rather than manipulating concrete product internals.

## 5. Verification evidence

Insert readable screenshots for:

1. ROAD + WINDOWS — PASS
2. SEA + WINDOWS — PASS
3. ROAD + MACOS — PASS
4. SEA + MACOS — PASS
5. Invalid delivery mode — PASS
6. Invalid platform — PASS
7. Missing input — PASS

For each check, record input, actual result, and status.

## 6. Pattern comparison and design reflection

### Factory Method vs Simple Factory

A Simple Factory usually puts conditional creation in one `create(type)` method. Factory Method moves the creation decision into creator subclasses that override `createTransport()`.

In this project, `RoadLogistics` returns `Truck` and `SeaLogistics` returns `Ship`, while `Logistics.planDelivery(...)` remains shared.

Startup selection uses a small `switch`, which is explicitly allowed by the assignment. The runtime delivery workflow does not branch on concrete transport classes.

### Factory Method vs Abstract Factory

Factory Method focuses on creating one product through a creator hierarchy. Abstract Factory creates a family of related products through a common factory interface.

The transport side has one product contract: `Transport`. The UI side has two related product contracts: `Button` and `Checkbox`.

### Extensions

**New transport:** add `Airplane` and `AirLogistics`; update startup selection. Existing `Transport` clients remain unchanged.

**New UI family:** add the new platform's button, checkbox, and factory. `DeliveryApplication` remains unchanged.

**New UI product type:** add the product interface and a creation method to `GUIFactory`, then implement it in every concrete factory. Client code changes only where the new product is needed.

## 7. Conclusion

Factory Method and Abstract Factory solve different creation problems in the same application. Factory Method encapsulates transport selection inside creator subclasses while preserving one delivery workflow. Abstract Factory preserves consistency between related UI products by creating them through a platform-specific factory.
