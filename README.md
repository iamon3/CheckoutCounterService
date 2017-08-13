# CheckoutCounterService
Sample RESTful service developed using Spring Boot, JPA, embedded h2 database.

Please refer : https://spring.io/guides

Tested with the environment
---------------------------

    JAVA 8
    gradle 3.5
    
Download or checkout the project
----------------------------------

    git clone https://github.com/iamon3/CheckoutCounterService.git
    
    
2 ways to run the service. 
--------------------------

Open command prompt

   A] First Option 
   
       cd CheckoutCounterService
       gradle bootRun
            
   B] Second Option
   
       cd CheckoutCounterService
       gradle clean build
       java -jar build/libs/CheckoutCounterService-0.1.0.jar


Sample HTTP request
-------------------
    curl -i -X POST -H "Content-Type:application/json" -d '[{"id":1,"quantityKg":1},{"id":3,"quantityKg":2}]' http://localhost:8080/bills
    
Sample HTTP response
--------------------
      HTTP/1.1 200 
      Content-Type: application/json;charset=UTF-8
      Transfer-Encoding: chunked
      Date: Sun, 13 Aug 2017 11:53:16 GMT
      {"purchasedProductSet":[{"id":1,"name":"Sugar","priceRsPerKg":10.0,"discountPercent":10.0,"quantityKg":1.0,"discountedPrice":9.0,"price":10.0},{"id":3,"name":"Rice","priceRsPerKg":10.0,"discountPercent":20.0,"quantityKg":2.0,"discountedPrice":16.0,"price":20.0}],"totalBillAmountAfterDiscount":25.0,"totalBillAmountBeforeDiscount":30.0,"discountPercent":16.666668}
