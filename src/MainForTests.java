import model.Product;
import repository.ProductsRepository;
import repository.ProductsRepositoryImpl;
import service.ProductsService;
import service.ProductsServiceImpl;

public class MainForTests {

    private static final String OUT_SEPARATOR_STRING = "------------------------------------";

    public static void main(String[] args) {
        ProductsRepository productsRepository = new ProductsRepositoryImpl();
        ProductsService productsService = new ProductsServiceImpl(productsRepository);

        shouldBeTrueWhileAddingNotExistsProduct(productsService, productsRepository);
        shouldBeFalseWhileAddingExistedProduct(productsService, productsRepository);
        shouldBeTrueWhileDeletingExistingProduct(productsService, productsRepository);
        shouldBeFalseWileDeletingNotExistingProduct(productsService, productsRepository);
        shouldBeNameWhileUsingExistingId(productsService, productsRepository);
        shouldBeEmptyStringWhileUsingNotExistingId(productsService, productsRepository);
        shouldBeFilledListWithId1AndId2WhileNameIsExists(productsService, productsRepository);
        shouldBeEmptyListWhileNameNotExists(productsService, productsRepository);
    }

    private static void cleanMapBeforeTest(ProductsRepository productsRepository) {
        productsRepository.getAllProducts().clear();
    }

    private static void shouldBeTrueWhileAddingNotExistsProduct(ProductsService service, ProductsRepository repository) {
        System.out.println("Test: shouldBeTrueWhileAddingNotExistsProduct");
        cleanMapBeforeTest(repository);
        Product product = new Product("Дыня");
        System.out.println(service.addProduct(product));
        System.out.println(service.getName(String.valueOf(1)));
        System.out.println(OUT_SEPARATOR_STRING);
    }

    private static void shouldBeFalseWhileAddingExistedProduct(ProductsService service, ProductsRepository repository) {
        System.out.println("Test: shouldBeFalseWhileAddingExistedProduct");
        cleanMapBeforeTest(repository);
        Product productInMap = new Product("Дыня");
        service.addProduct(productInMap);

        Product product = new Product("Дыня");
        product.setId(String.valueOf(1));
        System.out.println(service.addProduct(product));
        System.out.println(OUT_SEPARATOR_STRING);
    }

    private static void shouldBeTrueWhileDeletingExistingProduct(ProductsService service, ProductsRepository repository) {
        System.out.println("Test: shouldBeTrueWhileDeletingExistingProduct");
        cleanMapBeforeTest(repository);
        Product productInMap = new Product("Дыня");
        service.addProduct(productInMap);
        productInMap.setId(String.valueOf(1));
        System.out.println(service.deleteProduct(productInMap));
        System.out.println(OUT_SEPARATOR_STRING);
    }

    private static void shouldBeFalseWileDeletingNotExistingProduct(ProductsService service, ProductsRepository repository) {
        System.out.println("Test: shouldBeFalseWileDeletingNotExistingProduct");
        cleanMapBeforeTest(repository);
        Product product = new Product("Дыня");
        product.setId(String.valueOf(1));
        System.out.println(service.deleteProduct(product));
        System.out.println(OUT_SEPARATOR_STRING);
    }

    private static void shouldBeNameWhileUsingExistingId(ProductsService service, ProductsRepository repository) {
        System.out.println("Test: shouldBeNameWhileUsingExistingId");
        cleanMapBeforeTest(repository);
        Product product = new Product("Дыня");
        service.addProduct(product);
        System.out.println(service.getName(String.valueOf(1)));
        System.out.println(OUT_SEPARATOR_STRING);
    }

    private static void shouldBeEmptyStringWhileUsingNotExistingId(ProductsService service, ProductsRepository repository) {
        System.out.println("Test: shouldBeEmptyStringWhileUsingNotExistingId");
        cleanMapBeforeTest(repository);
        System.out.println(service.getName(String.valueOf(1)));
        System.out.println(OUT_SEPARATOR_STRING);
    }

    private static void shouldBeFilledListWithId1AndId2WhileNameIsExists(ProductsService service, ProductsRepository repository) {
        System.out.println("Test: shouldBeFilledListWithId1AndId2WhileNameIsExists");
        cleanMapBeforeTest(repository);

        Product product1 = new Product("Дыня");
        service.addProduct(product1);
        Product product2 = new Product("Дыня");
        service.addProduct(product2);
        Product product3 = new Product("Арбуз");
        service.addProduct(product3);
        System.out.println(service.findByName("Дыня"));
        System.out.println(OUT_SEPARATOR_STRING);
    }

    private static void shouldBeEmptyListWhileNameNotExists(ProductsService service, ProductsRepository repository) {
        System.out.println("Test: shouldBeEmptyListWhileNameNotExists");
        cleanMapBeforeTest(repository);
        System.out.println(service.findByName("Дыня"));
        System.out.println(OUT_SEPARATOR_STRING);
    }
}