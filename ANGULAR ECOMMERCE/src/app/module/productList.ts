import { Product } from "./product";

export let products: Product[] = [
    new Product('P201', 'Smartphone X', 'High-end AI camera', 'MOBILE', 799, 20),
    new Product('P202', 'Laptop Pro', 'Powerful laptop with SSD', 'LAPTOP', 1299, 15),
    new Product('P203', 'Mirrorless Camera', '24MP 4K video', 'CAMERA', 899, 10),
    new Product('P204', 'Bluetooth Speaker', 'Portable speaker with long battery', 'GADGETS', 79, 30),
    new Product('P205', 'Dark Chocolate', 'Artisan 70% cocoa bar', 'CHOCOLATE', 8, 100),
    new Product('P206', 'Feature Phone', 'Basic durable mobile', 'MOBILE', 49, 50),
    new Product('P207', 'Convertible Laptop', '2-in-1 laptop with touchscreen', 'LAPTOP', 899, 8),
    new Product('P208', 'Digital SLR Camera', 'Professional DSLR with lenses', 'CAMERA', 1499, 5),
    new Product('P209', 'Fitness Tracker', 'Waterproof tracker with heart rate monitor', 'GADGETS', 59, 40),
    new Product('P210', 'Milk Chocolate', 'Creamy milk chocolate bars', 'CHOCOLATE', 6, 120),
  ];
  export let categories:string[]=['MOBILE','LAPTOP','CAMERA','CHOCOLATE','GADGETS'];