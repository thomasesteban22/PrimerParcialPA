import Data.Abogados;
import Data.Clientes;

public class Main {
    public static void main(String[] args) {
        Abogados abogado = new Abogados("Pepe", "Amaya", 232323, 33995);
        Clientes cliente = new Clientes("Juan", "Pérez", 123456, 5551234);
        cliente.guardarEnBaseDeDatos();
        abogado.guardarEnBaseDeDatos();
    }
}
