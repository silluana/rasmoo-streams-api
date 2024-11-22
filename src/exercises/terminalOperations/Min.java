package exercises.terminalOperations;

import entity.OrderItem;
import entity.Product;
import mock.Mock;

import java.util.Comparator;

// Utilizando a operação terminal 'MIN', desenvolva as soluções para:
public class Min {

    // 1) Retornar o produto mais barato
    public static void exercise1() {
        var products = Mock.products();

        var result = products.stream()
                .min(Comparator.comparing(Product::getPrice));

        result.ifPresent(product -> {
            System.out.println("O produto: " + product.getName() + ", custa: " + product.getPrice());
        });

        System.out.println(result);
    }

    // 2) Retornar o cliente que possui a menor quantidade de letras no nome
    public static void exercise2() {
        var clients = Mock.clients();

        var result = clients.stream()
                .min(Comparator.comparing(client -> client.getName().length()));

        result.ifPresent(System.out::println);

        System.out.println(result);
    }

    // 3) Retornar o itemPedido mais barato, dentre todos os pedidos
    public static void exercise3() {
        var orders = Mock.orders();

        var result = orders.stream()
                .flatMap(order -> order.getItems().stream())
                        .min(Comparator.comparing(OrderItem::getPrice));

        System.out.println(result);
    }

    public static void main(String[] args) {
//        exercise1();
//        exercise2();
        exercise3();
    }

}