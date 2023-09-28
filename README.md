* To start docker image:

```bash
For re-build (You don't need to do this step): 
	mvn install -DskipTests
	docker-compose up --build
	
For starting docker
	docker-compose up
```

* Main function

```shell
Implement 3 apis
GET /orders/shop/{shop_id}			Return the orders information of a shop.
GET /orders/{order_id}				Return the order information by order id.
PATCH /orders/{order_id}/{status}	Update status of an order.
```

* Limitation

```shell
- Use flyway instead of liquibase because it's more familiar to me
- Request not completed: 7. Package and deploy the solution on AWS 
```

* For Testing

```shell
Please import test script: coffee_shop_chains.postman_collection.test_data.json into Postnan app then run the test
```


* Update 2022/08/20
```shell
- Add Gateway Security with JWT
- Add logging function for order service using aop
- Add Error Handling for REST using ControllerAdvice
- Add User service for authorization
- Udpate postman test cases
```