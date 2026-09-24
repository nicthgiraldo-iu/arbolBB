
public class ArbolInventario {
    private Producto raiz;

    // se crea el constructor y se inicializa vácio, ya que al empezar nuestro arbol
    // aun no tiene raiz
    public ArbolInventario() {
        this.raiz = null;
    }

    // validacion que nos sirve para no tener que recorrer nada si la raiz esta en
    // nula, ya que esto indica
    // que efectivamente no se han ingresado datos
    public boolean estaVacio() {
        return raiz == null;
    }

    // se piden los datos principales de id y nombre para crear el nodo y empezar
    // con el arbol
    public void insertar(int id, String nombre) {
        // se guarda la raiz, con esto se asegura de como guardar el proximo dato
        // menor a la izquierda, mayor a la derecha
        // se utiliza la metodología enseñada de recursividad en los metodos creados
        // se guarda el nodo registrado inmediato para determinar la raiz del siguiente
        // nodo
        raiz = insertarR(raiz, id, nombre);
    }

    // actual => recive el último nodo guardado para determinar donde guardar el
    // siguiente
    // menor a la izquierda, mayor valor a la derecha
    private Producto insertarR(Producto actual, int id, String nombre) {
        // ingresa en este if si es el primer registro, creando el primer nodo o raiz
        // primera de nuestro arbol
        if (actual == null) {
            return new Producto(id, nombre);
        }

        // si ya existe un nodo o raiz, se evalúa si va a la izquierda o derecha
        // dependiendo si es mayor o menor
        if (id < actual.getId()) {
            // al detectar que es menor, se guarda el nodo en el izquierdo del nodo actual
            // para crear la ramificacion del arbol
            actual.setIzquierdo(insertarR(actual.getIzquierdo(), id, nombre));
        } else if (id > actual.getId()) {
            actual.setDerecho(insertarR(actual.getDerecho(), id, nombre));
        }

        // se retorna el nodo con sus respectivas ramas
        return actual;
    }

    public void mostrarInventario() {
        // se subdivide el mostrar ya que se necesita reutilizar el metodo para los
        // nodos a la izquierda y derecha de la raiz
        mostrarInventarioR(raiz);
    }

    private void mostrarInventarioR(Producto nodo) {
        // si la raiz o nodo esta vacía no muestra nada
        if (nodo != null) {
            // se muestran los nodos registrados a la izquierda
            mostrarInventarioR(nodo.getIzquierdo());
            // se muestra el nodo o raiz actual
            imprimir(nodo);
            // todos los nodos registrados a la derecha
            mostrarInventarioR(nodo.getDerecho());
        }
    }

    public String buscarPorID(int id) {
        // se aplica un if corto donde si el metodo buscarR devuelve un verdadero indica
        // que se encontro el nodo de lo contrario
        // mostrara que el ID no existe
        return buscarR(raiz, id) ? "ID encontrado en el sistema." : "El ID no existe.";
    }

    private boolean buscarR(Producto actual, int id) {
        // se evalua la raiz o nodo actual, si es nulo devuelve de inmediato un false
        if (actual == null)
            return false;
        // al estar rotando el valor de "actual" esta validacion nos ayuda a determinar
        // se localiza el id y mostrar el producto
        if (id == actual.getId()) {
            imprimir(actual);
            return true;
        }
        // con esto verifica de inmediato si hay que buscar en los nodos izquierdos o
        // derechos, evaluado si el ID actual es menor
        if (id < actual.getId()) {
            // se vuelve a llamar el metodo buscarR pero cambiando el valor de "actual"
            // para que realice nuevamente la validación en la linea 83
            return buscarR(actual.getIzquierdo(), id);
        } else {
            return buscarR(actual.getDerecho(), id);
        }
    }

    private void imprimir(Producto nodo) {
        System.out.println("ID producto: " + nodo.getId() + " | Producto: " + nodo.getNombre());
    }

}