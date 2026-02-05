package controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import models.Pedido;

public class PedidoController {
  public Stack<Pedido> filtrarPorZona(List<Pedido> pedidos, int umbral) {
    Stack<Pedido> pila = new Stack<>();
    for (Pedido p : pila) {
      if (p.getZona() > umbral) {
        pila.add(p);
      }  
    }
    return pila;
  }

  public TreeSet<Pedido> ordenarPorZona(Stack<Pedido> pila) {
    TreeSet<Pedido> set = new TreeSet<>();

      @Override

      public int compare(Pedido p1, Pedido p2) {
        if(p1.getCliente().equals(p2.getCliente && p1.getZona() == p2.getZona()) {
          return 0;
        }
        int res = Integer.compare(p1.getZona(), compare);

        return res != 0 ? res : p1.getCliente().compareTo(p2.getCliente());
      }
    
      set.addAll(pila);
    return set;
  }


  public TreeMap<Integer, Queue<Pedido>> agruparPorUrgencia(List<Pedido> pedidos) {
    TreeMap<Integer, Queue<Pedido>> maps = new TreeMap<>();
    for (Pedido p : pedidos) {
      maps.putIfAbsent(p.getUrgencia(), new LinkedList<>());
      maps.get(p.getUrgencia()).add(p);
    }
    return maps;
  }

  public Stack<Pedido> explotarGrupo(Map<Integer, Queue<Pedido>> mapa) {
    Stack<Pedido> result = new Stack<>();
    int maxCantidad = 0;
    int urgenciaSelc = 0;
    for (Map.Entry<Integer, Queue<Pedido>> entry :mapa.entrySet()) {
      int urg = entry.getKey();
      int cantidad = entry.getValue().size();
      if (cantidad > maxCantidad && (cantidad == maxCantidad && urg > urgenciaSelc)) {
        maxCantidad = cantidad;
        urgenciaSelc = urg;
      }
    }
    Queue<Pedido> cola = mapa.get(urgenciaSelc);
    while (!cola.isEmpty()) {
      result.push(cola.poll());  
    }

    return result;
  }
}
