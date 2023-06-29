package com.amazon.view;

import com.amazon.controller.ProductController;
import com.amazon.model.Category;
import com.amazon.model.Product;
import com.amazon.view.validation.ProductValidation;

import java.util.Collection;
import java.util.List;
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
        System.out.println("Choose 1 to create the product, 2 to update the product, 3 to delete the product, 4 to get one product, 5 to get all products, 6 to exit");
        final int input = SCANNER.nextInt();

        switch (input) {
            case 1: {
                this.addProduct();
                break;
            }
            case 2: {
                this.updateProduct();
                break;
            }
            case 3: {
                this.deleteProduct();
                break;
            }
            case 4: {
                this.getProduct();
                break;
            }
            case 5: {
                this.getAllProducts();
                break;
            }
            case 6: {
                System.exit(0);
            }
        }
        this.productDetails();
    }

    /**
     * <p>
     * Gets all the products
     * </p>
     */
    private void getAllProducts() {
        System.out.println("Get the all products");
        final Collection<Product> products = PRODUCT_CONTROLLER.getAllProducts();

        for (Product product : products) {
            System.out.println(product);
        }
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
        product.setCategory(getCategories());
        System.out.println((PRODUCT_CONTROLLER.createProduct(product)) ? ("Product created successfully") : ("product created failed"));
    }

    /**
     * <p>
     * Gets the product Id
     * </p>
     * <p>
     * return {@link Long} product Id
     */
    private Long getProductId() {
        System.out.println("Enter the product id");

        return SCANNER.nextLong();
    }

    /**
     * <p>
     * Gets the category of products
     * </p>
     *
     * return The category Id
     */
    public int getCategories() {
        System.out.println("Enter the product category 1.Electronics, 2.Vehicle, 3.Fashion, 4.APPLIANCES, 5.Sports, 6.Toys");
        final int categoryId = SCANNER.nextInt();

        if (PRODUCT_VALIDATION.checkCategory(categoryId)) {
            return categoryId;
        }
        return getCategories();
    }

    public void showAllCategories() {
        final List<Category> lists = List.of(Category.VEHICLE, Category.TOYS, Category.FASHION, Category.APPLIANCES,
                Category.SPORTS, Category.ELECTRONICS);

        for (final Category list : lists) {
            System.out.println(list);
        }
    }
}