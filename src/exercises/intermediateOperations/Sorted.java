package exercises.intermediateOperations;

import entity.Client;
import entity.OrderItem;
import entity.Product;
import mock.Mock;

import java.util.Comparator;
import java.util.stream.Collectors;

// Utilizando a operação intermediária 'SORTED', desenvolva as soluções para:
public class Sorted {

    // 1) Retornar uma lista contendo os nomes de todos os clientes em ordem alfabética
    public static void exercise1() {
        var clients = Mock.clients();

        var result = clients.stream()
                .map(Client::getName)
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(result);
    }

    // 2) Retornar uma lista de produtos ordenados pelo preço de forma decrescente
    public static void exercise2() {
        var products = Mock.products();

        var result = products.stream()
                .sorted(Comparator.comparing(Product::getPrice, Comparator.reverseOrder()))
                .peek(product -> System.out.println(product.getName() + " - " + product.getPrice()))
                .collect(Collectors.toList());

        System.out.println(result);
    }

    // 3) Retornar uma lista contendo todos os itens referente ao pedido feito pela cliente 'Ana'.
    //    Os itens devem estar ordenados de forma crescente pelo preço
    public static void exercise3() {
        var orders = Mock.orders();

        var result = orders.stream()
                .filter(order -> order.getClient().getName().equalsIgnoreCase("ANA"))
                .flatMap(order -> order.getItems().stream())
                .sorted(Comparator.comparing(OrderItem::getPrice))
                .peek(orderItem -> System.out.println(orderItem.getProduct().getName() + ": " + orderItem.getAmount() + " - " + orderItem.getPrice()))
                .collect(Collectors.toList());

        System.out.println(result);
    }

    public static void main(String[] args) {
//        exercise1();
//        exercise2();
        exercise3();
    }

}