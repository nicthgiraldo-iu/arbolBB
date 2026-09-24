
public class ArbolInventario{
    private Producto raiz;

    //se crea el constructor y se inicializa vácio, ya que al empezar nuestro arbol aun no tiene raiz
    public ArbolInventario(){
        this.raiz = null;
    }

    //validacion que nos sirve para no tener que recorrer nada si la raiz esta en nula, ya que esto indica 
    //que efectivamente no se han ingresado datos
    public boolean estaVacio() {
        return raiz == null;
    }

    //se piden los datos principales de id y nombre para crear el nodo y empezar con el arbol
    public void insertar(int id, String nombre){
        //se guarda la raiz, con esto se asegura de como guardar el proximo dato
        //menor a la izquierda, mayor a la derecha
        //se utiliza la metodología enseñada de recursividad en los metodos creados
        //se guarda el nodo registrado inmediato para determinar la raiz del siguiente nodo
        raiz = insertarR(raiz, id, nombre);
    }

    //actual => recive el último nodo guardado para determinar donde guardar el siguiente
    //menor a la izquierda, mayor valor a la derecha
    private Producto insertarR(Producto actual, int id, String nombre) {
        //ingresa en este if si es el primer registro, creando el primer nodo o raiz primera de nuestro arbol
        if (actual == null) {
            return new Producto(id, nombre);
        }
        
        //si ya existe un nodo o raiz, se evalúa si va a la izquierda o derecha dependiendo si es mayor o menor
        if (id < actual.getId()) {
            //al detectar que es menor, se guarda el nodo en el izquierdo del nodo actual para crear la ramificacion del arbol
            actual.setIzquierdo(insertarR(actual.getIzquierdo(), id, nombre));
        }
        else if (id > actual.getId()) {
            actual.setDerecho(insertarR(actual.getDerecho(), id, nombre));
        }

        //se retorna el nodo con sus respectivas ramas
        return actual;
    }


}