package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class pedido {
  private String cliente;
  private String CodigoPostal;
  private List<Integer> prioridades;
  private int Zona;
  private int Urgencia;

  public pedido(String cliente, String codigoPostal, List<Integer> prioridades) {
    this.cliente = cliente;
    this.CodigoPostal = codigoPostal;
    this.prioridades = prioridades;
    this.Zona = Integer.parseInt(codigoPostal);
    int suma = 0;
    for (int i : prioridades) suma += i;
      this.Urgencia = suma;
  }

  public String getCliente() {
    return cliente;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }
  private int calcularZona(String cp) {
    String[] partes = cp.split("-");
    return Integer.parseInt(partes[1]);

  }

  private int calcularUrgencia(String nombre, List<Integer> lista) {
    int sumaMultiplos = 0;
    for (int p : lista) {
      if (p % 3 == 0) {
        sumaMultiplos += p;
      }
    }

    Set<Character> vocalesU = new HashSet<>();
    String n = nombre.toLowerCase();

    for (Character c : n.toCharArray()) {
      if("aeiou".indexOf(c) != -1) {
        vocalesU.add(c);
      }
    }
    return sumaMultiplos + vocalesU.size();
  }

  @Override
  public String toString() {
    return "pedido [cliente=" + cliente + ", CodigoPostal=" + CodigoPostal + ", items=" + items + ", Zona=" + Zona
        + ", Urgencia=" + Urgencia + "]";
  }


  
}
