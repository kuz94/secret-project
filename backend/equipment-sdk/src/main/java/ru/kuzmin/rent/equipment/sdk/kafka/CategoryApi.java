package ru.kuzmin.rent.equipment.sdk.kafka;

import ru.kuzmin.rent.equipment.sdk.entities.Category;

@Component
public class CategoryApi {
    private final static String REQUEST_TOPIC = "category_request";
    private final static String RESPONSE_TOPIC = "category_request";

    @Autowired
    public CategoryApi() {

    }

    public Category loadById(Long categoryId) {
        return null;
    }
}
