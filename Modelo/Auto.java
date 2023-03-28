package Modelo;

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

    /**
     * 
     * @param nombre
     * @param anio
     * @param precioVenta
     * @param precioActual
     * @param kilometraje
     * @param tipoCombustible
     * @param tipoVendedor
     * @param transmision
     * @param propietarios
     */
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

    /**
     * obtiene el nombre del objeto
     * @return String 
     */
    public String getNombre() {
        return nombre;
    }


    /**
     * establece el nombre del objeto
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * obtiene el anio del auto
     * @return int 
     */
    public int getAnio() {
        return anio;
    }
    
    /**
     * establece el anio del auto
     * @param anio
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * obtiene el precio de venta del auto
     * @return double
     */
    public double getPrecioVenta() {
        return precioVenta;
    }

    /** 
     * establece el precio de venta del auto
     */
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * obtiene el precio actual del auto
     * @return double
     */
    public double getPrecioActual() {
        return precioActual;
    }

    /**
     * establece el precio actual del auto
     * @param precioActual
     */
    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }
    /**
     * obtiene el kilometraje del auto
     * @return int 
     */
    public int getKilometraje() {
        return kilometraje;
    }

    /**
     * establece el kilometraje del auto
     * @param kilometraje
     */
    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }
    /**
     * obtiene el tipo de combustible del auto
     * @return String 
    */
    public String getTipoCombustible() {
        return tipoCombustible;
    }

    /**
     * establece el tipo de combustible del auto
     * @param tipoCombustible
     */
    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    /**obtiene el tipo de vendedor del auto
     * 
     * @return String 
    */
    public String getTipoVendedor() {
        return tipoVendedor;
    }

    /**
     * establece el tipo de vendedor del auto
     * @param tipoVendedor
     */
    public void setTipoVendedor(String tipoVendedor) {
        this.tipoVendedor = tipoVendedor;
    }

    /**
     * obtiene la transimision del auto
     * @return String 
    */
    public String getTransmision() {
        return transmision;
    }

    /**
     * establece la transimision del auto
     * @param transmision
     */
    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    /**
     * obtiene los propietarios que ha tenido el auto
     * @return int 
     */
    public int getPropietarios() {
        return propietarios;
    }

    /**
     * establece los propietarios que ha tenido el auto
     * @param propietarios
     */
    public void setPropietarios(int propietarios) {
        this.propietarios = propietarios;
    }


}
