# CICD-1 Lab 1

Browser / Swagger

    +--> Catalog Service :8081 --> temporary Product List
    |
    +--> Order Service   :8082 --> temporary Order List


Catalog Service

    GET  /products  --> Get all products

    POST /products --> Create new product
                       |
                       +--> Automatically generates product ID


Product

    +--> id
    +--> name
    +--> price


Storage

    +--> Temporary in-memory ArrayList
    +--> No database
    +--> Data lost when service restarts


Separate GitHub repositories

Separate pull requests
