package ru.yandex.practicum.delivery;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> boxStandardParcel = new ParcelBox<>(60);
    private static ParcelBox<FragileParcel> boxFragileParcel = new ParcelBox<>(30);
    private static ParcelBox<PerishableParcel> boxPerishableParcel = new ParcelBox<>(40);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    getReportStatuses();
                    break;
                case 5:
                    showParcelBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Отправить информацию о текущем местоположении");
        System.out.println("5 - Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        System.out.println("Введите тип посылки (1 - стандартная, 2 - хрупкая, 3 - скоропортящаяся): ");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите описание посылки: ");
        String desc = scanner.nextLine();
        System.out.println("Введите вес посылки: ");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите адрес отправки: ");
        String address = scanner.nextLine();
        System.out.println("Введите день отправки: ");
        int day = Integer.parseInt(scanner.nextLine());
        switch (type) {
            case 1:
                StandardParcel parcel = new StandardParcel(desc, weight, address, day);
                allParcels.add(parcel);
                boxStandardParcel.addParcel(parcel);
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(desc, weight, address, day);
                allParcels.add(fragileParcel);
                trackableParcels.add(fragileParcel);
                boxFragileParcel.addParcel(fragileParcel);
                break;
            case 3:
                System.out.println("Введите срок хранения: ");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(desc, weight, address, day, timeToLive);
                allParcels.add(perishableParcel);
                boxPerishableParcel.addParcel(perishableParcel);
                break;
            default:
                System.out.println("Неверно выбран тип посылки.");
                break;
        }
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int sum = 0;
        for (Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость доставок: " + sum);
    }

    private static void getReportStatuses() {
        System.out.println("Введите новое местоположение: ");
        String newLocation = scanner.nextLine();
        for (Trackable parcel: trackableParcels) {
            parcel.reportStatus(newLocation);
        }
    }

    private static void showParcelBox() {
        System.out.println("Введите тип посылок (1 - стандартная, 2 - хрупкая, 3 - скоропортящаяся):");
        int type = Integer.parseInt(scanner.nextLine());
        switch (type) {
            case 1:
                boxStandardParcel.getAllParcels();
                break;
            case 2:
                boxFragileParcel.getAllParcels();
                break;
            case 3:
                boxPerishableParcel.getAllParcels();
                break;
            default:
                System.out.println("Неверно введен тип посылки.");
                break;
        }
    }

}
