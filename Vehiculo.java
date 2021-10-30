public class Vehiculo {
    private int id; // 4 bytes
    private String nombre; // 20 * 2 = 40 + 2 = 42
    private String marca; // 20 * 2 = 40 + 2 = 42
    private String modelo; // 15 * 2 = 30 + 2 = 32
    private String color;  // 15 * 2 = 30 + 2 = 32
    private float precio; // 4 bytes         TOTAL = 4 + 40 + 40 + 30 + 30 + 4 = 148 + 8 = 156 bytes

    //Crear constructor vehiculo
    public Vehiculo(int id, String nombre, String marca, String modelo, String color, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
    }

    //Crear constructor vacio
    public Vehiculo() {
    }

    //Crear los metodos getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
