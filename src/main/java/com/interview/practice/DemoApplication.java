package com.interview.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

	int count = 0;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

        Predicate<Integer> predicate =  n -> n % 2 == 0;
		List<Integer> numbers = List.of(5, 2, 9, 1 ,3);
//		numbers.stream()
//				.distinct()
//				.forEach(System.out::println);

//		numbers.stream()
//				.max(Comparator.reverseOrder()).get;
//				.for
//				.sorted(Compara)
//				.sorted(Comparator.reverseOrder())

//				.forEach(System.out::println);


		List<String> names = List.of("visa","java","spring");

//		names
		names.stream()
						.map(s -> s.toUpperCase())
								.forEach(System.out::println);

		numbers.stream()
				.map(n -> n * 10)
				.forEach(System.out::println);
//		Function<List<Integer>, String> print = n -> Demo
//		System.out.println(predicate.test(2));

		List<String> namses =
				List.of("Alice","Bob","Alex","Charlie");
		namses.stream()
				.filter(s -> s.startsWith("A"))
				.forEach(System.out::println);

		OpenThread op1 = new OpenThread();
		OpenThread op2 = new OpenThread();
		op1.run();


		ExecutorService executorService = Executors.newFixedThreadPool(10);
		executorService.execute(
				() -> {
					System.out.println("thread is running");
				});
	}

	private void printEven(int n){
		if(n % 2 == 0) System.out.println(n);
	}

	private void increment(){
		count++;
	}


}

class OpenThread implements Runnable{

	int count = 0;
	@Override
	public synchronized void run() {
		System.out.println("Thread is running");
		count ++;
	}
}


