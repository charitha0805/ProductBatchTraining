import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        FoodDeliveryServices service =
                new FoodDeliveryServices();


  

        Admin admin =
                new Admin(
                        1,
                        "admin",
                        "1111",
                        9876543200L,
                        "Hyderabad"
                );



        Customer customer =
                new Customer(
                        1,
                        "charitha",
                        "2005",
                        9876543210L,
                        "Hyderabad"
                );

        DeliveryPartner deliveryPartner =
                new DeliveryPartner(
                        1,
                        "delivery",
                        "2004",
                        9876543220L,
                        "Hyderabad"
                );

        service.addDeliveryPartner(deliveryPartner);


      

        Restaurant restaurant =
                new Restaurant(
                        1,
                        "Paradise",
                        "Hyderabad"
                );


        FoodItem biryani =
                new FoodItem(
                        101,
                        "Chicken Biryani",
                        250,
                        "NON_VEG"
                );


        FoodItem friedRice =
                new FoodItem(
                        102,
                        "Fried Rice",
                        180,
                        "VEG"
                );


        FoodItem coke =
                new FoodItem(
                        103,
                        "Coke",
                        50,
                        "DRINK"
                );



        restaurant.addFoodItem(biryani);
        restaurant.addFoodItem(friedRice);
        restaurant.addFoodItem(coke);


    

        service.addRestaurant(restaurant);



        System.out.println("\n==============================");
        System.out.println("     FOOD DELIVERY SYSTEM");
        System.out.println("==============================");

        System.out.println("1. Admin Login");
        System.out.println("2. Customer Login");
        System.out.println("3. Delivery Partner Login");

        System.out.print("\nEnter your choice: ");

        int loginChoice = sc.nextInt();
        sc.nextLine();


        if (loginChoice == 2) {

            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();


         

            if (!customer.loginValidation(
                    username,
                    password)) {

                System.out.println("Invalid customer login.");

                return;
            }


            System.out.println(
                    "\nCustomer login successful!"
            );


            int option;


            do {

                System.out.println("\n==============================");
                System.out.println("       CUSTOMER MENU");
                System.out.println("==============================");

                System.out.println("1. View Restaurant Menu");
                System.out.println("2. Add Item to Cart");
                System.out.println("3. View Cart");
                System.out.println("4. Remove Item from Cart");
                System.out.println("5. Place Order");
                System.out.println("6. View Orders");
                System.out.println("7. Exit");

                System.out.print("\nEnter your option: ");

                option = sc.nextInt();



                if (option == 1) {

                    System.out.println(
                            "\nRestaurant: "
                            + restaurant.getRestaurantName()
                    );

                    System.out.println(
                            "Location: "
                            + restaurant.getLocation()
                    );


                    System.out.println("\nFOOD MENU");

                    for (FoodItem item :
                            restaurant.getFoodItems()) {

                        System.out.println(
                                item.getFoodId()
                                + " - "
                                + item.getFoodName()
                                + " - Rs."
                                + item.getPrice()
                        );
                    }
                }

                else if (option == 2) {

                    System.out.print(
                            "Enter food ID: "
                    );

                    int foodId = sc.nextInt();


                    System.out.print(
                            "Enter quantity: "
                    );

                    int quantity = sc.nextInt();


                    FoodItem selectedFood = null;


                

                    for (FoodItem item :
                            restaurant.getFoodItems()) {

                        if (item.getFoodId() == foodId) {

                            selectedFood = item;

                            break;
                        }
                    }


                    if (selectedFood == null) {

                        System.out.println(
                                "Food item not found."
                        );

                    } else {

                        service.addToCart(
                                customer,
                                selectedFood,
                                quantity
                        );
                    }
                }


                else if (option == 3) {

                    System.out.println(
                            "\n========== YOUR CART =========="
                    );


                    if (customer.getCart()
                            .getItems()
                            .isEmpty()) {

                        System.out.println(
                                "Cart is empty."
                        );

                    } else {

                        for (CartItem item :
                                customer.getCart().getItems()) {

                            System.out.println(
                                    item.getFoodItem()
                                            .getFoodName()
                                    + " x "
                                    + item.getQuantity()
                                    + " = Rs."
                                    + item.getSubtotal()
                            );
                        }


                        System.out.println(
                                "------------------------------"
                        );


                        System.out.println(
                                "Total = Rs."
                                + customer.getCart()
                                        .calculateTotal()
                        );
                    }
                }


                else if (option == 4) {

                    System.out.print(
                            "Enter food ID to remove: "
                    );

                    int foodId = sc.nextInt();


                    FoodItem selectedFood = null;


                    for (CartItem item :
                            customer.getCart().getItems()) {

                        if (item.getFoodItem()
                                .getFoodId() == foodId) {

                            selectedFood =
                                    item.getFoodItem();

                            break;
                        }
                    }


                    if (selectedFood == null) {

                        System.out.println(
                                "Item not found in cart."
                        );

                    } else {

                        customer.getCart()
                                .removeItem(selectedFood);

                        System.out.println(
                                "Item removed from cart."
                        );
                    }
                }


 
                else if (option == 5) {

                    if (customer.getCart()
                            .isEmpty()) {

                        System.out.println(
                                "Cart is empty."
                        );

                        continue;
                    }


                    System.out.println(
                            "\nSelect Payment Method:"
                    );

                    System.out.println("1. CASH");
                    System.out.println("2. UPI");
                    System.out.println("3. CARD");


                    System.out.print(
                            "Enter choice: "
                    );

                    int paymentChoice =
                            sc.nextInt();


                    String paymentMethod;


                    if (paymentChoice == 1) {

                        paymentMethod = "CASH";

                    } else if (paymentChoice == 2) {

                        paymentMethod = "UPI";

                    } else if (paymentChoice == 3) {

                        paymentMethod = "CARD";

                    } else {

                        System.out.println(
                                "Invalid payment method."
                        );

                        continue;
                    }


                    // Place order

                    Order order =
                            service.placeOrder(
                                    customer,
                                    paymentMethod
                            );


                    if (order != null) {

                        System.out.println(
                                "\nOrder placed successfully!"
                        );


                        System.out.println(
                                "Order ID: "
                                + order.getOrderId()
                        );


                        System.out.println(
                                "Total Amount: Rs."
                                + order.getTotalAmount()
                        );


                        System.out.println(
                                "Payment: "
                                + order.getPayment()
                                        .getPaymentMethod()
                        );


                        System.out.println(
                                "Order Status: "
                                + order.getStatus()
                        );


                        // Restaurant accepts order

                        service.acceptOrder(order);


                        // Assign delivery partner

                        service.assignDeliveryPartner(order);


                        // Update status

                        service.updateOrderStatus(
                                order,
                                "PREPARING"
                        );


                        service.updateOrderStatus(
                                order,
                                "PICKED_UP"
                        );


                        service.updateOrderStatus(
                                order,
                                "OUT_FOR_DELIVERY"
                        );


                        service.updateOrderStatus(
                                order,
                                "DELIVERED"
                        );
                    }
                }



                else if (option == 6) {

                    System.out.println(
                            "\n========== YOUR ORDERS =========="
                    );


                    if (customer.getOrders().isEmpty()) {

                        System.out.println(
                                "No orders found."
                        );

                    } else {

                        for (Order order :
                                customer.getOrders()) {

                            service.displayOrder(order);
                        }
                    }
                }




                else if (option == 7) {

                    System.out.println(
                            "Thank you for using Food Delivery System!"
                    );
                }


                else {

                    System.out.println(
                            "Invalid option."
                    );
                }


            } while (option != 7);
        }

        else if (loginChoice == 1) {

            System.out.print(
                    "Enter admin username: "
            );

            String username = sc.nextLine();


            System.out.print(
                    "Enter admin password: "
            );

            String password = sc.nextLine();


            if (!admin.loginValidation(
                    username,
                    password)) {

                System.out.println(
                        "Invalid admin login."
                );

                return;
            }


            System.out.println(
                    "\nAdmin login successful!"
            );


            System.out.println(
                    "\nRestaurant managed: "
                    + restaurant.getRestaurantName()
            );


            System.out.println(
                    "Location: "
                    + restaurant.getLocation()
            );


            System.out.println(
                    "\nFood items available:"
            );


            for (FoodItem item :
                    restaurant.getFoodItems()) {

                System.out.println(
                        item.getFoodId()
                        + " - "
                        + item.getFoodName()
                        + " - Rs."
                        + item.getPrice()
                );
            }
        }


       
        else if (loginChoice == 3) {

            System.out.print(
                    "Enter username: "
            );

            String username = sc.nextLine();


            System.out.print(
                    "Enter password: "
            );

            String password = sc.nextLine();


            if (!deliveryPartner.loginValidation(
                    username,
                    password)) {

                System.out.println(
                        "Invalid delivery partner login."
                );

                return;
            }


            System.out.println(
                    "\nDelivery Partner login successful!"
            );


            System.out.println(
                    "Delivery Partner: "
                    + deliveryPartner.getUsername()
            );


            System.out.println(
                    "Available: "
                    + deliveryPartner.isAvailable()
            );
        }


  
        else {

            System.out.println(
                    "Invalid login choice."
            );
        }


        sc.close();
    }
}