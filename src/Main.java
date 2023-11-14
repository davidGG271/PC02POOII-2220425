import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        List<Integer> numerosAleatorios = Stream.generate(() -> new Random().nextInt(100) + 1)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("Numeros aleatoros");
        numerosAleatorios.forEach(System.out::println);

        // 1. Dada una lista de números enteros aleatorios, imprimir todos los números pares que
        //existen en la lista usando las funciones Stream. (1pto.)
        System.out.println("\nPunto 1:");
        numerosAleatorios.stream().filter(num -> num % 2 == 0).forEach(System.out::println);

        // 2. Dada una lista de números enteros aleatorios, imprimir todos los números que
        //comienzan con 5 usando las funciones Stream. (1pto.)
        System.out.println("\nPunto 2:");
        numerosAleatorios.stream().filter(num -> num.toString().startsWith("5")).forEach(System.out::println);

        // 3. Dada una lista de números enteros aleatorios, imprimir todos los números
        //duplicados usando las funciones Stream. (1pto.)
        System.out.println("\nPunto 3:");
        numerosAleatorios.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

        // 4. Dada una lista de números enteros aleatorios, imprimir el número total de
        //elementos presentes en la lista usando funciones Stream. (1pto.)
        System.out.println("\nPunto 4:");
        long totalElementos = numerosAleatorios.stream().count();
        System.out.println(totalElementos);

        // 5. Dada una lista de números enteros aleatorios, imprime todos los valores presentes
        //en ella en orden descendente utilizando las funciones Stream. (1pto.)
        System.out.println("\nPunto 5:");
        numerosAleatorios.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);


        //6. Dado un array de números enteros, devuelve true si algún valor aparece al menos
        //tres veces en el array y devuelve falso si cada elemento es distinto. (1.5 ptos.)
        System.out.println("\nPunto 6:");
        Integer[] arrayNumeros = new Integer[10];
        arrayNumeros[0] = 1;
        arrayNumeros[1] = 23;
        arrayNumeros[2] = 15;
        arrayNumeros[3] = 15;
        arrayNumeros[4] = 15;
        arrayNumeros[5] = 19;
        arrayNumeros[6] = 17;
        arrayNumeros[7] = 14;
        arrayNumeros[8] = 13;
        arrayNumeros[9] = 11;

        boolean hayRepetidos = Arrays.asList(arrayNumeros)
                .stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .values()
                .stream()
                .anyMatch(count -> count >= 3);
        System.out.println(hayRepetidos);

        // 7. Dado dos arrays de cadenas, se desea concatenar. Por ejemplo: A[n] =
        //{1,2,3,4,5,8,23} y B[m] = {4,6,8,0,2}, AB[n + m] = {1,2,3,4,5,8,23,4,6,8,0,2} (1.5
        //ptos.)
        System.out.println("\nPunto 7:");
        String[] arrayA = {"1", "2", "3", "4", "5", "8", "23"};
        String[] arrayB = {"4", "6", "8", "0", "2"};
        List<String> concatenados = Stream.concat(Arrays.stream(arrayA), Arrays.stream(arrayB))
                .collect(Collectors.toList());
        System.out.println(concatenados);

        // 8. Dado una lista de números enteros aleatorios, calcular el cubo de los números de
        //los elementos de lista y filtrar números mayores a 50. (1pto.)
        System.out.println("\nPunto 8:");
        List<Integer> cubos = numerosAleatorios.stream()
                .map(num -> num * num * num)
                .filter(num -> num > 50)
                .collect(Collectors.toList());
        System.out.println(cubos);

        // 9. ¿Cómo contabilizar el total de todos las palabras de un arreglo de cadena? (1pto.)
        System.out.println("\nPunto 9:");
        String[] palabras = {"Dos", "Dos", "Tres", "Cuatro", "Cinco"};
        long totalPalabras = Arrays.stream(palabras).count();
        System.out.println(totalPalabras);


        // 10. Dado un array de cadenas, ¿cómo encontramos solo elementos duplicados y el
        //número de veces? usando funciones Stream. (1.5 ptos.)
        System.out.println("\nPunto 10:");
        Arrays.stream(palabras)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // 11. ¿Qué te devuelve el método findFirst() y findAny() y qué diferencias tiene? (1.5
        //ptos.)
        System.out.println("\nPunto 11:");
        List<String> users = Arrays.asList("Amalia", "Jose",
                "Teresa", "Ana", "Daniel", "Alberto", "María");
        Optional<String> findFirst =
                users.parallelStream().filter(s ->
                        s.startsWith("A")).findFirst();
        Optional<String> findAny =
                users.parallelStream().filter(s ->
                        s.startsWith("A")).findAny();

        System.out.println("findFirst: " + findFirst);
        System.out.println("findAny: " + findAny);


        // 12. ¿Qué imprime los siguientes fragmentos de código y explique cuál es la diferencia
        //entre map y flatmap? (1.5 ptos.)
        System.out.println("\nPunto 12:");

        Map<String, List<String>> user = new HashMap<>();
        user.put("Carolina", Arrays.asList("051-922-977234",
                "051-998-92223"));
        user.put("Bertha", Arrays.asList("051-991-927204",
                "051-991-96263"));
        user.put("Marco", Arrays.asList("051-931-977003",
                "051-961-98861"));
        List<String> names = user.keySet().stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.print(names);
        List<String> phones = user.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(phones);

    }
}