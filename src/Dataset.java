import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.Integer.compare;

public class Dataset {
    ArrayList<Game> data; // lista de videojuegos
    public String sortedByAttribute = ""; // atributo por el que está ordenado

    public Dataset(ArrayList<Game> data) {
        this.data = data;
    }

    public ArrayList<Game> getGames() {
        return data;
    }


    public ArrayList<Game> getGamesByPrice(ArrayList<Game> lista, int price) { // Busqueda binaria por precio

        if (sortedByAttribute.equals("price")) { // Si el dataset está ordenado por precio

            Game prueba = new Game("", "", price, 0);

            Comparator<Game> comparatorPrice = Comparator.comparingInt(Game::getPrice);

            int indice = Collections.binarySearch(lista, prueba, comparatorPrice);
            ArrayList<Game> coincidencias = new ArrayList<>();

            if (indice >= 0) {
                coincidencias.add(lista.get(indice));

                // Buscar a la izquierda
                int i = indice - 1;
                while (i >= 0 && lista.get(i).getPrice() == price) {
                    coincidencias.add(lista.get(i));
                    i--;
                }

                // Buscar a la derecha
                int j = indice + 1;
                while (j < lista.size() && lista.get(j).getPrice() == price) {
                    coincidencias.add(lista.get(j));
                    j++;
                }
            }
            return coincidencias;

        } else {
            // Búsqueda lineal
            ArrayList<Game> games = new ArrayList<>();
            for (Game g1 : lista) {
                if (g1.getPrice() == price) {
                    games.add(g1);
                }
            }
            return games;
        }
    }

    public ArrayList<Game> getGamesByQuality(ArrayList<Game> lista, int quality) {

        if (sortedByAttribute.equals("quality")) {

            Game prueba = new Game("", "", 0, quality);

            Comparator<Game> comparatorQuality = Comparator.comparingInt(Game::getQuality);

            int indice = Collections.binarySearch(lista, prueba, comparatorQuality);
            ArrayList<Game> coincidencias = new ArrayList<>();

            if (indice >= 0) {
                coincidencias.add(lista.get(indice));

                int i = indice - 1;
                while (i >= 0 && lista.get(i).getQuality() == quality) {
                    coincidencias.add(lista.get(i));
                    i--;
                }

                int j = indice + 1;
                while (j < lista.size() && lista.get(j).getQuality() == quality) {
                    coincidencias.add(lista.get(j));
                    j++;
                }
            }
            return coincidencias;

        } else {
            ArrayList<Game> games = new ArrayList<>();
            for (Game g1 : lista) {
                if (g1.getQuality() == quality) {
                    games.add(g1);
                }
            }
            return games;
        }
    }

    ArrayList<Game> getGamesByQuality(int quality){//Busqueda binaria por calidad

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

    public ArrayList<Game> getGamesByCategory(ArrayList<Game> lista, String category){//Busqueda  binaria por categoria

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

    ArrayList<Game> getGamesByPriceRange(int lowerPrice, int higherPrice){//Busqueda binaria por Rango

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
            ArrayList<Game> games = new ArrayList<>();//Arreglos con los juegos buscados dentro del rango
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
            selectionSort(data, attribute);
        }else if (algorithm.equals("mergeSort")) {//O(n logn)
            this.data = mergeSort(data, attribute);
        }else if (algorithm.equals("quickSort")) {
            quickSort(data, 0, data.size() - 1, attribute);
        }else{//ordenamiento por Collections.sort()
            CollectionSort(data, attribute);
        }

        this.sortedByAttribute = attribute;
        return data;//retorna el arreglo ordenado
    }
    ArrayList<Game> BubbleSort(ArrayList<Game> data, String attribute){//O(n^2)
        int n = data.size();
        boolean verificador;

        for (int i = 0; i < n - 1; i++) {
            verificador = false;

            for (int j = 0; j < n - 1 - i; j++) {
                boolean verificador2 = false;

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

    ArrayList<Game> InsertionSort(ArrayList<Game> data, String attribute) {
        int n = data.size();

        for (int i = 1; i < n; i++) {
            Game actual = data.get(i);
            int j = i - 1;

            while (j >= 0 && debeIntercambiar(data.get(j), actual, attribute)) {
                data.set(j + 1, data.get(j));  
                j--;
            }

            data.set(j + 1, actual);  
        }

        return data;
    }
    private boolean debeIntercambiar(Game g1, Game g2, String attribute) {
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

    ArrayList<Game> selectionSort(ArrayList<Game> data, String attribute) {
    int n = data.size();

    for (int i = 0; i < n - 1; i++) {
        int minimo = i;

        for (int j = i + 1; j < n; j++) {
            if (debeIntercambiar(data.get(minimo), data.get(j), attribute)) {
                minimo = j;
            }
        }

        if (minimo!= i) {
            Game temp = data.get(i);
            data.set(i, data.get(minimo));
            data.set(minimo, temp);
        }
    }

    return data;
}

//4)
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

       
        while (i < left.size()) merged.add(left.get(i++));
        while (j < right.size()) merged.add(right.get(j++));

        return merged;
    }

    ArrayList<Game> quickSortPublic(ArrayList<Game> data, String attribute) {
        quickSort(data, 0, data.size() - 1, attribute);
        return data;
    }

    private void quickSort(ArrayList<Game> data, int low, int high, String attribute) {
        if (low < high) {
            int pi = partition(data, low, high, attribute);

            if (low < pi - 1) {
                quickSort(data, low, pi - 1, attribute);
            }
            if (pi < high) {
                quickSort(data, pi, high, attribute);
            }
        }
    }

    private int partition(ArrayList<Game> data, int low, int high, String attribute) {
       
        Game pivot = data.get(low + (high - low) / 2);

        int i = low;
        int j = high;

        while (i <= j) {
            while (debeIntercambiar(pivot, data.get(i), attribute)) i++;
            while (debeIntercambiar(data.get(j), pivot, attribute)) j--;

            if (i <= j) {
                Game temp = data.get(i);
                data.set(i, data.get(j));
                data.set(j, temp);
                i++;
                j--;
            }
        }
        return i;
    }

    ArrayList<Game> CollectionSort(ArrayList<Game> data, String attribute) {
        switch (attribute) {
            case "price":
                data.sort(Comparator.comparingInt(Game::getPrice));
                break;
            case "quality":
                data.sort(Comparator.comparingInt(Game::getQuality));
                break;
            case "category":
                data.sort(Comparator.comparing(Game::getCategory));
                break;
            default:
                throw new IllegalArgumentException("Atributo no válido: " + attribute);
        }
        return data;
    }
    public void countingSort(ArrayList<Game> games) {
        int maxQuality = 100;
        int[] count = new int[maxQuality + 1];

       
        for (Game g : games) {
            count[g.getQuality()]++;
        }

        
        for (int i = 1; i <= maxQuality; i++) {
            count[i] += count[i - 1];
        }

        
        Game[] output = new Game[games.size()];
        for (int i = games.size() - 1; i >= 0; i--) {
            Game g = games.get(i);
            int q = g.getQuality();
            output[count[q] - 1] = g;
            count[q]--;
        }

       
        for (int i = 0; i < games.size(); i++) {
            games.set(i, output[i]);
        }

        this.sortedByAttribute = "quality";
    }

    public static void main(String[] args) {

        ArrayList<Game> juegos = new ArrayList<>();
        juegos.add(new Game("juego1", "Action", 5500, 80));
        juegos.add(new Game("juego2", "shooter", 40000, 70));
        juegos.add(new Game("juego3", "Action", 69800, 90));
        juegos.add(new Game("juego4", "transilvania", 30, 60));
        juegos.add(new Game("juego5", "Adventure", 500, 80));

        Dataset dataset = new Dataset(juegos);


        System.out.println("BubbleSort por price:");
        ArrayList<Game> sortedBubble = dataset.BubbleSort(new ArrayList<>(juegos), "price");
        for (Game game : sortedBubble) {
            System.out.println(game.imprimir());
        }

        
        System.out.println("\nInsertionSort por quality:");
        ArrayList<Game> sortedInsertion = dataset.InsertionSort(new ArrayList<>(juegos), "quality");
        for (Game game : sortedInsertion) {
            System.out.println(game.imprimir());
        }

        
        System.out.println("\nSelectionSort por category:");
        ArrayList<Game> sortedSelection = dataset.selectionSort(new ArrayList<>(juegos), "category");
        for (Game game : sortedSelection) {
            System.out.println(game.imprimir());
        }

       
        System.out.println("\nMergeSort por price:");
        ArrayList<Game> sortedMerge = dataset.mergeSort(new ArrayList<>(juegos), "price");
        for (Game game : sortedMerge) {
            System.out.println(game.imprimir());
        }

      
        System.out.println("\nQuickSort por quality:");
        ArrayList<Game> sortedQuick = new ArrayList<>(juegos);
        dataset.quickSortPublic(sortedQuick, "quality");
        for (Game game : sortedQuick) {
            System.out.println(game.imprimir());
        }

       
        System.out.println("\nCollectionSort por category:");
        ArrayList<Game> sortedCollection = dataset.CollectionSort(new ArrayList<>(juegos), "category");
        for (Game game : sortedCollection) {
            System.out.println(game.imprimir());
        }
    }

}

