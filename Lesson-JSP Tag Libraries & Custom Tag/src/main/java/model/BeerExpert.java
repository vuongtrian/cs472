package model;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {

    public List<String> getBrands(String color) {
        List<String> brands = new ArrayList<>();

        switch (color.toLowerCase()) {
            case "amber":
                brands.add("Jack Amber");
                brands.add("Red Moose");
                break;
            case "light":
                brands.add("Jail Pale Ale");
                brands.add("Gout Stout");
                break;
            case "brown":
                brands.add("Brown Bear Beer");
                brands.add("Bock Brown");
                break;
            case "dark":
                brands.add("Dark Horse");
                brands.add("Black Magic");
                break;
            default:
                brands.add("No recommendations available for this color.");
                break;
        }

        return brands;
    }
}