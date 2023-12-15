package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            // Создаем серверный сокет
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Ждем подключения клиентов...");

            // Принимаем первого клиента
            Socket client1 = serverSocket.accept();
            System.out.println("Первый клиент подключен: " + client1.getInetAddress());

            // Отправляем сообщение первому клиенту
            PrintWriter out1 = new PrintWriter(client1.getOutputStream(), true);
            out1.println("Добро пожаловать в игру \"Орёл и решка\"! Вы первый игрок.");

            // Принимаем выбор первого клиента
            Scanner in1 = new Scanner(client1.getInputStream());
            String client1Choice = in1.nextLine();
            System.out.println("Выбор первого клиента: " + client1Choice);

            // Принимаем второго клиента
            Socket client2 = serverSocket.accept();
            System.out.println("Второй клиент подключен: " + client2.getInetAddress());

            // Отправляем сообщение второму клиенту
            PrintWriter out2 = new PrintWriter(client2.getOutputStream(), true);
            out2.println("Добро пожаловать в игру \"Орёл и решка\"! Вы второй игрок.");

            // Принимаем выбор второго клиента
            Scanner in2 = new Scanner(client2.getInputStream());
            String client2Choice = in2.nextLine();
            System.out.println("Выбор второго клиента: " + client2Choice);

            // Проверяем, что выборы клиентов не совпадают
            if (client1Choice.equals(client2Choice)) {
                String message = "Выборы клиентов совпадают. Пожалуйста, выберите разные стороны.";
                out1.println(message);
                out2.println(message);
                client1.close();
                client2.close();
                serverSocket.close();
                return;
            }

            // Бросаем монетку
            Random random = new Random();
            int coin = random.nextInt(2) + 1;
            System.out.println("Монетка брошена: " + coin);

            // Определяем победителя
            String winner;
            if ((client1Choice.equals("орел") && coin == 1) || (client1Choice.equals("решка") && coin == 2)) {
                winner = "Первый игрок";
            } else {
                winner = "Второй игрок";
            }

            // Отправляем результаты игры клиентам
            String message = "Монетка выпала: " + coin + ". Победитель: " + winner + "!";
            out1.println(message);
            out2.println(message);

            // Закрываем соединение с клиентами
            client1.close();
            client2.close();

            // Закрываем серверный сокет
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}