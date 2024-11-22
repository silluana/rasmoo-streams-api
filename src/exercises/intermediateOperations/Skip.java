package exercises.intermediateOperations;

import mock.Mock;

import java.util.stream.Collectors;

public class Skip {
    public static void main(String[] args) {

        var clients = Mock.clients();

        var skippedNames = clients.stream()
                .skip(3)
                .peek(client -> System.out.println(client.getName()))
                .collect(Collectors.toList());

        System.out.println(skippedNames);
    }
}
