package utils;
import com.fasterxml.jackson.databind.ObjectMapper;

import oderflow.ProductOrderData;

import java.io.InputStream;

public class JsonReader {
	public static ProductOrderData getOrderData() {

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream is =
                    JsonReader.class.getClassLoader()
                            .getResourceAsStream("products.json");

            return mapper.readValue(is, ProductOrderData.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


