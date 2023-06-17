package com.amazon.view;

import com.amazon.controller.ProductController;
import com.amazon.model.Product;
import com.amazon.view.validation.ProductValidation;

import java.util.Collection;
import java.util.Scanner;

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
        final Collection<Product> products = PRODUCT_CONTROLLER.getAllProducts();

        System.out.println(products);
    }

    /**
     * <p>
     * Gets the product
     * </p>
     */
    private void getProduct() {
        System.out.println("Read the one product");
        final Product product = PRODUCT_CONTROLLER.getProduct(getProductId());

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getCategory());
    }

    /**
     * <p>
     * Deletes the product
     * </p>
     */
    private void deleteProduct() {
        System.out.println("Delete the product");
        System.out.println(PRODUCT_CONTROLLER.deleteProduct(getProductId()) ? ("Product deleted successfully") : ("Product deleted failed"));
    }

    /**
     * <p>
     * Updates the product
     * </p>
     */
    private void updateProduct() {
        final Product product = new Product();

        System.out.println("Update the products");
        System.out.println("Enter the product Id");
        product.setId(getProductId());
        System.out.println("Enter the product name");
        product.setName(SCANNER.next());
        System.out.println("Enter the price");
        product.setPrice(SCANNER.nextDouble());
        System.out.println((PRODUCT_CONTROLLER.updateProduct(product)) ? ("Product updated") : ("Product updated failed"));
    }

    /**
     * <p>
     * Creates the product
     * </p>
     */
    private void addProduct() {
        final Product product = new Product();

        System.out.println("Create a products");
        System.out.println("Enter the product Id");
        product.setId(SCANNER.nextLong());
        System.out.println("Enter the product name");
        product.setName(SCANNER.next());
        System.out.println("Enter the price");
        product.setPrice(SCANNER.nextDouble());
        product.setCategory(getCategory());
        System.out.println((PRODUCT_CONTROLLER.createProduct(product)) ? ("Product created successfully") : ("product created failed"));
    }

    /**
     * <p>
     * Gets the product Id
     * </p>
     * <p>
     * return product Id
     */
    private Long getProductId() {
        System.out.println("Enter the product id");

        return SCANNER.nextLong();
    }

    /**
     * <p>
     * Get the category of products
     * </p>
     * <p>
     * return category Id
     */
    private Integer getCategory() {
        System.out.println("Enter the product category 1.Electronics, 2.Vehicle, 3.Fashion, 4.APPLIANCES, 5.Sports, 6.Toys");
        final int categoryId = SCANNER.nextInt();

        if (!PRODUCT_VALIDATION.checkCategory(categoryId)) {
            return null;
        }
        return getCategory();
    }
}