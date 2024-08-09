# POS System

A Point of Sale (POS) system for managing customers, items, and orders using a backend built with Java Servlets and MySQL.

## Table of Contents
- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [API Documentation](#api-documentation)
    - [Customer API](#customer-api)
    - [Item API](#item-api)
    - [Order API](#order-api)

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
   ```bash
   git clone https://github.com/DmHirushan/PosSystem-using-Java
   

## API Documentation

POST /customer

Description: Creates a new customer in the system.
Request Body:
Content-Type: application/json

{
"id": "C001",
"name": "John Doe",
"address": "123 Main St",
"salary": 5000
}

Responses:
201 Created - Customer was created successfully.
400 Bad Request - Invalid request payload or customer data.

GET /customer

Description: Retrieves customers based on query parameters.
Query Parameters:
type=one&id=C001: Retrieves a single customer by ID.
type=all: Retrieves all customers.

Responses:
200 OK - Returns the customer(s) in JSON format.
404 Not Found - Customer not found. 

