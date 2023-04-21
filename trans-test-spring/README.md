# Getting Started with 


## To create the order.

+ POST /orders
+ Request (application/json)

    + Body

            {
                "totalAmount": 10,
                "customerId": 123,
                "orderId": 123,
                "customerEmail": "abc@mailinator.com",
                "shippingDetail": {
                    "address": "123 HCM"
                },
                "items": [
                    {
                        "name": "item 1"
                    }
                ]
            }


## To get the order.

+ GET /orders/{orderId}

## To update order status

+ PUT /orders/{orderId}/status

+ Request (application/json)

    + Body

            {
                "status": SHIPPED
            }
