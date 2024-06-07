package ficherosXML.bolsa;

import java.util.ArrayList;

/**
 *
 * @author Thomas Freitas
 */
public class Bolsa {
    private String dia;
    private String hora;
    private ArrayList<Empresa> empresas;

    public Bolsa() {
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }


    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(ArrayList<Empresa> empresas) {
        this.empresas = empresas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        empresas.forEach(e -> sb.append("\n").append(e.toString()));
        String s = sb.toString();
        return "Bolsa{" + "dia=" + dia + ", hora="+ hora + ", empresas=" + s+ '}';
    }
}
