package exercises.intermediateOperations;

import mock.Mock;

import java.time.Month;
import java.util.stream.Collectors;

// Utilizando a operação intermediária 'FILTER', desenvolva as soluções para:
public class Filter {

    // 1) Retornar uma lista de clientes que começam com as letras 'MA'
    public static void exercise1() {
        var clients = Mock.clients();

        var result = clients.stream()
                .filter(client -> client.getName().toUpperCase().startsWith("MA"))
                .collect(Collectors.toList());

        System.out.println(result);
    }

    // 2) Retornar uma lista com todos os produtos que possuem o preço maior que R$ 2.000,00
    public static void exercise2() {
        var products = Mock.products();

        var result = products.stream()
                .filter(product -> product.getPrice() > 2000)
                .collect(Collectors.toList());

        System.out.println(result);
    }

    // 3) Retornar uma lista de todos os pedidos feitos por clientes que fazem aniversário no mês de Agosto
    public static void exercise3() {
        var orders = Mock.orders();

        var result = orders.stream()
                .filter(order -> order.getClient().getBirthDate().getMonth().equals(Month.AUGUST))
                .collect(Collectors.toList());

        System.out.println(result);
    }

    public static void main(String[] args) {
        //exercise1();
//        exercise2();
        exercise3();
    }


}
