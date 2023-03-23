public class Auto {
    private String nombre;
    private int anio;
    private double precioVenta;
    private double precioActual;
    private int kilometraje;
    private String tipoCombustible;
    private String tipoVendedor;
    private String transmision;
    private int propietarios;

    public Auto(String nombre, int anio, double precioVenta, double precioActual, int kilometraje,
            String tipoCombustible, String tipoVendedor, String transmision, int propietarios) {
        this.nombre = nombre;
        this.anio = anio;
        this.precioVenta = precioVenta;
        this.precioActual = precioActual;
        this.kilometraje = kilometraje;
        this.tipoCombustible = tipoCombustible;
        this.tipoVendedor = tipoVendedor;
        this.transmision = transmision;
        this.propietarios = propietarios;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public double getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    public double getPrecioActual() {
        return precioActual;
    }
    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }
    public int getKilometraje() {
        return kilometraje;
    }
    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }
    public String getTipoCombustible() {
        return tipoCombustible;
    }
    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
    public String getTipoVendedor() {
        return tipoVendedor;
    }
    public void setTipoVendedor(String tipoVendedor) {
        this.tipoVendedor = tipoVendedor;
    }
    public String getTransmision() {
        return transmision;
    }
    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
    public int getPropietarios() {
        return propietarios;
    }
    public void setPropietarios(int propietarios) {
        this.propietarios = propietarios;
    }


}
