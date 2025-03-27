package org.aleks.perov;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;

        while (true) {
            System.out.println("Выберите операцию и введите её номер:\n 1. Добавить новый доход\n " +
                    "2. Добавить новый расход\n 3. Выбрать систему налогообложения");

            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = sc.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расходов:");
                    String spendingMoneyStr = sc.nextLine();
                    int spendingMoney = Integer.parseInt(spendingMoneyStr);
                    spendings += spendingMoney;
                    break;
                case 3:
                    int taxEarningMinusSpeeding = taxEarningsMinusSpendings(earnings,spendings);
                    int taxEarning = taxEarning(earnings);
                    if(taxEarning < taxEarningMinusSpeeding){
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.printf("Ваш налог составит: %s рублей\n",taxEarning);
                        System.out.printf("Налог на другой системе: %s рублей\n",taxEarningMinusSpeeding);
                        System.out.printf("Экономия: %s рублей\n",taxEarningMinusSpeeding - taxEarning);

                    }
                    else if (taxEarningMinusSpeeding < taxEarning) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.printf("Ваш налог составит: %s рублей\n",taxEarningMinusSpeeding);
                        System.out.printf("Налог на другой системе: %s рублей\n",taxEarning);
                        System.out.printf("Экономия: %s рублей\n",taxEarning - taxEarningMinusSpeeding);
                    }
                    else {
                        System.out.println("Можете выбрать любую систему налогообложения");
                    }
                    break;

            }
        }
        System.out.println("Программа завершена!");
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax > 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarning(int earning) {
        int tax = 0;
        if (earning >= 1000) {
            tax = earning * 6 / 100;
        }
        return tax;
    }
}

