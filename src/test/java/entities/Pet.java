package entities;

import java.util.LinkedHashMap;
import java.util.List;

public class Pet {
    private LinkedHashMap<String, Object> pet = new LinkedHashMap<>();

    public Pet(Category category, Object name, List<Object> photoUrls,
               List<LinkedHashMap<String, Object>> tags, Object status){
        pet.put("category", category.get());
        pet.put("name", name);
        pet.put("photoUrls", photoUrls);
        pet.put("tags", tags);
        pet.put("status", status);

        public void setPet (Category category, Object name, List<Object>){
            pet.put(key,value);
        }

        public void set (LinkedHashMap<String, Object> map){
            pet.putAll(map);
        }

        public LinkedHashMap<String, Object> get() {
            return pet;
        }

    }
}
