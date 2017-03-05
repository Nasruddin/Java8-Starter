import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nasir on 12/12/15.
 */
public class LambdaTest {

    final static List<String> cityList = Arrays.asList("Bangalore", "Kolkata", "Delhi");
    final static List<BigDecimal> prices = Arrays.asList(
            new BigDecimal("10"), new BigDecimal("20"), new BigDecimal("30"),
            new BigDecimal("15"), new BigDecimal("23")
    );

    public static void main(String[] args) {

        System.out.println("Found Bangalore? " + isCityExist());
        System.out.println("Found Kolkata? " +cityList.contains("Kolkata"));

        System.out.println("Total Discounted Price: " +totalDiscountedPrices());
        System.out.println("Total Discounted Price in Java 8 : " +totalDiscountedPrice8Way());
    }

    public static boolean isCityExist() {

        boolean found = false;

        for (String city:   cityList) {
            if (city.equals("Bangalore1")){
                found = true;
                break;
            }
        }
        return found;
    }


    public  static BigDecimal totalDiscountedPrices() {

        BigDecimal totalDiscountedPrice = BigDecimal.ZERO;

        for (BigDecimal price : prices) {
            if(price.compareTo(BigDecimal.valueOf(20))>0) {
                totalDiscountedPrice =
                        totalDiscountedPrice.add(price.multiply(BigDecimal.valueOf(0.9)));

            }
        }

        return totalDiscountedPrice;
    }

    public static BigDecimal totalDiscountedPrice8Way() {

        return prices.stream()
              .filter(price -> price.compareTo(BigDecimal.valueOf(20))> 0)
              .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
              .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
