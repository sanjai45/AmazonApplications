package com.amazon.view;

import com.amazon.controller.ProductController;
import com.amazon.model.Product;
import com.amazon.view.validation.ProductValidation;

import java.util.Scanner;
import java.util.Set;

/**
 * <p>
 * Represents the product details
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class ProductView {

    private static final ProductController PRODUCT_CONTROLLER = new ProductController();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ProductValidation PRODUCT_VALIDATION = new ProductValidation();

    /**
     * <p>
     * To perform the update, delete, read and get operation
     * </p>
     */
    public void productDetails() {
        System.out.println("Choose 1 to create the product, 2 to update, 3 to delete, 4 to read, 5 to get all products, 6 to exit");
        final int input = SCANNER.nextInt();

        switch (input) {
            case 1: {
                addProduct();
                break;
            }
            case 2: {
                updateProduct();
                break;
            }
            case 3: {
                deleteProduct();
                break;
            }
            case 4: {
                getProduct();
                break;
            }
            case 5: {
                getAllProducts();
                break;
            }
            case 6: {
                System.exit(0);
            }
        }
        productDetails();
    }

    /**
     * <p>
     * Gets all the products
     * </p>
     */
    private void getAllProducts() {
        System.out.println("Get the all products");
        final Set<Product> amazons = PRODUCT_CONTROLLER.getAllProducts();

        System.out.println(amazons);
    }

    /**
     * <p>
     * Gets the product
     * </p>
     */
    private void getProduct() {
        System.out.println("Read the one product");
        final Product amazon = PRODUCT_CONTROLLER.readProduct(getProductId());

        System.out.println(amazon.getId());
        System.out.println(amazon.getName());
        System.out.println(amazon.getPrice());
        System.out.println(amazon.getCategory());
    }

    /**
     * <p>
     * Deletes the product
     * </p>
     */
    private void deleteProduct() {
        System.out.println("Delete the product");

        if (PRODUCT_CONTROLLER.deleteProduct(getProductId())) {
            System.out.println("Product deleted successfully");
        } else {
            System.out.println("Product deleted failed");
        }
    }

    /**
     * <p>
     * Updates the product
     * </p>
     */
    private void updateProduct() {
        final Product amazon = new Product();

        System.out.println("Update the products");
        System.out.println("Enter the product Id");
        amazon.setId(getProductId());
        System.out.println("Enter the product name");
        amazon.setName(SCANNER.next());
        System.out.println("Enter the price");
        amazon.setPrice(SCANNER.nextDouble());

        if (PRODUCT_CONTROLLER.updateProduct(amazon)) {
            System.out.println("Product updated");
        } else {
            System.out.println("Product updated failed");
        }
    }

    /**
     * <p>
     * Create the product
     * </p>
     */
    private void addProduct() {
        final Product product = new Product();

        System.out.println("Create a products");
        System.out.println("Enter the product Id");
        product.setId(SCANNER.next());
        System.out.println("Enter the product name");
        product.setName(SCANNER.next());
        System.out.println("Enter the price");
        product.setPrice(SCANNER.nextDouble());
        product.setCategory(getCategory());

        if (PRODUCT_CONTROLLER.createProduct(product)) {
            System.out.println("Product created successfully");
        } else {
            System.out.println("product created failed");
        }
    }

    /**
     * <p>
     * Gets the product Id
     * </p>
     * <p>
     * return product Id
     */
    private String getProductId() {
        System.out.println("Enter the product id");

        return SCANNER.next();
    }

    /**
     * <p>
     * Get the category of products
     * </p>
     * <p>
     * return category Id
     */
    private String getCategory() {
        System.out.println("Enter the product category 1.Electronics, 2.Vehicle, 3.Fashion, 4.APPLIANCES, 5.Sports, 6.Toys");
        final String categoryId = SCANNER.next();

        if (!PRODUCT_VALIDATION.checkCategory(categoryId)) {
            return null;
        }
        return getCategory();
    }
}