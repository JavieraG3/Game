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

};
