package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {

    public void run() {

        Scanner sc = new Scanner(System.in);
        System.out.println("===명언 앱===");
        int id = 0;

        List<WiseSaying> sayingList = new ArrayList<>();

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();


            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                ++id;

                WiseSaying wiseSayings =sayingList.add(id);

                System.out.println("%d번 명령이 등록되었습니다.".formatted(id));
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for(WiseSaying wiseSaying : wiseSayings){
                    System.out.println("%d / %s / %s".formatted());
                }

            }

        }

        sc.close(); //해제해주는 것도 잊지 말자!
    }
}
