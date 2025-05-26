import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.Integer.compare;

public class Dataset{
  ArrayList<Game> data; //lista de videojuegos
  public String sortedByAttribute; //indica x cual campo esta ordenado actualmente el dataset

  Dataset(ArrayList<Game> data){
      this.data = data;
  }

ArrayList<Game> getGamesByPrice(int price) {
//BUSQUEDA BINARIA divide la lista x la mitad

    if(sortedByAttribute.equals("price")){//Si el dataset está ordenado por precio

//crear juego de referencia para buscar
        Game prueba = new Game("","",price,0);

//Crear comparador de precios
        Comparator<Game> comparatorPrice = (g1,g2) -> compare(g1.getPrice(), g2.getPrice());
        int indice = Collections.binarySearch(data, prueba, comparatorPrice);//devuelve el indice no el objeto
        ArrayList<Game> coincidencias = new ArrayList<>();//almacena todos los juegos con ese precio
        if(indice >= 0){//si se encontro
            System.out.println("El precio del juego coincide con el parametro entregado");
            coincidencias.add(data.get(indice));// data.get(indice) devuelve el objeto como tal

//BUSCAR A LA IZQUIERDA MISMO PRECIO
            int i = indice - 1;
            while(i >= 0 && data.get(i).getPrice() == price){
                coincidencias.add(data.get(i));
                i--;
            }

//BUSCAR A LA DERECHA MISMO PRECIO
            int j = indice + 1;
            while(j < data.size() && data.get(j).getPrice() == price){
                coincidencias.add(data.get(j));
                j++;
            }
        }
        return coincidencias;

    }else{
//BUSQUEDA LINEAL RECORRE 1 X 1 LA LISTA
        ArrayList<Game> games = new ArrayList<>();
        for(Game g1 : data){
            if(g1.getPrice() == price){
                games.add(g1);
            }
        }
        return games;
    }
}
ArrayList<Game> getGamesByQuality(int quality){
    //BUSQUEDA BINARIA divide la lista x la mitad

    if(sortedByAttribute.equals("quality")){//Si el dataset está ordenado por calidad

//crear juego de referencia para buscar
        Game prueba = new Game("","",0,quality);

//Crear comparador de calidad
        Comparator<Game> comparatorQuality = (g1,g2) -> compare(g1.getQuality(), g2.getQuality());
        int indice = Collections.binarySearch(data, prueba, comparatorQuality);//devuelve el indice no el objeto
        ArrayList<Game> coincidencias = new ArrayList<>();//almacena todos los juegos con esa calidad
        if(indice >= 0){//si se encontro
            System.out.println("La calidad del juego coincide con el parametro entregado");
            coincidencias.add(data.get(indice));// data.get(indice) devuelve el objeto como tal

//BUSCAR A LA IZQUIERDA MISMA CALIDAD
            int i = indice - 1;
            while(i >= 0 && data.get(i).getQuality() == quality){
                coincidencias.add(data.get(i));
                i--;
            }

//BUSCAR A LA DERECHA MISMA CALIDAD
            int j = indice + 1;
            while(j < data.size() && data.get(j).getQuality() == quality){
                coincidencias.add(data.get(j));
                j++;
            }
        }
        return coincidencias;

    }else{
//BUSQUEDA LINEAL RECORRE 1 X 1 LA LISTA
        ArrayList<Game> games = new ArrayList<>();
        for(Game g1 : data){
            if(g1.getQuality() == quality){
                games.add(g1);
            }
        }
        return games;
    }
}
ArrayList<Game> getGamesByCategory(String category){
//BUSQUEDA BINARIA divide la lista x la mitad

    if(sortedByAttribute.equals("category")){//Si el dataset está ordenado por precio

//crear juego de referencia para buscar
        Game prueba = new Game("",category,0,0);

//Crear comparador de categorias
        Comparator<Game> comparatorCategory = (g1,g2) -> (g1.getCategory().compareTo(g2.getCategory()));
        int indice = Collections.binarySearch(data, prueba, comparatorCategory);//devuelve el indice no el objeto
        ArrayList<Game> coincidencias = new ArrayList<>();//almacena todos los juegos con esa categoria
        if(indice >= 0){//si se encontro
            System.out.println("La categoria del juego coincide con el parametro entregado");
            coincidencias.add(data.get(indice));// data.get(indice) devuelve el objeto como tal

//BUSCAR A LA IZQUIERDA MISMA CATEGORIA
            int i = indice - 1;
            while(i >= 0 && data.get(i).getCategory().equals(category)){
                coincidencias.add(data.get(i));
                i--;
            }

//BUSCAR A LA DERECHA MISMA CATEGORIA
            int j = indice + 1;
            while(j < data.size() && data.get(j).getCategory().equals(category)){
                coincidencias.add(data.get(j));
                j++;
            }
        }
        return coincidencias;

    }else{
//BUSQUEDA LINEAL RECORRE 1 X 1 LA LISTA
        ArrayList<Game> games = new ArrayList<>();
        for(Game g1 : data){
            if(g1.getCategory().equals(category)){
                games.add(g1);
            }
        }
        return games;
    }
}

ArrayList<Game> getGamesByPriceRange(int lowerPrice, int higherPrice){
//BUSQUEDA BINARIA POR RANGO
if(sortedByAttribute.equals("price")){//Si el dataset está ordenado por precio

//crear juego de referencia para buscar el lowerprice
    Game prueba = new Game("","",lowerPrice,0);

//Crear comparador de precios
    Comparator<Game> comparatorPrice = (g1,g2) -> compare(g1.getPrice(), g2.getPrice());
    int indice = Collections.binarySearch(data, prueba, comparatorPrice);//devuelve el indice no el objeto
    ArrayList<Game> coincidencias = new ArrayList<>();//almacena todos los juegos en el rango
    if(indice >= 0){//si se encontro el lowerprice
        System.out.println("El precio del juego coincide con el lowerPrice");
        coincidencias.add(data.get(indice));// data.get(indice) devuelve el objeto como tal

//BUSCAR A LA DERECHA DE LOWERPRICE HASTA HIGHERPRICE
        int i = indice;
        while(i < data.size() && data.get(i).getPrice() <= higherPrice){
            coincidencias.add(data.get(i));
            i++;
        }
    }else if(indice<0){ //no encontro el loweprice, pero puede haber un precio en el rango
      int insertPoint = -(indice+1); //se debe calcular punto de insercion
      while(insertPoint < data.size() && data.get(insertPoint).getPrice() <= higherPrice){
          coincidencias.add(data.get(insertPoint));
          insertPoint++;
      }
    }
    return coincidencias;

}else{

//BUSQUEDA LINEAL RECORRE 1 X 1 LA LISTA
  ArrayList<Game> games = new ArrayList<>();
    for(Game g1 : data){
       if(g1.getPrice() >= lowerPrice && g1.getPrice() <= higherPrice){//busca en el rango
          games.add(g1);
        }
      }
        return games;
    }
}
ArrayList<Game> sortByAlgorithm(String algorithm, String attribute){

        attribute = attribute.toLowerCase();
        if(attribute != "price" && attribute != "category" && attribute != "quality"){
            attribute = "price";
        }

        if (algorithm.equals("bubblesort")){
            BubbleSort(data, attribute);
        }else if (algorithm.equals("insertionSort")) {
            InsertionSort(data, attribute);
        }else if (algorithm.equals("selectionSort")) {
            InsertionSort(data, attribute);
        }else if (algorithm.equals("mergeSort")) {//O(n logn)
            this.data = mergeSort(data, attribute);
        }else if (algorithm.equals("quickSort")) {
            quickSort(data, 0, data.size() - 1, attribute);
        }else{//ordenamiento por Collections.sort()

            if (attribute.equals("price")) {
                data.sort(Comparator.comparingInt(Game::getPrice));
            } else if (attribute.equals("quality")) {
                data.sort(Comparator.comparingInt(Game::getQuality));
            } else if (attribute.equals("category")) {
                data.sort(Comparator.comparing(Game::getCategory));
            }
        }

        this.sortedByAttribute = attribute;
        return data;//retorna el arreglo ordenado
    }
//formas de ordenmiento
//1)
    ArrayList<Game> BubbleSort(ArrayList<Game> data, String attribute){//O(n^2)
        int n = data.size();
        boolean verificador;

        for (int i = 0; i < n - 1; i++) {
            verificador = false;

            for (int j = 0; j < n - 1 - i; j++) {
                boolean verificador2 = false;

                //Determina mediante que va ordenar
                if (attribute.equals("price")) {
                    verificador2 = data.get(j).getPrice() > data.get(j + 1).getPrice();
                }
                else if (attribute.equals("quality")) {
                    verificador2 = data.get(j).getQuality() > data.get(j + 1).getQuality();
                }
                else if (attribute.equals("category")) {
                    verificador2 = data.get(j).getCategory().compareTo(data.get(j + 1).getCategory()) > 0;
                }
                if (verificador2) {
                    // Intercambiar de juegos
                    Game temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                    verificador = true;
                }
            }
            if (!verificador) break;
        }
        return data;
    }
//2)
    ArrayList<Game> InsertionSort(ArrayList<Game> data, String attribute) { //O(n^2)
        int n = data.size();

        for (int i = 1; i < n; i++) {
            Game actual = data.get(i);
            int j = i - 1;

            // Comparación según el atributo
            while (j >= 0 && debeIntercambiar(data.get(j), actual, attribute)) {
                data.set(j + 1, data.get(j));  // Mueve el elemento una posición a la derecha
                j--;
            }

            data.set(j + 1, actual);  // Inserta el elemento en su lugar correcto
        }

        return data;
    }
    private boolean debeIntercambiar(Game g1, Game g2, String attribute) {//se usa en InsertonSort y en QuickSort
        switch (attribute) {
            case "price":
                return g1.getPrice() > g2.getPrice();
            case "quality":
                return g1.getQuality() > g2.getQuality();
            case "category":
                return g1.getCategory().compareTo(g2.getCategory()) > 0;
            default:
                throw new IllegalArgumentException("Atributo no válido: " + attribute);
        }
    }
//3)
    ArrayList<Game> mergeSort(ArrayList<Game> data, String attribute) {//O(n logn)
        if (data.size() <= 1) return data;

        int mid = data.size() / 2;

        ArrayList<Game> left = new ArrayList<>(data.subList(0, mid));
        ArrayList<Game> right = new ArrayList<>(data.subList(mid, data.size()));

        left = mergeSort(left, attribute);
        right = mergeSort(right, attribute);

        return merge(left, right, attribute);
    }
    private ArrayList<Game> merge(ArrayList<Game> left, ArrayList<Game> right, String attribute) {
        ArrayList<Game> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            boolean condition ;
            switch (attribute) {
                case "price":
                    condition = left.get(i).getPrice() <= right.get(j).getPrice();
                    break;
                case "quality":
                    condition = left.get(i).getQuality() <= right.get(j).getQuality();
                    break;
                case "category":
                    condition = left.get(i).getCategory().compareTo(right.get(j).getCategory()) <= 0;
                    break;
                default:
                    throw new IllegalArgumentException("Atributo no válido: " + attribute);
            }

            if (condition) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        // Agregar los elementos restantes
        while (i < left.size()) merged.add(left.get(i++));
        while (j < right.size()) merged.add(right.get(j++));

        return merged;
    }
//4)
    private void quickSort(ArrayList<Game> data, int low, int high, String attribute) {
        if (low < high) {
            int pi = partition(data, low, high, attribute);

            quickSort(data, low, pi - 1, attribute);
            quickSort(data, pi + 1, high, attribute);
        }
    }

    private int partition(ArrayList<Game> data, int low, int high, String attribute) {
        Game pivot = data.get(high);  // Elegimos el último elemento como pivote
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Si el elemento j debe ir antes que el pivote según el atributo
            if (!debeIntercambiar(data.get(j), pivot, attribute)) {
                i++;
                // Intercambiar data[i] y data[j]
                Game temp = data.get(i);
                data.set(i, data.get(j));
                data.set(j, temp);
            }
        }
        // Intercambiar data[i+1] y data[high] (colocar pivote en su lugar)
        Game temp = data.get(i + 1);
        data.set(i + 1, data.get(high));
        data.set(high, temp);

        return i + 1;
    }

  
};
