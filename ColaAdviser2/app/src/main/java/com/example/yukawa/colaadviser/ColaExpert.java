package com.example.yukawa.colaadviser;

import java.util.ArrayList;
import java.util.List;

public class ColaExpert {

    List<String> getBrands(String colaType){
        List<String> brands = new ArrayList<>();

        if(colaType.equals("Coca Cola")){
            brands.add("Light");
            brands.add("normal");
        }else{
            brands.add("normal");
        }
        return brands;
    }

}
