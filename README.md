# PriceBasket

## Specification:

#### Inventory of products that can be purchased and their prices:

- Soup - 65p per tin.
- Bread - 80p per loaf.
- Milk - £1.30 per bottle.
- Apples - £1.00 per bag.

#### Current special offers:

- Apples have a 10% discount off their normal price this week.
- Buy 2 tins of soup and get a loaf of bread for half price.

#### The application should accept a list of items in the basket and output the subtotal, the special offer discounts and the final price.

#### Input should be via the command line in the form: PriceBasket item1 item2 item3 ...

#### For example:

```bash
PriceBasket Apples Milk Bread
```

#### Should produce the following output to the console:

```bash
Subtotal: £3.10
Apples 10% off: 10p
Total: £3.00
```

#### If no special offers are applicable then show:

```bash
Subtotal: £1.30 (No offers available)
Total price: £1.30
```

## Usage

You must have Java installed on your system.

- To package the application, run:
  ```bash
  .\mvnw clean package
  ```
- The packaged application will be in the target/ directory.
- Run the application with the following command
  ```bash
  java -jar target/priceBasket-1.0.0.jar apple milk bread
  ```

## Notes

- Current valid products are:
  - Soup
  - Bread
  - Milk
  - Apple
- The application will ignore any other products.
- Products are case insensitive. ("Apple" and "apple" are the same product)
