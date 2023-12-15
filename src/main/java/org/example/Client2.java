package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try {
            // Подключаемся к серверу
            Socket socket = new Socket("localhost", 8888);
            System.out.println("Подключено к серверу");

            // Получаем входной и выходной потоки для общения с сервером
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Получаем приветственное сообщение от сервера
            String serverMessage = in.nextLine();
            System.out.println(serverMessage);

            // Выбираем сторону (орел или решка)
            Scanner scanner = new Scanner(System.in);
            System.out.print("Выберите сторону (орел/решка): ");
            String choice = scanner.nextLine();

            // Отправляем выбор серверу
            out.println(choice);

            // Получаем сообщение от сервера
            serverMessage = in.nextLine();
            System.out.println(serverMessage);

            // Закрываем соединение с сервером
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}