# POS System

A Point of Sale (POS) system for managing customers, items, and orders using a backend built with Java Servlets and MySQL.

## Table of Contents
- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [API Documentation](#api-documentation)
- [Controllers and Endpoints(#Controllers-Endpoints)]

## Introduction

This project is a simple POS (Point of Sale) system that allows managing customers, items, and orders. It provides a RESTful API built with Java Servlets, and it uses MySQL as the database.

## Technologies Used

- Java EE (Servlets)
- MySQL
- Jakarta JSON-B
- Logback (for logging)
- Apache Tomcat

## Setup Instructions

1. **Clone the Repository:**
   git clone https://github.com/DmHirushan/PosSystem-using-Java

2. ##Setup Database##
   Configure your database settings in application.properties.

    Build and Run: Deploy the WAR file to Tomcat and access the application.
    API Documentation
    Refer to the Postman Documentation for detailed API endpoints and usage instructions.
   

## API Documentation https://documenter.getpostman.com/view/34773679/2sA3s3GW2q

## Contrllers and Endpoints

Customer Controller
Add Customer: POST /customer - Adds a new customer.
Search Customer: GET /customer/{id} - Retrieves customer details by ID.
Update Customer: PUT /customer - Updates the details of an existing customer.
Delete Customer: DELETE /customer/{id} - Deletes a customer by ID.
Get Customers: GET /customer - Retrieves a list of all customers.

Item Controller
Add Item: POST /item - Adds a new item to the inventory.
Search Item: GET /item/{id} - Retrieves item details by ID.
Update Item: PUT /item - Updates the details of an existing item.
Delete Item: DELETE /item/{id} - Deletes an item by ID.
Get Items: GET /item - Retrieves a list of all items.

Order Controller
Add Order: POST /order - Creates a new order.
Get Orders: GET /order - Retrieves a list of all orders.


