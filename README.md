# CheckoutCounterService

This is sample RESTful service that implments a checkout counter for an online retail store that
scans products and generates an itemized bill. The bill has total cost of all the products, the applicable sales tax for each product, total sales tax, and purchased items (products) description.

Sales tax varies based on the type of products

    category A products carry a levy of 10%
    category B products carry a levy of 20%
    category C products carry no levy

This RESTful service is developed using Spring Boot, JPA, embedded h2 database.

Please refer : https://spring.io/guides

Tested with the environment
---------------------------

    JAVA 8
    gradle 3.5
    
Download or checkout the project
----------------------------------

    git clone https://github.com/iamon3/CheckoutCounterService.git
    
To add products to the inventory (i.e. h2 database)
---------------------------------------------------
Open the src/main/resources/data-h2.sql
Currently it has entries for 3 products

    INSERT INTO Product(id, name, category, price) values(1,'Sugar','A', 10);
    INSERT INTO Product(id, name, category, price) values(2,'Wheat','B', 20);
    INSERT INTO Product(id, name, category, price) values(3,'Rice','B', 10);
Add similar entries, with id in the incresing sequesnce.

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

To access the embedded in-memory h2 database console
----------------------------------------------------
In the browser,open
        
        http://localhost:8080/console
Configure

         JDBC URL: jdbc:h2:~/myDB
and click on the "connect" button. You will be connected to myDB, where the Product table can be seen at the left meta data panel.

Sample HTTP request
-------------------
    curl -i -X POST -H "Content-Type:application/json" 
    -d '[{
          "id":1,
          "quantityKg":1
         },
         {
           "id":3,
           "quantityKg":2
         }]'
    http://localhost:8080/bills
    
Sample HTTP response
--------------------
      HTTP/1.1 200 
      Content-Type: application/json;charset=UTF-8
      Transfer-Encoding: chunked
      Date: Sun, 13 Aug 2017 11:53:16 GMT
      
      {
         "purchasedProductSet": [{
                     "id":1,
                     "name":"Sugar",
                     "priceRsPerKg":10.0,
                     "applicableTaxPercent":10.0,
                     "quantityKg":1.0,
                     "priceAfterTax":11.0,
                     "priceBeforeTax":10.0
                    }, 
                    {   
                      "id":3,
                      "name":"Rice",
                      "priceRsPerKg":10.0,
                      "applicableTaxPercent":20.0,
                      "quantityKg":2.0,
                      "priceAfterTax":24.0,
                      "priceBeforeTax":20.0
                    }],
           "totalBillAmountAfterTax":35.0,
           "totalBillAmountBeforeTax":30.0,
           "totalTaxPercent":16.666668
         }
