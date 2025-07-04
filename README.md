# Shopping Cart OOP Java Project

## Overview
This project is a simple object-oriented shopping cart system implemented in Java. It simulates a basic e-commerce checkout process, supporting various product types (including perishable and shippable items), customer accounts, and a checkout flow with shipping and balance deduction.

## Features
- Add products to a shopping cart
- Support for perishable and shippable products
- Customer balance management
- Shipping fee calculation based on product weight
- Checkout process with receipt printing

## Project Structure

- **Product (abstract class):**
  - Base class for all products
  - Fields: `name`, `quantity`, `price`
  - Methods: `canBuy`, `decreaseQuantity`, `isExpire` (abstract), getters/setters

- **Cheese, Tv, ScratchCard (concrete products):**
  - `Cheese`: Perishable and shippable, with expiry date and weight
  - `Tv`: Shippable, with weight
  - `ScratchCard`: Non-shippable, non-perishable

- **Cart & CartItem:**
  - `Cart`: Holds a list of `CartItem`s, calculates subtotal, shipping, and total, and handles checkout (including shipping and receipt printing)
  - `CartItem`: Represents a product and its quantity in the cart

- **Customer & CustomerService:**
  - `Customer`: Has a name and balance, implements `CustomerService` for checking if they can buy and deducting balance
  - `CustomerService`: Interface for customer operations

- **ShippingService:**
  - Static utility for shipping shippable items, prints shipment notice and total weight

- **Shippable & ShippablePerishableProduct (interfaces):**
  - `Shippable`: For products that can be shipped (requires name and weight)
  - `ShippablePerishableProduct`: For products that are both shippable and perishable

- **Runner (main class):**
  - Demonstrates creating products, a customer, adding products to a cart, and performing checkout


## Example Output
The program will print a checkout receipt and shipment notice, showing the products purchased, their quantities, subtotal, shipping fees, and total amount, as well as the details of shipped items.

## Author
Alaa Mohamed 

![alt text](<Screenshot (631).png>)