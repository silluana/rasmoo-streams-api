package exercises.intermediateOperations;

import mock.Mock;

import java.util.stream.Collectors;

// Utilizando a operação intermediária 'FLATMAP', desenvolva as soluções para:
public class FlatMap {

    // 1) Retornar uma lista contendo os nomes de todos os produtos solicitados pelo cliente de nome 'Ana'
    public static void exercise1() {
        var orders = Mock.orders();

        var result = orders.stream()
                .filter(order -> order.getClient().getName().equalsIgnoreCase("ANA"))
                .flatMap(order -> order.getItems().stream())
                .map(orderItem -> orderItem.getProduct().getName())
                .collect(Collectors.toList());

        System.out.println(result);
    }

    public static void main(String[] args) {
        exercise1();
    }

}