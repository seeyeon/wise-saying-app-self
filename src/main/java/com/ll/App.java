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

                WiseSaying wiseSayings = new WiseSaying(id,content,author);

                sayingList.add(wiseSayings);


                System.out.println("%d번 명령이 등록되었습니다.".formatted(id));
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for(WiseSaying wiseSaying : sayingList.reversed()){
                    System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor()));
                }

            } else if(cmd.startsWith("삭제?id=")){
                String strId = cmd.substring(6);
                int deleteNum = Integer.parseInt(strId);

                WiseSaying wiseSaying;

                if(wiseSaying.getId()==deleteNum){
                    System.out.println("%d번 명령은 존재하지 않습니다.".formatted(deleteNum));
                }

                System.out.println("%d번 명령이 삭제되었습니다.".formatted(deleteNum));


            }

        }

        sc.close(); //해제해주는 것도 잊지 말자!
    }
}
